package hard;

import java.util.*;

public class Solution6081 {

    int[][] move=new int[][]{{-1,0},{0,1},{0,-1},{1,0}};

    public static void main(String[] args){
        Solution6081 solution6081=new Solution6081();
        System.out.println(solution6081.minimumObstacles(new int[][]{{0,1,1},{1,1,0},{1,1,0}})); //2
        System.out.println(solution6081.minimumObstacles(new int[][]{{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}})); //2
    }

    public int minimumObstacles(int[][] grid) {

        int[][] minArr=new int[grid.length][grid[0].length];
        for (int i=0;i<minArr.length;i++){
            for (int j=0;j<minArr[0].length;j++){
                minArr[i][j]=-1;
            }
        }

        LinkedList<Node> stack=new LinkedList<>();
        stack.add(new Node(0,0,0));
        int currentMin = -1;
        while (!stack.isEmpty()){
            Node current = stack.poll();
            for (int i=0;i<4;i++){
                int newX=current.x+move[i][0];
                int newY=current.y+move[i][1];
                if (newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length){
                    int path = current.num+grid[newX][newY];
                    if (currentMin!=-1 && path>=currentMin) continue;
                    if (minArr[newX][newY]==-1 || path<minArr[newX][newY]){
                        minArr[newX][newY]=path;
                        if (grid[newX][newY] ==0)
                            stack.addFirst(new Node(newX,newY,path));
                        else
                            stack.addLast(new Node(newX,newY,path));
                    }
                    if (newX == grid.length-1 && newY == grid[0].length-1){
                        currentMin=path;
                    }
                }
            }
        }
        return currentMin;
    }

    class Node{
        int x;
        int y;
        int num;
        public Node(int x,int y,int num){
            this.x=x;this.y=y;this.num=num;
        }
    }
}


