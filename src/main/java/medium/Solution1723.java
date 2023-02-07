package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1723 {
    public int maximumScore(int a, int b, int c) {
        int[] ans =new int[]{a,b,c};
        Arrays.sort(ans);
        if (ans[0]==0) return ans[1];
        else{
            return maximumScore(ans[0],ans[0]-1,ans[2] - (ans[1]-ans[0]+1) )+(ans[1]-ans[0]+1);
        }
    }
}
