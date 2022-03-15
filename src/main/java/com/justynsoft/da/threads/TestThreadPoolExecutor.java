package com.justynsoft.da.threads;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPoolExecutor {

    public static void main(String[] args) {
        RejectedExecutionHandler executionHandler = (r, executor) -> {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RejectedExecutionException("Producer thread interrupted", e);
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(4),
                new ThreadFactoryBuilder().setNameFormat("Test-ThreadPoolExecutor-Thread-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        final List<Integer> counter = Collections.synchronizedList(new ArrayList<>());
        counter.add(0);
        for(int i = 0 ; i <  4 ; i++){
            threadPoolExecutor.execute(() -> {
                counter.set(0, counter.get(0) + 1);
                try {
                    System.out.println(Thread.currentThread().getName() + " is running on task " + counter.get(0));
                    Thread.sleep(10000);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            });
            System.out.println("number of threads in pool: " + threadPoolExecutor.getPoolSize() + " queue size: " + threadPoolExecutor.getQueue().size() + " completed task count: " + threadPoolExecutor.getCompletedTaskCount());
        }

        threadPoolExecutor.shutdown();
        System.out.println("ThreadPoolExecutor complete");
    }

}
