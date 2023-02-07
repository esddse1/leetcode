package medium;

public class Solution926 {

    public static void main(String[] args){
        Solution926 solution926=new Solution926();
        System.out.println(solution926.minFlipsMonoIncr("00110"));
        System.out.println(solution926.minFlipsMonoIncr("010110"));
        System.out.println(solution926.minFlipsMonoIncr("00011000"));
    }

    public int minFlipsMonoIncr(String s) {
        int[] oneArr=new int[s.length()];
        int current = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='1') {
                current++;
            }
            oneArr[i]=current;
        }
        int[] resultArr=new int[s.length()];
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)=='1') resultArr[i]=resultArr[i-1];
            else {
                resultArr[i]=Math.min(oneArr[i],resultArr[i-1]+1);
            }
        }
        return resultArr[s.length()-1];
    }
}
