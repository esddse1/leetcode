package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution6083 {

    public static void main(String[] args){
        Solution6083 solutionA=new Solution6083();
        System.out.println(solutionA.digitCount("1210"));
        System.out.println(solutionA.digitCount("030"));
    }

    public boolean digitCount(String num) {
        Map<Integer,Integer> countMap=new HashMap<>();
        for (char a:num.toCharArray()){
            countMap.put(a-'0',countMap.getOrDefault(a-'0',0)+1);
        }
        for ( int i=0;i<num.length();i++){
            if (countMap.getOrDefault(i,0)!=num.charAt(i)-'0')
            return false;
        }
        return true;
    }
}
