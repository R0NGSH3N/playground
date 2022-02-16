package com.justynsoft.da.tree;

public class SubTreeWithMaxAverage {

    public Result currentMaxResult;
    public TreeNode currentMaxNode;

   public void main(String[] args){

   }

   public class TreeNode{
       public int val;
       public TreeNode leftNode;
       public TreeNode rightNode;
       public TreeNode(int val){
           this.val = val;
           this.leftNode = this.rightNode = null;
       }
   }

   public class Result{
       public int sum;
       public int size;

       public Result(int sum, int size){
           this.sum = sum;
           this.size = size;
       }
   }

   public TreeNode findSubtree(TreeNode root){
       recursiveFind(root);
       return currentMaxNode;
   }

   public Result recursiveFind(TreeNode root){
      //define the exic condition -- leaf
       if(root.leftNode == null && root.rightNode == null){
            return new Result(root.val, 1);
       }

       //divide
       Result leftResult = recursiveFind(root.leftNode);
       Result rightResult = recursiveFind(root.rightNode);

       //check
       int totalSum = leftResult.sum + rightResult.sum + root.val;
       int totalSize = leftResult.size + rightResult.size +  1;

       if(totalSum/totalSize >= currentMaxResult.sum/currentMaxResult.size){
           this.currentMaxResult = new Result(totalSum,totalSize);
           this.currentMaxNode = root;
           return currentMaxResult;
       }else{
           return new Result(totalSum, totalSize);
       }

   }
}

