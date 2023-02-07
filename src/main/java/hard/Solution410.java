package hard;

import java.util.Arrays;

public class Solution410 {


    public static void main(String[] args){
        Solution410 solution410=new Solution410();
        System.out.println(solution410.splitArray(new int[]{10,5,13,10},3));
    }

    public int splitArray(int[] nums, int m) {
        if (m==1) return Arrays.stream(nums).sum();
        int[][] resultArr=new int[m+1][nums.length];
        resultArr[1][0]=nums[0];
        for (int i=1;i<nums.length;i++)
            resultArr[1][i] = resultArr[1][i-1]+nums[i];
        for (int i=2;i<=m;i++){
            for (int j=0;j<nums.length;j++){
                if (j+1<=i){
                    int max=0;
                    for (int u=0;u<=j;u++){
                        max=Math.max(max,nums[u]);
                    }
                    resultArr[i][j]=max;
                }
                else{
                    int min = resultArr[i-1][j];
                    int currentSum=0;
                    for (int u=j;u>=1;u--){
                        currentSum=currentSum+nums[u];
                        min=Math.min(min,Math.max(currentSum,resultArr[i-1][u-1]));
                    }
                    resultArr[i][j]=min;
                }
            }
        }
        return resultArr[m][nums.length-1];
    }
}
