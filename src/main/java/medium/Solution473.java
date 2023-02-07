package medium;

import java.util.Arrays;

public class Solution473 {

    public static void main(String[] args){
        Solution473 solution473=new Solution473();
        System.out.println(solution473.makesquare(new int[]{1,1,2,2,2}));
//        System.out.println(solution473.makesquare(new int[]{3,3,3,3,4}));

    }
    public boolean makesquare(int[] matchsticks) {
        long sum = Arrays.stream(matchsticks).sum();
        if (sum%4!=0) return false;
        Arrays.sort(matchsticks);
        boolean result =  makesquare(matchsticks,0,0,0,0,0,sum/4);
        return result;
    }


    public boolean makesquare(int[] arr,int start, int sumA, int sumB,int sumC,int sumD,long target){
        if (sumA>target || sumB>target|| sumC>target|sumC>target) return false;
        if (start==arr.length){
            return sumA == target && sumB == target && sumC == target && sumD == target;
        }
        else{
            int[] newArr = new int[]{sumA,sumB,sumC,sumD};
            Arrays.sort(newArr);
            sumA=newArr[0];
            sumB=newArr[1];
            sumC=newArr[2];
            sumD=newArr[3];
            int newInt=arr[start];
            if (sumA+newInt<=target && makesquare(arr,start+1,sumA+newInt,sumB,sumC,sumD,target)) return true;
            else if (sumB+newInt<=target &&sumB!=sumA && makesquare(arr,start+1,sumA,sumB+newInt,sumC,sumD,target)) return true;
            else if (sumC+newInt<=target &&sumC!=sumB && makesquare(arr,start+1,sumA,sumB,sumC+newInt,sumD,target)) return true;
            else return sumD+newInt<=target &&sumD != sumC && makesquare(arr, start + 1, sumA, sumB, sumC, sumD + newInt, target);
        }
    }
}
