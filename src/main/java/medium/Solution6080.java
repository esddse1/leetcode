package medium;

import java.util.Stack;

public class Solution6080 {

    public static void main(String[] args){
        Solution6080 solution6080=new Solution6080();
        System.out.println(solution6080.totalSteps(new int[]{10,1,2,3,4,5,6,1,2,3}));//6
        System.out.println(solution6080.totalSteps(new int[]{7,14,4,14,13,2,6,13}));//3
    }

    public int totalSteps(int[] nums) {
        if (nums.length==1) return 0;
        int maxLength = 0;
        int[] maxArray=new int[nums.length];
        Stack<Node> stack=new Stack<>();
        stack.push(new Node(nums.length-1,nums[nums.length-1],0));
        for (int i=nums.length-2;i>=0;i--){
            int count = 0;
            while (!stack.isEmpty() && nums[i]>stack.peek().value){
                count++;
                count= Math.max(count,stack.peek().sum);
                maxArray[stack.peek().index]=count;
                stack.pop();
            }
            stack.push(new Node(i,nums[i],count));
        }
        for (int i=0;i<maxArray.length;i++){
            maxLength=Math.max(maxLength,maxArray[i]);
        }
        return maxLength;
    }

    class Node{
        int index;
        int value;
        int sum;
        public Node(int index,int value,int sum){
            this.index=index;this.value=value;this.sum=sum;
        }
    }
}
