package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution890 {

    public static void main(String[] args){
        Solution890 solution890=new Solution890();
        System.out.println(solution890.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},"abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result=new ArrayList<>();
        for (String s:words){
            boolean add=true;
            if (s.length()==pattern.length()){
                Map<Character,Character> mappingA=new HashMap<>();
                Map<Character,Character> mappingB=new HashMap<>();
                for (int j=0;j<pattern.length();j++){
                    char wordsChar = s.charAt(j);
                    char wordsPattern = pattern.charAt(j);
                    if (mappingA.containsKey(wordsPattern)){
                        if (mappingA.get(wordsPattern)!=wordsChar){
                            add=false;
                            break;
                        }
                    }
                    else{
                        if (mappingB.containsKey(wordsChar)){
                            add=false;
                            break;
                        }
                        mappingA.put(wordsPattern,wordsChar);
                        mappingB.put(wordsChar,wordsPattern);
                    }
                }
            }
            else {
                add=false;
            }
            if (add){
                result.add(s);
            }
        }
        return result;
    }
}
