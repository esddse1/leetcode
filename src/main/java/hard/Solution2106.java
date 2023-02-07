package hard;

import java.util.ArrayList;
import java.util.List;

public class Solution2106 {

    public static void main(String[] args){
        Solution2106 solution2106=new Solution2106();
        System.out.println(solution2106.maxTotalFruits(new int[][]{{2,8},{6,3},{8,6}},5,4));

        System.out.println(solution2106.maxTotalFruits(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}},5,4));

        System.out.println(solution2106.maxTotalFruits(new int[][] {{0,3},{6,4},{8,5}},3,2));
    }



    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0;

        List<int[]> leftList=new ArrayList<>();
        List<int[]> rightList=new ArrayList<>();
        for (int[] fruit : fruits) {
            if (fruit[0] <= startPos) {
                leftList.add(0,fruit);
            } else {
                rightList.add(fruit);
            }
        }

        int sumFruit = leftList.stream().map(x->x[1]).reduce(Integer::sum).orElse(0);
        int rightStart=0;
        int rightSum=0;
        for (int i = leftList.size()-1;i>=0;i--){
            if (startPos-leftList.get(i)[0]<=k){
                while (rightList.size()> rightStart &&(rightList.get(rightStart)[0]-leftList.get(i)[0]) + (startPos-leftList.get(i)[0])<=k ) {
                    rightSum = rightSum + rightList.get(rightStart)[1];
                    rightStart++;
                }
                max=Math.max(sumFruit+rightSum,max);
            }
            sumFruit=sumFruit-leftList.get(i)[1];
        }

        sumFruit = rightList.stream().map(x->x[1]).reduce(Integer::sum).orElse(0);
        int leftStart=0;
        int leftSum=0;
        for (int i = rightList.size()-1;i>=0;i--){
            if (rightList.get(i)[0]-startPos<=k){
                while (leftList.size()> leftStart &&(rightList.get(i)[0]-leftList.get(leftStart)[0]) + (rightList.get(i)[0]-startPos)<=k ) {
                    leftSum = leftSum + leftList.get(leftStart)[1];
                    leftStart++;
                }
                max=Math.max(sumFruit+leftSum,max);
            }
            sumFruit=sumFruit-rightList.get(i)[1];
        }

        return max;
    }




}
