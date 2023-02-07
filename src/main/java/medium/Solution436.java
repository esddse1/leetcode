package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Solution436 {

    public static void main(String[] args){
        Solution436 solution436=new Solution436();
        System.out.println(Arrays.toString(solution436.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
        System.out.println(Arrays.toString(solution436.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
    }
    public int[] findRightInterval(int[][] intervals) {
        Node[] nodes=new Node[intervals.length];
        for (int i=0;i< intervals.length;i++){
            nodes[i]=new Node(intervals[i][0],intervals[i][1],i);
        }
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.left));
        int[] result=new int[intervals.length];
        for (int i=0;i< intervals.length;i++){
            result[i]=binarySearch(nodes,intervals[i][1]);
        }
        return result;
    }

    public int binarySearch(Node[] nodes,int num){
        if (nodes[nodes.length-1].left<num) return -1;
        int left = 0;int right = nodes.length-1;
        int mid=(left+right+1)/2;
        while (left<right){
            if (mid == right){
                if (nodes[left].left>=num) return nodes[left].index;
                if (nodes[right].left>=num) return nodes[right].index;
                return -1;
            }
            if (nodes[mid].left<num){
                left=mid+1;
            }
            else{
                right=mid;
            }
            mid=(left+right+1)/2;
        }
        return nodes[mid].left>=num?nodes[mid].index:-1;
    }

    class Node{
        int left;
        int right;
        int index;
        public Node(int left,int right,int index){
            this.left=left;
            this.right=right;
            this.index=index;
        }
    }
}
