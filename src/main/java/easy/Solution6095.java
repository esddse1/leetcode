package easy;

import java.util.HashSet;
import java.util.Set;

public class Solution6095 {


    public boolean strongPasswordCheckerII(String password) {
        char[] specialChar=new char[]{'!','@','#','$','%','^','&','*','(',')','-','+'};
        Set<Character> characters=new HashSet<>();
        for (char c : specialChar) {
            characters.add(c);
        }
        if (password.length()<8) return false;
        boolean containSmall=false;
        boolean containBig=false;
        boolean containNumber=false;
        boolean containSpecial=false;
        boolean notSame=true;
        Character lastChar=null;
        for (int i=0;i<password.length();i++){
            char currentChar = password.charAt(i);
            if (currentChar-'a'>=0 && currentChar-'z'<=0) containSmall=true;
            if (currentChar-'A'>=0 && currentChar-'Z'<=0) containBig=true;
            if (currentChar-'0'>=0 && currentChar-'9'<=0) containNumber=true;
            if (characters.contains(currentChar)) containSpecial=true;
            if (lastChar!=null && lastChar==currentChar){
                notSame=false;
            }
            lastChar=currentChar;
        }
        return containSmall&&containBig&&containNumber&&containSpecial&&notSame;
    }
}
