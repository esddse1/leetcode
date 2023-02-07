package hard;

public class Solution10011 {


    public static void main(String[] args){
        BookMyShow bms = new BookMyShow(2, 6);
        bms.scatter(2, 1); //  [0, 0]
        bms.scatter(8, 0); //  []
//        bms.scatter(151, 15); //  True
//        bms.gather(387, 4); //  False
//        bms.gather(178, 1); //  False
    }

    static class BookMyShow {

        private int setNum;
        long[] remainArr;
        long[] treeA;
        int scanStartLine = 0;

        public BookMyShow(int n, int m) {
            setNum=m;
            remainArr=new long[n];
            treeA=new long[n+1];
            for (int i=0;i<n;i++){
                insert(i,setNum);
            }
        }

        public int[] gather(int k, int maxRow) {
            for (int i=scanStartLine;i<=maxRow&&i< remainArr.length;i++){
                if (setNum-remainArr[i]-k>=0){
                    remainArr[i]=remainArr[i]+k;
                    insert(i,-k);
                    return new int[]{i, (int) (remainArr[i]-k)};
                }
            }
            return new int[0];
        }

        public boolean scatter(int k, int maxRow) {
            int left = scanStartLine;
            int right = Math.min(treeA.length-1,maxRow);
            if (left>right) return false;
            int target=-1;
            long lastLineResult=0;
            while (left < right){
                if (right-left == 1){
                    if (sum(left)>=k) target=left;
                    if (sum(right)>=k) target=right;
                }
                int mid = (left+right)/2;
                if (sum(mid)<k){
                    left=mid+1;
                }
                else{
                    right = mid;
                }
            }
            if (sum(left)>=k) target=left;
            if (target==-1) {
                System.out.println(false);
                return false;
            }
            if (left>0) {
                lastLineResult = k - sum(left - 1);
            }
            else{
                lastLineResult = k;
            }
            remainArr[left] = (int) (remainArr[left] + lastLineResult);
            scanStartLine=left;
            if (left>=1) {
                insert(left, (int) -lastLineResult);
                insert(left - 1, (int) lastLineResult - k);
            }
            else{
                insert(0, (int) -k);
            }
            System.out.println(true);
            return true;
        }

        int lowBit(int x){
            return x&(-x);
        }

        void insert(int index,int value){
            index=index+1;
            while(index<treeA.length){
                treeA[index]=treeA[index]+value;
                index=index+lowBit(index);
            }
        }

        long sum(int index){
            index=index+1;
            long sum = 0;
            while (index>0){
                sum=sum+treeA[index];
                index=index-lowBit(index);
            }
            return sum;
        }




    }



}
