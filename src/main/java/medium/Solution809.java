package medium;

import java.util.HashSet;
import java.util.Set;

public class Solution809 {


    public static void main(String[] args){
        Solution809 solution809=new Solution809();
        System.out.println(solution809.expressiveWords("heeellooo",new String[]{"hello", "hi", "helo"}));
    }

    public int expressiveWords(String s, String[] words) {
        int result = 0;
        for (int i =0;i<words.length;i++){
            if (match(words[i],s)) {
                result++;
            }
        }
        return result;
    }

    public boolean match(String sourceStr,String targetStr){
        int targetIndex = 0;
        int sourceIndex = 0;
        Set<Character> sourceChar=new HashSet<>();
        Set<Character> targetChar=new HashSet<>();
        for (int i=0;i<targetStr.length();i++){
            targetChar.add(targetStr.charAt(i));
        }

        for (int i=0;i<sourceStr.length();i++){
            sourceChar.add(sourceStr.charAt(i));
        }

        for (Character c: sourceChar){
            if (!targetChar.contains(c)) return false;
            else targetChar.remove(c);
        }
        if (targetChar.size()>0) return false;


        while (targetIndex<targetStr.length()){
            int targetEndIndex = targetIndex;
            for (;targetEndIndex+1<targetStr.length() && targetStr.charAt(targetEndIndex+1) == targetStr.charAt(targetEndIndex);targetEndIndex++){

            }
            int targetLength = targetEndIndex-targetIndex +1;
            int sourceEndIndex = sourceIndex;
            int sourceLength=0;

            if (sourceIndex<sourceStr.length() && targetStr.charAt(targetIndex) == sourceStr.charAt(sourceIndex)){
                for (;sourceEndIndex+1<sourceStr.length() && sourceStr.charAt(sourceEndIndex+1) == sourceStr.charAt(sourceEndIndex);sourceEndIndex++){

                }
                sourceLength = sourceEndIndex-sourceIndex +1;
            }

            if (targetLength<sourceLength || (targetLength-sourceLength!= 0 && targetLength<3)){
                return false;
            }
            targetIndex = targetEndIndex+1;
            sourceIndex = sourceEndIndex+1;
        }
        return true;
    }
}
