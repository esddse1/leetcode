package medium;

import java.util.Arrays;

public class Solution875 {

    public static void main(String[] args){

    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left<right){
            if (right-left<=1){
                if (sumValue(piles,left,h)) return left;
                else return right;
            }
            int mid = (left + right)/2;
            if (sumValue(piles,mid,h)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }

    public boolean sumValue(int[] piles,int speed,int target){
        long sum =0;
        for (int pile : piles) {
            sum = (long) (sum + Math.ceil(1.0 * pile / speed));
            if (sum > target) return false;
        }
        return true;
    }
}
