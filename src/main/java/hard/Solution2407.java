package hard;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2407 {

    public static void main(String[] args){
//        System.out.println(lengthOfLIS(new int[]{7,4,5,1,8,12,4,7},5));
        System.out.println(lengthOfLIS(new int[]{1,100,500,100000,100000},100000));
    }


    public static int lengthOfLIS(int[] nums, int k) {
        int[] maxU=new int[nums.length];
        Node[] arrs = new Node[nums.length];
        for (int i=0;i< nums.length;i++){
            arrs[i]=new Node(i,nums[i]);
        }
        Arrays.sort(arrs, Comparator.comparingInt(o -> o.value));
        for (int i=0;i<nums.length;i++){
            if (i==0){
                maxU[i]=1;
            }
            else{
                int max =1;
                int firstPosition = findPosition(arrs,arrs[i].value);
                if (firstPosition!=-1) {
                    for (int j = firstPosition; j >= 0 && arrs[i].value - arrs[j].value <= k; j--) {
                        if (arrs[j].position < arrs[i].position && arrs[i].value > arrs[j].value) {
                            max = Math.max(max, maxU[j] + 1);
                        }
                    }
                }
                maxU[i]=max;
            }
        }
        int result =0;
        for (int i=0;i< nums.length;i++){
            result=Math.max(maxU[i],result);
        }
        return result;
    }

    private static int findPosition(Node[] nums,int target){
        int left =0;int right =nums.length-1;
        if (nums[left].value>=target) return -1;
        if (nums[right].value<target) return right;

        while (left < right){
            int mid = (left + right+1)/2;
            if (nums[mid].value>=target){
                right = mid-1;
            }
            else{
                left = mid;
            }
        }
        return left;
    }

    static class Node{
        int position;
        int value;
        public Node(int position,int value){
            this.position=position;
            this.value=value;
        }
    }
}
