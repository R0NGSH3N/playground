package com.justynsoft.da.stack;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid(""));
        System.out.println(isValid("(("));
        System.out.println(isValid("))"));
    }

    public static boolean isValid(String s){
        Map<Character, Character> mapping = new HashMap();
        mapping.put(')','(');
        mapping.put(']','[');
        mapping.put('}','{');

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{'){
                stack.push(arr[i]);
            }

            if(arr[i] == ')' || arr[i] == ']' || arr[i] == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char lastPos = stack.pop();
                if(lastPos != mapping.get(arr[i])){
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

    public static boolean isValidOLD2(String s){
        Stack<Integer> smallStack = new Stack<>();
        Stack<Integer> middlStack = new Stack<>();
        Stack<Integer> largeStack = new Stack<>();

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++){

            if(arr[i] == '('){
                smallStack.push(i);
            }

            if(arr[i] == '['){
                middlStack.push(i);
            }

            if(arr[i] == '{'){
                largeStack.push(i);
            }

            if(arr[i] == ')'){
                if(smallStack.size() == 0){
                    return false;
                }
               int lastPosS = smallStack.pop();
               int lastPosM = middlStack.size() == 0 ? -1 : middlStack.lastElement();
               int lastPosL = largeStack.size() == 0 ? -1 :largeStack.lastElement();


               if(lastPosS < lastPosM){
                   return false;
               }else if(lastPosS < lastPosL){
                   return false;
               }
            }

            if(arr[i] == ']'){
                if(middlStack.size() == 0){
                    return false;
                }
                int lastPosS = smallStack.size() == 0 ? -1 : smallStack.lastElement();
                int lastPosM = middlStack.pop();
                int lastPosL = largeStack.size() == 0 ? -1 : largeStack.lastElement();

                if(lastPosM < lastPosS){
                    return false;
                }else if(lastPosM < lastPosL){
                    return false;
                }
            }

            if(arr[i] == '}'){
                if(largeStack.size() == 0){
                    return false;
                }
                int lastPosS = smallStack.size() == 0 ? -1 : smallStack.lastElement();
                int lastPosM = middlStack.size() == 0 ? -1 : middlStack.lastElement();
                int lastPosL = largeStack.pop();

                if(lastPosL < lastPosS){
                    return false;
                }else if(lastPosL < lastPosM){
                    return false;
                }
            }
        }


        if(smallStack.size() == 0 && middlStack.size() == 0 && largeStack.size() ==0){
            return true;
        }else{
            return false;
        }
    }

//    public static boolean isValidOLD(String s) {
//        List<Integer> smallParOpenPos = new ArrayList();
//        List<Integer> middleParOpenPos = new ArrayList<>();
//        List<Integer> largeParOpenPos = new ArrayList<>();
//        char[] arr = s.toCharArray();
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] == '('){
//                smallParOpenPos.add(i);
//            }
//            if(arr[i] == ')'){
//                if(smallParOpenPos.size() == 0) {
//                    return false;
//                }
//                int lastPos = smallParOpenPos.get(smallParOpenPos.size() - 1);
//
//            }
//
//            if(arr[i] == '['){
//                middleParOpenPos.add(i);
//            }
//            if(arr[i] == ']'){
//                middlePar--;
//            }
//
//            if(arr[i] == '{'){
//                largeParOpenPos.add(i);
//            }
//            if(arr[i] == '}'){
//                largePar--;
//            }
//        }
//
//        if(smallPar == 0 && middlePar == 0 && largePar == 0){
//            return true;
//        }else{
//            return false;
//        }
//
//    }
}
