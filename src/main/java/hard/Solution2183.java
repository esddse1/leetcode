package hard;

import java.util.*;

public class Solution2183 {

    public static void main(String[] args){
        Solution2183 solution2183=new Solution2183();
        System.out.println(solution2183.countPairs(new int[]{1,2,3,4,5},2));
        System.out.println(solution2183.countPairs(new int[]{1,2,3,4},5));
    }

    public long countPairs(int[] nums, int k) {
        Map<Integer,Integer> numMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int gcdNum = gcd(nums[i],k);
            numMap.put(gcdNum,numMap.getOrDefault(gcdNum,0)+1);
        }
        Node[] nodes=new Node[numMap.size()];
        int i=0;
        for (Map.Entry<Integer,Integer> entry : numMap.entrySet()){
            nodes[i] = (new Node(entry.getKey(),entry.getValue()));
            i++;
        }
        long result = 0;
        for (int j=0;j<nodes.length;j++){
            for (int u=j;u< nodes.length;u++){
                if (nodes[j].value*nodes[u].value%k==0){
                    if (j==u){
                        result=result+(nodes[j].count *(nodes[j].count-1)/2);
                    }
                    else{
                        result=result+nodes[j].count*nodes[u].count;
                    }
                }
            }
        }
        return result;
    }

    class Node {
        long value;
        long count;
        public Node( int value, int count){
            this.value=value;
            this.count=count;
        }
    }

    public int gcd(int a, int b){
        if (b>a) return gcd(b,a);
        if (a%b==0) return b;
        return gcd(b,a%b);
    }
}
