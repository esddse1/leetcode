package easy;

public class Solution6098 {


    public static void main(String[] args){
        Solution6098 solution6098=new Solution6098();
        System.out.println(solution6098.countSubarrays(new int[]{2,1,4,3,5},10));
        System.out.println(solution6098.countSubarrays(new int[]{1,1,1},5));
    }

    public long countSubarrays(int[] nums, long k) {
        long[] result =new long[nums.length];
        long[] sumArr =new long[nums.length];
        for (int i=0;i<nums.length;i++){
            if (i==0) sumArr[i]= nums[i];
            else sumArr[i]=sumArr[i-1]+nums[i];
            int location = binarySearch(sumArr,i,k);
            int tmpAns = location==-1?0:i-location+1;
            if (i>=1) {
                result[i] = tmpAns + result[i - 1];
            }
            else result[i] = tmpAns;
        }
        return result[nums.length-1];
    }

    public int binarySearch(long[] sumArr,int endIndex,long k){
        int left = 0;
        int right = endIndex;
        if (getSum(sumArr,endIndex,endIndex)>=k) return -1;
        while (left<right){
            if (right-left<=1){
                if ((long)getSum(sumArr,left,endIndex)*(endIndex-left+1)<k) return left;
                if ((long)getSum(sumArr,right,endIndex)*(endIndex-right+1)<k) return right;
            }
            int mid = (left+right+1)/2;
            if ((long)getSum(sumArr,mid,endIndex)*(endIndex-mid+1)>=k) left = mid+1;
            else{
                right = mid;
            }
        }
        if ((long)getSum(sumArr,left,endIndex)*(endIndex-left+1)<k) return left;
        return -1;
    }

    public long getSum(long[] sumArr,int start,int end){
        if (start==0) return sumArr[end];
        return sumArr[end]-sumArr[start-1];
    }
}
