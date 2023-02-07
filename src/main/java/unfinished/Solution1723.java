package unfinished;

import java.util.Arrays;

public class Solution1723 {

    public static void main(String[] args){
        Solution1723 solution1723=new Solution1723();
        System.out.println(solution1723.minimumTimeRequired(new int[]{1,2,4,7,8},2));
    }


    public int minimumTimeRequired(int[] jobs, int k) {
        if (k==1) return Arrays.stream(jobs).sum();
        int[][] resultArr=new int[k+1][jobs.length];
        resultArr[1][0]=jobs[0];
        for (int i=1;i<jobs.length;i++) resultArr[1][i] = resultArr[1][i-1]+jobs[i];
        for (int i=2;i<=k;i++){
            for (int j=0;j<jobs.length;j++){
                if (j<=k){
                    int max=0;
                    for (int u=0;u<j;u++){
                        max=Math.max(max,u);
                    }
                    resultArr[i][j]=max;
                }
                else{
                    int min = resultArr[i-1][j];
                    int currentSum=0;
                    for (int u=j;u>=1;u--){
                        currentSum=currentSum+jobs[j];
                        min=Math.min(min,Math.max(currentSum,resultArr[i-1][u-1]));
                    }
                    resultArr[i][j]=min;
                }
            }
        }
        System.out.println(Arrays.deepToString(resultArr));
        return resultArr[k][jobs.length-1];
    }
}
