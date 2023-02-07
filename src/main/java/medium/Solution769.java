package medium;

import java.util.Arrays;

public class Solution769 {
    public static void main(String[] args){
        Solution769 solution769=new Solution769();
        System.out.println(solution769.maxChunksToSorted(new int[]{1,4,0,2,3,5}));
    }
    public int maxChunksToSorted(int[] arr) {
        if (arr.length==1) return 1;
        int currentMin=arr.length-1;
        int sum=0;
        for (int i=arr.length-1;i>=0;i--){
            for (int j=0;j<=i;j++){
                if (j==i){
                    if (currentMin>=i) {
                        sum++;
                    }
                }
                else{
                    if (arr[j]>arr[i]){
                        currentMin=Math.min(currentMin,j);
                    }
                }
            }
        }
        return sum;
    }

    public int maxChunksToSorted(int[] arr,int end){
        if (end==0) return 1;
        int currentMin=-1;
        for (int i=0;i<end;i++){
            if (arr[i]>arr[end]){
                if (i==0) return 1;
                return maxChunksToSorted(arr,i);
            }
        }
        return maxChunksToSorted(arr,end-1)+1;
    }
}
