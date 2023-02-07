package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution30 {

    public static void main(String[] args){
        Solution30 solution30=new Solution30();
        System.out.println(solution30.findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
        System.out.println(solution30.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}));
        System.out.println(solution30.findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"}));
        //"wordgoodgoodgoodbestword"
        //["word","good","best","good"]
        System.out.println(solution30.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
    }



    public List<Integer> findSubstring(String s, String[] words) {
        int length=words[0].length();
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<length;i++){
            int start = i;
            int end = i;
            int currentNum=0;
            List<String> tmpStr = new ArrayList<>(Arrays.asList(words));
            while (end+ (words.length-currentNum)*length-1<s.length()){
                if (end+length>s.length()) break;
                if (!tmpStr.contains(s.substring(end,end+length))){
                    if (start==end) {
                        end=end+length;
                    }else{
                        tmpStr.add(s.substring(start,start+length));
                        currentNum--;
                    }
                    start=start+length;
                }
                else{
                    currentNum++;
                    tmpStr.remove(s.substring(end,end+length));
                    end=end+length;
                    if (currentNum== words.length){
                        result.add(start);
                        tmpStr.add(s.substring(start,start+length));
                        start=start+length;
                        currentNum--;
                    }
                }
            }
        }
        return result;
    }

}
