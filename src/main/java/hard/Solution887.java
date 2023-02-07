package hard;

public class Solution887 {


    public static void main(String[] args){
        Solution887 solution887=new Solution887();
//        System.out.println(solution887.superEggDrop(1,2));
//        System.out.println(solution887.superEggDrop(2,4));
//        System.out.println(solution887.superEggDrop(2,2));
//        System.out.println(solution887.superEggDrop(2,4));
//        System.out.println(solution887.superEggDrop(2,6));
//        System.out.println(solution887.superEggDrop(3,14));
        long current =System.currentTimeMillis();
        System.out.println(solution887.superEggDrop(100,8191));
        long end =System.currentTimeMillis();
        System.out.println(end-current);
    }

    public int superEggDrop(int k, int n) {
        int[][] searchArr = new int[k+1][n+1];
        int count = 0;
        for (int i=1;i<=k;i++){
            for (int j=1;j<=n;j++){
                if (Math.pow(2,i)>j+3) searchArr[i][j] = searchArr[i-1][j];
                else if (j==1) searchArr[i][j]=1;
                else if (j==2) searchArr[i][j]=2;
                else if (i==1) searchArr[i][j]=j;
                else {
                    searchArr[i][j]=searchArr[i][j-1]+1;
                    int start =1; int end=j-1;
                    int target=start;

                    while (start < end){
                        int mid = (start +end)/2;
                        if (end-start <=1){
                            if (searchArr[i][j-start]>= searchArr[i][j]-1) target=end;
                            else target=start;
                            break;
                        }
                        if (searchArr[i][j-mid] >= searchArr[i][j]-1){
                            start = mid+1;
                        }
                        else{
                            end = mid;
                        }
                        if (end-start <=1){
                            if (searchArr[i][j-start]>= searchArr[i][j]-1) target=end;
                            else target=start;
                            break;
                        }
                    }
                    int newCount=0;

                    for (int u = target; u <= j - 1; u++) {
                        newCount++;
                        if (searchArr[i][j] > 0 && searchArr[i - 1][u - 1] >= searchArr[i][j]-1) break;
                        if (searchArr[i][j] > 0) {
                            searchArr[i][j] = Math.min(searchArr[i][j], Math.max(searchArr[i - 1][u - 1], searchArr[i][j - u]) + 1);
                        } else searchArr[i][j] = Math.max(searchArr[i - 1][u - 1], searchArr[i][j - u]) + 1;
                    }
                }
            }
        }
        return searchArr[k][n];
    }

}
