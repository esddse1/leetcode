package easy;

public class Solution6078 {

    public static void main(String[] args){
        Solution6078 solution6078=new Solution6078();
        System.out.println(solution6078.rearrangeCharacters("ilovecodingonleetcode","code"));
    }

    public int rearrangeCharacters(String s, String target) {
        int[] sArray=new int[26];
        int[] targetArray=new int[26];
        for (char c:s.toCharArray()){
            sArray[c-'a']++;
        }
        for (char c:target.toCharArray()){
            targetArray[c-'a']++;
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<26;i++){
            if (targetArray[i]==0) continue;
            if (sArray[i]<targetArray[i]) return 0;
            else min=Math.min(min,sArray[i]/targetArray[i]);
        }
        return min;
    }
}
