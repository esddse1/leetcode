package hard;


public class Solution1255 {

    public static void main(String[] args){
        Solution1255 solution1255=new Solution1255();

        System.out.println(solution1255.maxScoreWords(new String[]{"add","dda","bb","ba","add"},
                new char[]{'a','a','a','a','b','b','b','b','c','c','c','c','c','d','d','d'},
                new int[]{3,9,8,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));

    }



    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if (words.length==0) return 0;
        int[] remainCharArray = new int[26];
        for (char c: letters){
            remainCharArray[c-'a']++;
        }
        return maxScoreWords(words,0,remainCharArray,score);
    }

    public int maxScoreWords(String[] words,int startIndex, int[] remainCharArray, int[] score) {
        if (startIndex>=words.length) return 0;
        int canSub = subWord(remainCharArray,words[startIndex].toCharArray(),score);
        if (canSub==-1){
            return maxScoreWords(words,startIndex+1,remainCharArray,score);
        }
        else{
            int subMax = canSub + maxScoreWords(words,startIndex+1,remainCharArray,score);

            for (char c : words[startIndex].toCharArray()){
                remainCharArray[c-'a']++;
            }
            int notSubMax = maxScoreWords(words,startIndex+1,remainCharArray,score);
            return Math.max(subMax,notSubMax);
        }
    }


    public int subWord(int[] remainCharArray,char[] word,int[] score){
        boolean success=true;
        for (int i=0;i<word.length;i++){
            if (remainCharArray[word[i]-'a']>=1){
                remainCharArray[word[i]-'a']--;
            }
            else{
                for (int j=0;j<i;j++){
                    remainCharArray[word[j]-'a']++;
                }
                success=false;
                break;
            }
        }
        if (!success) return -1;
        else{
            int result =0;
            for (char c : word) {
                result = result+score[c-'a'];
            }
            return result;
        }
    }

}
