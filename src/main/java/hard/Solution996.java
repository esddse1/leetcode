package hard;

import java.util.HashSet;
import java.util.Set;

public class Solution996 {
    public static void main(String[] args){
        Solution996 solution996=new Solution996();
        System.out.println(solution996.numSquarefulPerms(new int[]{2,2,2}));
    }
    public int numSquarefulPerms(int[] nums) {
        int result = 0;
        Set<Integer> existSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!existSet.contains(nums[i])) {
                existSet.add(nums[i]);
                swap(nums, 0, i);
                result = result + numSquarefulPerms(nums, 0);
                swap(nums, i, 0);
            }
        }
        return result;
    }

    public int numSquarefulPerms(int[] nums, int startIndex) {
        if (startIndex == nums.length - 2) return isSquarefulNum(nums[startIndex] + nums[startIndex + 1]) ? 1 : 0;
        else {
            int sum = 0;
            Set<Integer> existSet = new HashSet<>();
            for (int j = startIndex + 1; j < nums.length; j++) {
                if (isSquarefulNum(nums[startIndex] + nums[j]) && !existSet.contains(nums[j])) {
                    existSet.add(nums[j]);
                    swap(nums, startIndex + 1, j);
                    sum = sum + numSquarefulPerms(nums, startIndex + 1);
                    swap(nums, startIndex + 1, j);
                }
            }
            return sum;
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }

    public boolean isSquarefulNum(int s) {
        return Math.floor(Math.sqrt(s)) == Math.sqrt(s);
    }

}

