package com.justynsoft.da.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTester {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->{
         return 1 / 1;
         });

         System.out.println(future.join());
         System.out.println(future.get());
         **/

        CompletableFutureTester tester = new CompletableFutureTester();
        tester.parallelCalculator(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//        tester.asyncCalculator(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//        tester.asyncCalculatorV2(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    }

    public void parallelCalculator(List<Integer> list) {
        System.out.println("how many core: " + Runtime.getRuntime().availableProcessors());
        List<Integer> result = list.stream().parallel().map(e -> {
            System.out.println(e + " thread name: " + Thread.currentThread().getName());
            return e * 10;
        }).collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    public void asyncCalculator(List<Integer> list) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(list.size(), 1000));
        CompletableFuture<Integer>[] results = list.stream().map(e -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println(e + " current thread name: " + Thread.currentThread().getName());
                return e * 10;
            }, executorService);
        }).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(results).join();
        Arrays.asList(results).forEach(e -> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ExecutionException executionException) {
                executionException.printStackTrace();
            }
        });
        executorService.shutdown();
    }


    public void asyncCalculatorV2(List<Integer> list) {
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(list.size(), 1000));

        List<Integer> result = list.stream().map(e -> CompletableFuture.supplyAsync(() -> {
            return e * 10;
        }, executorService)).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());

        executorService.shutdown();
        result.forEach(System.out::println);

    }
}
