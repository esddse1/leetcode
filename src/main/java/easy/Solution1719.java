package easy;

import java.util.Arrays;

public class Solution1719 {

    public static void main(String[] args){
        Solution1719 solution1719=new Solution1719();
        System.out.println(Arrays.toString(solution1719.missingTwo(new int[]{2,3})));
    }
    public int[] missingTwo(int[] nums) {
        int[] result=new int[2];result[0]=nums.length+1;result[1]=nums.length+2;
        for (int i=0;i< nums.length;i++){
            if (nums[i]!=i+1){
                while (nums[i]!=i+1){
                    if (nums[i]>nums.length){
                        result[nums[i]-nums.length-1] = i+1;
                        break;
                    }
                    else{
                        swap(nums,i,nums[i]-1);
                    }
                }
            }
        }
        return result;
    }

    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
