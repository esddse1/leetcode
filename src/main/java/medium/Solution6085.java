package medium;

import java.util.Arrays;

public class Solution6085 {

    public static void main(String[] args){
        Solution6085 solutionC=new Solution6085();
        System.out.println(solutionC.maximumImportance(5,new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}}));
    }

    public long maximumImportance(int n, int[][] roads) {
        int[] countArr=new int[n];
        for (int i=0;i<roads.length;i++){
            countArr[roads[i][0]]++;
            countArr[roads[i][1]]++;
        }
        Arrays.sort(countArr);
        long result=0;
        for (int i=0;i<countArr.length;i++){
            result=result+ ((long) countArr[i]) *(i+1);
        }
        return result;
    }




}
