package easy;

import java.util.Arrays;

public class Solution6096 {

    public static void main(String[] args){
        Solution6096 solution6096=new Solution6096();
        System.out.println(Arrays.toString(solution6096.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int [] result=new int[spells.length];
        Arrays.sort(potions);
        for (int i=0;i<spells.length;i++){
            long target = (long) Math.ceil(success*1.0/spells[i]);
            int location = binarySearch(potions,target);
            if (location==-1) result[i]=0;
            else result[i]=potions.length-location;
        }
        return result;
    }

    private int binarySearch(int[] potions,long target){
        int left = 0;
        int right =potions.length-1;
        if (potions[right]<target) return -1;
        while (left<right){
            if (right-left<=1){
                if (potions[left]>=target) return left;
                if (potions[right]>=target) return right;
            }
            int mid =(left+right)/2;
            if (potions[mid]<target) left=mid+1;
            else{
                right=mid;
            }
        }
        if (potions[left]>=target) return left;
        return -1;
    }


}
