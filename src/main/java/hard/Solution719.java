package hard;

import java.util.Arrays;

public class Solution719 {

    public static void main(String[] args){
        Solution719 solution719=new Solution719();
        System.out.println(solution719.smallestDistancePair(new int[]{1,3,1},1));
        System.out.println(solution719.smallestDistancePair(new int[]{62,100,4},2));
        System.out.println(solution719.smallestDistancePair(new int[]{2,2,0,1,1,0,0,1,2,0},2));
        //[2,2,0,1,1,0,0,1,2,0]
        //2
        System.out.println(solution719.smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8},18));
        //[9,10,7,10,6,1,5,4,9,8]
        //18
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length-1]-nums[0];
        int left =0; int right = max;
        while (left<right){
            if (right-left<=1){
                if (countNum(nums,left)>=k) return left;
                return right;
            }
            int mid = (left+right)/2;
            if (countNum(nums,mid)<k){
                left = mid+1;
            }
            else right = mid;
        }
        return left;

    }

    //xiaoyudengyu k de you duoshaodui
    public int countNum(int[] nums,int k){
        int result = 0;
        for (int i = 0;i<nums.length-1;i++){
            int target = nums[i]+k;
            if (target>nums[nums.length-1]) {
                result = result + nums.length -1 - i ;
            }
            else{
                int tmp = findMaxSmallThanTarget(nums,target,i+1,nums.length-1);
                if (tmp>0) result=result+(tmp-i);
            }
        }
        return result;
    }

    public int findMaxSmallThanTarget(int[] nums,int target,int start , int end){
        int left= start ;int right = end;
        if (nums[left]>target) return -1;
        while (left<right){
            if (right-left<=1){
                if (nums[right]<=target) return right;
                return left;
            }
            int mid = (left+right)/2;
            if (nums[mid]>target){
                right=mid-1;
            }
            else left = mid;
        }
        return left;
    }


}
