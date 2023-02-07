package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution1400 {
    public boolean canConstruct(String s, int k) {
        Map<Character,Integer> charMap=new HashMap<>();
        for (int i=0;i<s.length();i++){
            charMap.put(s.charAt(i),charMap.getOrDefault(s.charAt(i),0)+1);
        }
        for (Map.Entry<Character,Integer> entry:charMap.entrySet()){
            if (entry.getValue()%2!=0) k--;
        }
        return k>=0;
    }
}
