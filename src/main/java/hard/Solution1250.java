package hard;

public class Solution1250 {

    public boolean isGoodArray(int[] nums) {
        if (nums.length==1) return nums[0]==1;
        int current = nums[0];
        for (int i=1;i< nums.length;i++){
            current = gcd(current,nums[i]);
            if (current==1) return true;
        }
        return false;
    }

    public int gcd(int a,int b){
        if (a==1 || b==1) return 1;
        if (a<b) return gcd(b,a);
        if (a%b==0) return b;
        return gcd(a%b,b);
    }
}
