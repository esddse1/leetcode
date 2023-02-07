//package unfinished;
//
//public class Solution715 {
//
//    public static void main(String[] args){
//        RangeModule rangeModule = new RangeModule();
//        rangeModule.addRange(6, 8);
//        rangeModule.removeRange(7, 8);
//        rangeModule.removeRange(8, 9);
//        rangeModule.addRange(8, 9);
//        rangeModule.removeRange(1, 3);
////        System.out.println("!2312312312");
//        rangeModule.addRange(1, 8);
//        System.out.println(rangeModule.queryRange(2, 4));  //true
//        System.out.println( rangeModule.queryRange(2, 9)); //false
//        System.out.println(rangeModule.queryRange(4, 6)); //true
//        //["RangeModule","addRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","queryRange"]
//        //[[],[6,8],[7,8],[8,9],[8,9],[1,3],[1,8],[2,4],[2,9],[4,6]]
//
//    }
//
//
//
//    static class RangeModule {
//
//        private Node root;
//        private final long min =0;
//        private final long max = (long) Math.pow(10,9);
//
//
//        public RangeModule() {
//            root = new Node(min,max);
//        }
//
//        public void addRange(int left, int right) {
//            addRange(root,left,right-1,1);
//        }
//
//        public boolean queryRange(int left, int right) {
//            long result = query(root,left,right-1,0);
//            return (right-left)==result;
//        }
//
//        public void removeRange(int left, int right) {
//            addRange(root,left,right-1,-1);
//        }
//
//        private long query(Node currentNode,long left,long right,long childValue){
//            if (currentNode==null)
//                return Math.max(0,(right-left+1)*childValue);
//            if (currentNode.left==left && currentNode.right==right) {
//                return Math.max(0,currentNode.value+(right-left+1)*childValue);
//            }
//            else{
//                long result = 0;
//                long mid =(currentNode.right+currentNode.left)/2;
//                if (left<=mid){
//                    if (mid<right) {
//                        result = result + query(currentNode.leftNode, left, mid, currentNode.childValue + childValue);
//                    }
//                    else {
//                        result = result + query(currentNode.leftNode, left, right, currentNode.childValue + childValue);
//                    }
//                }
//                if (right>=mid+1){
//                    if (left<mid+1) {
//                        result = result + query(currentNode.rightNode, mid + 1, right, currentNode.childValue + childValue);
//                    }
//                    else{
//                        result = result + query(currentNode.rightNode, left, right, currentNode.childValue + childValue);
//                    }
//                }
//                return result;
//            }
//        }
//
//        private void addRange(Node currentNode,long left,long right,long value){
//            currentNode.value= currentNode.value+(right-left+1)*value;
//            if (currentNode.left==left && currentNode.right==right) {
//                currentNode.childValue=value+ currentNode.childValue;
//            }
//            else{
//                long mid =(currentNode.right+currentNode.left)/2;
//                if (left<=mid){
//                    if (currentNode.leftNode==null) {
//                        currentNode.leftNode=new Node(currentNode.left,mid);
//                    }
//                    if (right>mid)
//                        addRange(currentNode.leftNode,left,mid,value);
//                    else
//                        addRange(currentNode.leftNode,left,right,value);
//                }
//                if (right>=mid+1){
//                    if (currentNode.rightNode==null) {
//                        currentNode.rightNode=new Node(mid+1,currentNode.right);
//                    }
//                    if (left>=mid+1)
//                        addRange(currentNode.rightNode,left,right,value);
//                    else
//                        addRange(currentNode.rightNode,mid+1,right,value);
//                }
//            }
//        }
//
//        class Node{
//            long left;
//            long right;
//            Node leftNode;
//            Node rightNode;
//            boolean value;
//            boolean childValue;
//            public Node (long left,long right){
//                this.left=left;this.right=right;
//            }
//
//            @Override
//            public String toString(){
//                return "left:"+left+",right:"+right+",value:"+value+",childValue:"+childValue;
//            }
//        }
//    }
//}
