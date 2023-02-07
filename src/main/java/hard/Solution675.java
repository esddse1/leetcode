package hard;

import java.util.*;

public class Solution675 {

    public static void main(String[] args){
        Solution675 soluion675=new Solution675();

        List<Integer> forest0=Arrays.asList(2,3,4);
        List<Integer> forest1=Arrays.asList(0,0,5);
        List<Integer> forest2=Arrays.asList(8,7,6);
        List<List<Integer>> forest=Arrays.asList(forest0,forest1,forest2);
        System.out.println(soluion675.cutOffTree(forest));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        for (int i=0;i<forest.size();i++){
            for (int j=0;j<forest.get(i).size();j++){
                if (forest.get(i).get(j) > 1) {
                    priorityQueue.add(new Node(forest.get(i).get(j), i, j));
                }
            }
        }
        int result= 0;Node tmpNode=new Node(forest.get(0).get(0),0,0);
        while (priorityQueue.size()>0) {
            Node node = priorityQueue.poll();
            int step = dfs(forest, tmpNode, node);
            if (step == -1)
                return -1;
            else {
                result = result + step;
                tmpNode = node;
            }
        }
        return result;
    }

    class Node{
        int value;
        int x;
        int y;
        public Node(int value,int x,int y){
            this.value=value;
            this.x=x;
            this.y=y;
        }
    }
    int[][] moveArr=new int[][]{{-1,0},{0,1},{0,-1},{1,0}};

    public int dfs(List<List<Integer>> forest,Node startNode,Node endNode){
        int[][] searchArr = new int[forest.size()][forest.get(0).size()];
        for (int i=0;i<searchArr.length;i++){
            for (int j=0;j<searchArr[0].length;j++){
                searchArr[i][j]=-1;
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        searchArr[startNode.x][startNode.y]=0;
        while (queue.size()>0){
            Node peek=queue.poll();
            if (peek.value == endNode.value) return searchArr[peek.x][peek.y];
            for (int[] move:moveArr){
                int newX=peek.x+move[0];
                int newY=peek.y+move[1];
                if (newX>=0 && newY>=0 && newX<searchArr.length && newY<searchArr[0].length){
                    if (forest.get(newX).get(newY)!=0 && (searchArr[newX][newY] == -1|| searchArr[newX][newY] > searchArr[peek.x][peek.y]+1)){
                        searchArr[newX][newY] = searchArr[peek.x][peek.y]+1;
                        queue.add(new Node(forest.get(newX).get(newY),newX,newY));
                    }
                }
            }
        }
        return -1;
    }
}
