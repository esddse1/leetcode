package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Solution522 {


    public static void main(String[] args){
        Solution522 solution522=new Solution522();
        System.out.println(solution522.findLUSlength(new String[]{"aaa","acb"}));
    }


    public int findLUSlength(String[] strs) {
        if (strs.length==0) return -1;
        Arrays.sort(strs, (o1, o2) -> o1.length()==o2.length()?o1.compareTo(o2):o2.length()-o1.length());
        Set<String> containStr=new HashSet<>();
        for (int i=0;i<strs.length;i++){
            boolean ok=true;
            for (int j=0;j<strs.length;j++){
                if (j==i) continue;
                if (strs[j].length()<strs[i].length()) return strs[i].length();
                if (isSubStr(strs[i],strs[j])) {
                    ok=false;
                    break;
                }
            }
            if (ok) return strs[i].length();
        }
        return -1;
    }

    public boolean isSubStr(String a,String b){
        if (a.length()<b.length()) return isSubStr(b,a);
        if (a.length()==b.length()) return a.equals(b);
        else{
            int right = 0;
            for (int i=0;i<a.length();i++){
                if (a.length()-i<b.length()-right) return false;
                if (a.charAt(i)==b.charAt(right)){
                    right++;
                    if (right==b.length()) return true;
                }
            }
            return false;
        }
    }
}
