package hard;

public class Solution1739 {

    public static void main(String[] args){
        Solution1739 solution1739=new Solution1739();
//        System.out.println(solution1739.minimumBoxes(3));
//        System.out.println(solution1739.minimumBoxes(4));
//        System.out.println(solution1739.minimumBoxes(10));
        System.out.println(solution1739.minimumBoxes(15));
    }


    public int minimumBoxes(int n) {
        int cur = 1, i = 1, j = 1;
        while (n > cur) {
            n -= cur;
            i++;
            cur += i;
        }
        cur = 1;
        while (n > cur) {
            n -= cur;
            j++;
            cur++;
        }
        return (i - 1) * i / 2 + j;

    }
}
