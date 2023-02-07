package hard;

import java.util.LinkedList;
import java.util.Queue;

public class Solution407 {

    public static void main(String[] args){
        Solution407 solution407=new Solution407();
        System.out.println(solution407.trapRainWater(new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
        System.out.println(solution407.trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));
    }


    int[][] moveArray=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    public int trapRainWater(int[][] heightMap) {
        int[][] markArr=new int[heightMap.length][heightMap[0].length];
        int result=0;
        for (int i=1;i<heightMap.length-1;i++){
            for (int j=1;j<heightMap[i].length-1;j++){
                if (markArr[i][j]!=-1){
                    int tmpResult=0;
                    while (tmpResult>-1){
                        tmpResult=fixRain(heightMap,new Node(i,j,heightMap[i][j]),markArr);
                        if (tmpResult>0) result=result+tmpResult;
                    }
                }
            }
        }
        return result;
    }


    public int fixRain(int[][] heightMap,Node currentNode,int[][] markArr){
        Queue<Node> waterQueue=new LinkedList<>();
        Queue<Node> searchQueue=new LinkedList<>();
        searchQueue.add(currentNode);
        waterQueue.add(currentNode);
        int[][] searchArr= new int[heightMap.length][heightMap[0].length];
        searchArr[currentNode.x][currentNode.y] = 1;
        boolean canTrapRain = true;
        int minHeight=Integer.MAX_VALUE;
        while (searchQueue.size()>0){
            Node node = searchQueue.poll();
            if (node.x==0 || node.y == 0 || node.x==heightMap.length-1 || node.y == heightMap[0].length-1){
                canTrapRain = false;
            }
            else{
                for (int i=0;i<4;i++){
                    int newX = node.x+moveArray[i][0];
                    int newY = node.y+moveArray[i][1];
                    if (searchArr[newX][newY] == 0){
                        if (heightMap[newX][newY]==currentNode.high){
                            waterQueue.add(new Node(newX,newY,currentNode.high));
                            searchQueue.add(new Node(newX,newY,currentNode.high));
                            searchArr[newX][newY] = 1;
                        }
                        if (heightMap[newX][newY] < currentNode.high){
                            canTrapRain = false;
                        }
                        if (heightMap[newX][newY] > currentNode.high){
                            minHeight = Math.min(minHeight,heightMap[newX][newY]);
                        }
                    }
                }
            }
        }
        if (!canTrapRain){
            for (Node node:waterQueue){
                markArr[node.x][node.y] = -1;
            }
            return -1;
        }
        else{
            int result= 0 ;
            for (Node node:waterQueue){
                markArr[node.x][node.y] = 0;
                heightMap[node.x][node.y] = minHeight;
                result = result + (minHeight- currentNode.high);
            }
            return result;
        }
    }

    class Node{
        int x;
        int y;
        int high;
        public Node(int x,int y,int high){
            this.x=x;this.y=y;this.high=high;
        }
    }
}
