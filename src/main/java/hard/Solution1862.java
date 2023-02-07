package hard;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution1862 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/code/leetcode/test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String msg = br.readLine();
        String[] split = msg.split(",");
        int[] nums = new int[split.length];
        for (int i=0;i<split.length;i++){
            nums[i]=Integer.parseInt(split[i]);
        }
        System.out.println(sumOfFlooredPairs(nums));
    }

    public static int sumOfFlooredPairs(int[] nums) {
        int modnum  = (int) (Math.pow(10,9)+7);
        Arrays.sort(nums);
        int sum = 0;
        int index=0;
        int lastValue = -1;
        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i]==nums[i-1] && lastValue>0){
                sum = (sum +lastValue) % modnum;
            }
            else {
                if (i > 0 && nums[i] > nums[i - 1])
                    index = i;
                lastValue = (nums.length - index) % modnum;
                for (int j = 2; j * ((long) nums[i]) <= (long) nums[nums.length - 1]; j++) {
                    int position = findFirst(nums, j * nums[i]);
                    if (position >= 0) {
                        lastValue = (lastValue + nums.length - position) % modnum;
                    }
                }
                sum = (sum + lastValue) % modnum;
            }
        }
        return sum;
    }


    public static int findFirst(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        if (nums[left]>=target) return 0;
        if (nums[right]<target) return -1;
        int mid  = (left+right)/2;
        while (left<right){
            if (nums[mid] >=target){
                right = mid;
            }
            else {
                left = mid+1;
            }
            mid = (left +right )/2;
        }
        return left;
    }
}
