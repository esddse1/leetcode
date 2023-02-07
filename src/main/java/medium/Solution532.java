package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution532 {

    public static void main(String[] args){
        Solution532 solution532=new Solution532();
        System.out.println(solution532.findPairs(new int[]{3, 1, 4, 1, 5},2));
        System.out.println(solution532.findPairs(new int[]{1, 2, 3, 4, 5},1));
        System.out.println(solution532.findPairs(new int[]{1, 3, 1, 5, 4},0));
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int result = 0;
        Set<Integer> set=new HashSet<>();
        while (left <nums.length& right<nums.length){
            if (left==right) right++;
            else if (nums[left]<nums[right]-k){
                left++;
            }
            else if (nums[left]>nums[right]-k){
                right++;
            }
            else{
                set.add(nums[left]);
                if (left+1< nums.length&&nums[left+1]==nums[left]) left++;
                else right++;
            }
        }
        return set.size();
    }
}
