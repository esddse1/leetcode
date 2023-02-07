package unfinished;

public class Solution730 {

    public static void main(String[] args){
        Solution730 solution730=new Solution730();
        System.out.println(solution730.countPalindromicSubsequences("aaa"));
    }

    long temp = (long) (Math.pow(10,9)+7);

    public int countPalindromicSubsequences(String s) {

        long[][] resultArr=new long[s.length()][s.length()];
        for (int i=0;i<=s.length()-1;i++){
            for (int j=i;j>=0;j--){
                if (j==i)
                    resultArr[j][i]=1L;
                else{
                    long ans = get(resultArr,j,i-1,s);
                    for (int k=j;k<i;k++){
                        if (s.charAt(k)==s.charAt(i)) {
                            ans = (ans + Math.max(1,get(resultArr,k+1,i-1,s)))%temp;
                        }
                    }
                    resultArr[j][i]=ans;
                }
            }
        }
        return (int) resultArr[0][s.length()-1];
    }

    public long get(long[][] resultArr,int start,int end,String s){
        if (end<0 || start>=resultArr.length) return 0;
        if (end<=start) return 0;
        if (end-start<=2) return s.charAt(start)==s.charAt(end)?1:0;
        return resultArr[start][end];
    }
}
