package medium;

import java.util.*;

public class Solution220 {

    public static void main(String[] args){
//        System.out.println(Math.floor(1.0*-1/2));
        Solution220 solution220=new Solution220();
//        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0));
//        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{1,0,1,1},1,2));
//        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{2147483647,-1,2147483647},1,2147483647));
    }


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long,Node> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (i>k){
                Long key =  (long) Math.floor((1.0*nums[i-k-1]/(((long)t)+1)));
                map.remove(key);
            }
            long key = (long) Math.floor((1.0*nums[i]/(((long)t)+1)));
            if (map.containsKey(key)) {
                return true;
            }
            else{
                Node nodeLeft = map.get(key-1);
                Node nodeRight = map.get(key+1);
                if (nodeLeft!=null && Math.abs(nodeLeft.value-nums[i])<=t)
                    return true;
                if (nodeRight!=null && Math.abs(nodeRight.value-nums[i])<=t)
                    return true;
                map.put((key), new Node(nums[i], i));
            }
        }
        return false;
    }

    class Node {
        long value;
        long position;
        public Node(long value,long position){
            this.value=value;this.position=position;
        }
    }


}
