package com.justynsoft.da.stack;

import java.util.Iterator;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args){
        SimplifyPath obj = new SimplifyPath();
        obj.simplifyPath("/home/");
        obj.simplifyPath("/../");
        obj.simplifyPath("/home//foo/");
        obj.simplifyPath("/a/./b/../../c/");
        obj.simplifyPath("/a/../../b/../c//.//");
        obj.simplifyPath("/a//b////c/d//././/..");
    }

    public String simplifyPath(String path) {
        Stack<String> validPath = new Stack<>();
        String[] originalPath = path.split("/");
        for(int i = 0; i < originalPath.length; i++){
            if(originalPath[i].length() > 0 && !originalPath[i].equals(".") && !originalPath[i].equals("..")){
                validPath.push(originalPath[i]);
            }else if(originalPath[i].equals("..")){
                if(!validPath.isEmpty()){
                    validPath.pop();
                }
            }
        }

        Iterator<String> itr = validPath.iterator();
        StringBuilder sb = new StringBuilder("/");
        while(itr.hasNext()){
            sb.append(itr.next() + "/");
        }

        System.out.println(sb.substring(0, sb.length()-1));
        if(sb.toString().equals("/")){
            return sb.toString();
        }else{
            //remove the tail slash
            return sb.substring(0, sb.length()-1);
        }
    }
}
