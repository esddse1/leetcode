package hard;

import com.sun.source.tree.Tree;

import java.util.*;

public class Solution732 {

    public static void main(String[] args){
        MyCalendarThree obj = new MyCalendarThree();
        System.out.println(obj.book(26,35));
        System.out.println(obj.book(26,32));
        System.out.println(obj.book(25,32));
        System.out.println(obj.book(18,26));
        System.out.println(obj.book(40,45));
        System.out.println(obj.book(19,26));
        System.out.println(obj.book(48,50));
        System.out.println(obj.book(1,6));
        System.out.println(obj.book(46,50));

        //["MyCalendarThree","book","book","book","book","book","book","book","book","book","book"]
        //[[],[24,40],[43,50],[27,43],[5,21],[30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]
        //[null,1,1,2,2,3,3,3,3,4,4]
        //["MyCalendarThree","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
        //[[],[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17],[24,33],[23,28],[21,27],[47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,50],[33,39],[30,36],[6,15],[21,27],[49,50],[38,45],[4,12],[46,50],[13,21]]
        //[null,1,1,1,1,1,2,2,2,3,3,3,4,5,5,5,5,5,5,6,6,6,6,6,6,7,7,7,7,7,7]

        //["MyCalendarThree","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
        //[[],[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17],[24,33],[23,28],[21,27],[47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,50],[33,39],[30,36],[6,15],[21,27],[49,50],[38,45],[4,12],[46,50],[13,21]]

        //["MyCalendarThree","book","book","book","book","book","book","book","book","book","book"]
        //[[],[26,35],[26,32],[25,32],[18,26],[40,45],[19,26],[48,50],[1,6],[46,50],[11,18]]
    }





    static class MyCalendarThree {

        TreeSet<Node> treeSet;
        int max = 1;


        public MyCalendarThree() {
            treeSet=new TreeSet<>();
        }

        public int book(int start, int end) {
            Node newNode= new Node(start,end);
            if (treeSet.size()==0){
                treeSet.add(newNode);
                return 1;
            }
            Node compareNode = new Node(end,end);
            Node maxNode = treeSet.lower(compareNode);
            if (maxNode!=null) {
                Set<Node> headSet = new TreeSet<>(treeSet.headSet(maxNode, true));
                for (Node node:headSet){
                    if (newNode.length()==0) break;
                    if (node.fix(newNode)){
                        treeSet.remove(node);
                        List<Node> newList = split(node,newNode);
                        for (int i=0;i<2;i++){
                            if (newList.get(i).length()>0) {
                                max=Math.max(max,newList.get(i).value);
                                treeSet.add(newList.get(i));
                            }
                        }
                        newNode=newList.get(2);
                    }
                }
                if (newNode.length()>0){
                    treeSet.add(newNode);
                }
            }
            else{
                treeSet.add(newNode);
            }
            System.out.println(treeSet);
            return max;
        }

        private List<Node> split(Node node1,Node node2){
            if (!node1.fix(node2)){
                return Arrays.asList(node1,node2);
            }
            else{
                List<Node> result=new ArrayList<>();
                Node newNode1 = new Node(Math.min(node1.start,node2.start), Math.max(node1.start,node2.start));
                newNode1.value= node1.start<node2.start?node1.value:node2.value;
                Node newNode2 = new Node(Math.max(node1.start,node2.start), Math.min(node1.end,node2.end));
                newNode2.value= node1.value + node2.value;
                Node newNode3 = new Node(Math.min(node1.end,node2.end), Math.max(node1.end,node2.end));
                newNode3.value= node1.end<node2.end?node2.value:node1.value;
                result.add(newNode1);
                result.add(newNode2);
                result.add(newNode3);
                return result;
            }
        }
        static class Node implements Comparable<Node>{
            int start;
            int end;
            int value;

            public String toString(){
                return "start:"+start+",end:"+end+",value:"+value;
            }
            public Node(int start,int end){
                this.start=Math.min(start,end);this.end=Math.max(start,end);value=1;
            }
            public int length(){
                return end-start;
            }

            public boolean fix(Node other){
                return !(this.end<=other.start || this.start>=other.end);
            }

            @Override
            public int compareTo(Node o) {
                return this.start-o.start!=0?this.start-o.start:this.end-o.end;
            }
        }
    }


}
