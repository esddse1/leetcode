//package hard;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class Solution1728 {
//
//    List<Pair<Integer,Integer>> jumpList= Arrays.asList(new Pair<>(-1,0),new Pair<>(0,1),
//            new Pair<>(0,-1),new Pair<>(1,0));
//
//    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
//        int high=grid.length;
//        int length=grid[0].length();
//        int[][] catGrid=new int[length][high];
//        int[][] mouseGrid=new int[length][high];
//        Pair<Integer,Integer> catLocation = null;
//        Pair<Integer,Integer> mouseLocation= null;
//        Pair<Integer,Integer> foodLocation= null;
//        for (int i=0;i< high;i++){
//            for (int j=0;j<length;j++){
//                if (grid[i].charAt(j)=='F'){
//                    foodLocation= new Pair<>(i, j);
//                }
//                if (grid[i].charAt(j)=='C'){
//                    catLocation= new Pair<>(i, j);
//                }
//                if (grid[i].charAt(j)=='M'){
//                    mouseLocation= new Pair<>(i, j);
//                }
//            }
//        }
//        catGrid= getCatGrid(catLocation,grid,catJump);
//        mouseGrid= getCatGrid(mouseLocation,grid,catJump);
//
//        int[][] searchGrid=new int[length][high];
//        searchGrid[mouseLocation.left][mouseLocation.right] = 1;
//        Queue<Pair<Integer,Integer>> moveQueue=new LinkedList<>();
//        moveQueue.add(mouseLocation);
//        int step = 0;
//        while (moveQueue.size()>0 && step<1000) {
//            step++;
//            Pair<Integer, Integer> current = moveQueue.poll();
//            if (searchGrid[current.left][current.right]==0) {
//                for (Pair<Integer, Integer> jumpPair : jumpList) {
//                    Pair<Integer, Integer> newLocation = new Pair<>(current.left + jumpPair.left, current.right + jumpPair.right);
//                    char currentChar= getChar(grid, newLocation.left, newLocation.right);
//                    if (currentChar == 'F') {
//                        return true;
//                    }
//                    else if
//
//                }
//            }
//        }
//        return false;
//    }
//
//    private int[][] getCatGrid(Pair<Integer,Integer> catLocation,String[] grid,int jumpLength){
//        int high=grid.length;
//        int length=grid[0].length();
//        int[][] catGrid=new int[length][high];
//        int starti= catLocation.left;
//        int startj= catLocation.right;
//        Queue<Pair<Integer,Integer>> moveQueue=new LinkedList<>();
//        moveQueue.add(catLocation);
//        while (moveQueue.size()>0){
//            Pair<Integer,Integer> current = moveQueue.poll();
//            int currentStep=catGrid[current.left][current.right]+1;
//            for (Pair<Integer, Integer> jumpPair : jumpList) {
//                for (int j=1;j<=jumpLength;j++){
//                    Pair<Integer,Integer> newLocation = new Pair<>(current.left+j*jumpPair.left,current.right+j*jumpPair.right);
//                    if (getChar(grid, newLocation.left, newLocation.right)=='#'){
//                        catGrid[newLocation.left][newLocation.right]=-1;
//                    }
//                    else{
//                        if (catGrid[newLocation.left][newLocation.right] >0 && catGrid[newLocation.left][newLocation.right]<=currentStep+1){
//
//                        }
//                        else{
//                            catGrid[newLocation.left][newLocation.right] = currentStep+1;
//                            moveQueue.add(new Pair<>(newLocation.left,newLocation.right));
//                        }
//                    }
//                }
//            }
//        }
//        return catGrid;
//    }
//
//    private char getChar(String[] grid,int left,int right){
//        return grid[left].charAt(right);
//    }
//
//
//    static class Pair<A,B>{
//        A left;
//        B right;
//        public Pair(A left,B right){
//            this.left=left;
//            this.right=right;
//        }
//    }
//}
