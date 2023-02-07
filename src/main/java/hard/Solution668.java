package hard;

public class Solution668 {


    public static void main(String[] args){
        Solution668 solution668=new Solution668();
        System.out.println(solution668.findLowerOrEqualThanK(11,13,24));
        System.out.println(solution668.findKthNumber(11,13,57));

    }

    public int findKthNumber(int m, int n, int k) {
        int left=1;int right=m*n;
        while (left<right){
            int mid = (left + right)/2;
            int current = findLowerOrEqualThanK(m,n,mid);
            if (current < k ){
                left = mid+1;
            }
            if (current>k){
                right=mid;
            }
            if (current==k){
                if (mid == right){
                    return mid;
                }
                right=mid;
            }
        }
        return left;

    }

    public int findLowerOrEqualThanK(int m,int n,int k){
        if (m<n) return findLowerOrEqualThanK(n,m,k);
        int sum=0;
        for (int i=1;i<=n;i++){
            if (i>k) return sum;
            sum=sum+Math.min(m,k/i);
        }
        return sum;
    }
}
