package hard;

import java.util.ArrayList;
import java.util.List;

public class Solution699 {

    public static void main(String[] args){
        Solution699 solution699=new Solution699();
        System.out.println(solution699.fallingSquares(new int[][]{{6, 1}, {9, 2}, {2, 4}}));
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Node> result=new ArrayList<>();
        result.add(new Node(positions[0][0],positions[0][0]+positions[0][1],positions[0][1]));
        List<Integer> result2=new ArrayList<>();
        result2.add(positions[0][1]);
        for (int i=1;i<positions.length;i++){
            Node node=new Node(positions[i][0],positions[i][0]+positions[i][1],positions[i][1]);
            for (int j=0;j<i;j++){
                if (canFix(result.get(j),node)){
                    node.high=Math.max(result.get(j).high+positions[i][1], node.high);
                }
            }
            result.add(node);
            result2.add(Math.max(result2.get(result2.size()-1), node.high));
        }
        return result2;
    }

    class Node{
        int start;
        int end;
        int high;

        public Node(int start,int end,int high){
            this.start=start;this.end=end;this.high=high;
        }
    }

    public boolean canFix(Node node1,Node node2){
        return !(node1.start>=node2.end || node2.start>= node1.end);
    }
}
