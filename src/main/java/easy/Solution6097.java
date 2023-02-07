package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution6097 {

    public static void main(String[] args){
        Solution6097 solution6097=new Solution6097();
        //"llllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrlllllllllllllllllllllllllllllllll"
        //"lllllllllllllllllllllllllllllllll"
        //[["l","a"],["l","b"],["l","c"],["l","d"],["l","e"],["l","f"],["l","g"],["l","h"],["l","i"],["l","j"],["l","k"],["l","m"],["l","n"],["l","o"],["l","p"],["l","q"],["l","s"],["l","t"],["l","u"],["l","v"],["l","w"],["l","x"],["l","y"],["l","z"],["l","0"],["l","1"],["l","2"],["l","3"],["l","4"],["l","5"],["l","6"],["l","7"],["l","8"],["l","9"],["r","a"],["r","b"],["r","c"],["r","d"],["r","e"],["r","f"],["r","g"],["r","h"],["r","i"],["r","j"],["r","k"],["r","m"],["r","n"],["r","o"],["r","p"],["r","q"],["r","s"],["r","t"],["r","u"],["r","v"],["r","w"],["r","x"],["r","y"],["r","z"],["r","0"],["r","1"],["r","2"],["r","3"],["r","4"],["r","5"],["r","6"],["r","7"],["r","8"],["r","9"]]
        System.out.println(solution6097.matchReplacement("llllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrllllllllllllllllllllllllllllllllrlllllllllllllllllllllllllllllllll"
                ,"lllllllllllllllllllllllllllllllll",new char[][]{{'l','a'},{'l','b'},{'l','c'},{'l','d'},{'l','e'},{'l','f'},{'l','g'},{'l','h'},{'l','i'},{'l','j'},{'l','k'},{'l','m'},{'l','n'},{'l','o'},{'l','p'},{'l','q'},{'l','s'},{'l','t'},{'l','u'},{'l','v'},{'l','w'},{'l','x'},{'l','y'},{'l','z'},{'l','0'},{'l','1'},{'l','2'},{'l','3'},{'l','4'},{'l','5'},{'l','6'},{'l','7'},{'l','8'},{'l','9'},{'r','a'},{'r','b'},{'r','c'},{'r','d'},{'r','e'},{'r','f'},{'r','g'},{'r','h'},{'r','i'},{'r','j'},{'r','k'},{'r','m'},{'r','n'},{'r','o'},{'r','p'},{'r','q'},{'r','s'},{'r','t'},{'r','u'},{'r','v'},{'r','w'},{'r','x'},{'r','y'},{'r','z'},{'r','0'},{'r','1'},{'r','2'},{'r','3'},{'r','4'},{'r','5'},{'r','6'},{'r','7'},{'r','8'},{'r','9'}}));
    }


    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> mappingSet=new HashMap<>();
        for (int i=0;i<mappings.length;i++){
            Set<Character> characters=mappingSet.getOrDefault(mappings[i][0],new HashSet<>());
            characters.add(mappings[i][1]);
            mappingSet.put(mappings[i][0],characters);
        }
        if (sub.length()>s.length()) return false;
        for (int i=0;i<=s.length()-sub.length();i++){
            boolean hasBreak=false;
            for (int j=0;j<sub.length();j++){
                if (!equal(s.charAt(i+j),sub.charAt(j),mappingSet)){
                    hasBreak=true;
                    break;
                }
            }
            if (!hasBreak) return true;
        }
        return false;
    }

    boolean equal(char a, char b,Map<Character, Set<Character>> mappingSet){
        return a==b || mappingSet.containsKey(b) && mappingSet.get(b).contains(a);
    }
}
