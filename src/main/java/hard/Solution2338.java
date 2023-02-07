package hard;

public class Solution2338 {

    public static void main(String[] args){
        long now =System.currentTimeMillis();
        System.out.println(idealArrays(9069,9411));
        System.out.println(System.currentTimeMillis()-now);
    }

    public static int idealArrays(int n, int maxValue) {
        if (n==1) return maxValue;
        int modNum = (int) (Math.pow(10,9)+7);
        int[] lastNum = new int[maxValue+1];
        int[] newNum=new int[maxValue+1];
        for (int j=1;j<=maxValue;j++){
            lastNum[j]=1;
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<=maxValue;j++){
                for (int k=1;k*j<=maxValue;k++){
                    newNum[k*j]=(newNum[k*j]+lastNum[j]) % modNum;
                }
            }
            lastNum=newNum;
            newNum=new int[maxValue+1];
        }
        int sum =0;
        for (int i=1;i<=maxValue;i++){
            sum=(sum+lastNum[i] )% modNum;
        }
        return sum;
    }
}
