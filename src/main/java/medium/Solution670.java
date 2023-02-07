package medium;

public class Solution670 {

    public static void main(String[] args){
        Solution670 solution670=new Solution670();
        System.out.println(solution670.maximumSwap(2736));
        System.out.println(solution670.maximumSwap(9973));
        System.out.println(solution670.maximumSwap(65371682));
        System.out.println(solution670.maximumSwap(1993));
    }

    public int maximumSwap(int num) {
        String s=num+"";
        for (int i=1;i<s.length();i++){
            if (s.charAt(i-1)<s.charAt(i)) {
                int index=i;
                char min = s.charAt(i);
                for (int k=i;k<s.length();k++){
                    if (s.charAt(k)>=min){
                        min=s.charAt(k);
                        index=k;
                    }
                }
                for (int j=0;j<=i-1;j++){
                    if (s.charAt(j) < s.charAt(index)) {
                        return Integer.parseInt(subString(s,0,j)+s.charAt(index)+subString(s,j+1,index)+s.charAt(j)+subString(s,index+1));
                    }
                }
            }
        }
        return num;
    }

    public String subString(String s,int startIndex){
        if (startIndex>=s.length()) return "";
        return s.substring(startIndex);
    }


    public String subString(String s,int startIndex,int endIndex){
        if (startIndex>=endIndex) return "";
        if (startIndex>=s.length()) return "";
        return s.substring(startIndex,endIndex);
    }

}
