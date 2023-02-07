package unfinished;

import java.util.Arrays;

public class Solution324 {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length-1;i=i+2){
            swap(nums,nums[i],nums[i+1]);
        }
    }

    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
