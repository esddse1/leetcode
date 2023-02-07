package unfinished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution691 {

    public static void main(String[] args){
        Solution691 solution691=new Solution691();
        System.out.println(solution691.minStickers(new String[]{"letter","gold","give","fish","them","system","four","say","sudden","laugh","dear","still","boat","apple","thought","horse","from","prepare","how","provide","pay","people","three","to","hot","card","above","save","division","notice","complete","rain","band","game","mouth","decide","segment","him","bank","cool","term","life","against","motion","edge","nose","clean","enter","operate","where"},"lessremember"));
    }

    private static int currentMin=-1;
    public int minStickers(String[] stickers, String target) {
        int[] targetChar=getCharArray(target);
        List<int[]> charArray=new ArrayList<>();
        for (int i=0;i<stickers.length;i++){
            charArray.add(getCharArray(stickers[i]));
        }
        minStickers(charArray,targetChar,0);
        return currentMin;
    }

    public void minStickers(List<int[]> charArray, int[] targetChar, int currentStep){
        if (currentStep>=currentMin && currentMin>=0) return ;

        int remain = Arrays.stream(targetChar).sum();
        if (remain==0) {
            currentMin=currentStep;
            return;
        }
        else{
            if (charArray.size()==0) return ;
        }

        for (int i=0;i<26;i++){
            int count=0;
            for (int[] ints : charArray) {
                count = count + ints[i];
            }
            if (count==0 && targetChar[i]>0)
                return ;
        }

        int[] tmp=charArray.remove(0);
        int maxCount=0;
        for (int i=0;i<26;i++){
            if (targetChar[i]>0 && tmp[i]>0)
                maxCount= (int) Math.max(maxCount,Math.ceil(1.0*targetChar[i]/tmp[i]));
        }

        int[] tmpChar=Arrays.copyOfRange(targetChar,0,26);
        for (int i=0;i<=maxCount;i++){
            minStickers(charArray,tmpChar,currentStep+i);
            tmpChar = sub(tmpChar,tmp);
        }
        charArray.add(tmp);
    }

    private int[] getCharArray(String target){
        int[] result=new int[26];
        for (int i=0;i<target.length();i++){
            result[target.charAt(i)-'a']++;
        }
        return result;
    }

    private int[] add(int[] a,int []b){
        int[] c=new int[26];
        for (int i=0;i<26;i++){
            c[i]=a[i]+b[i];
        }
        return c;
    }

    public int[] sub(int[] a,int[] b){
        int[] c=new int[26];
        for (int i=0;i<26;i++){
            c[i]=Math.max(0,a[i]-b[i]);
        }
        return c;
    }


}
