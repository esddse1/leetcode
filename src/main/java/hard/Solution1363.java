package hard;

public class Solution1363 {
    public String largestMultipleOfThree(int[] digits) {
        StringBuilder stringBuilder=new StringBuilder();
        int[] nums=new int[10];
        for (int i:digits){
            nums[i]++;
        }
        int a1=0;
        int a2=0;
        for (int i=0;i<9;i++){
            if (i%3==1) a1=(a1+nums[i]);
            if (i%3==2) a2=(a2+nums[i]);
        }
        if ((a1+2*a2)%3==0){

        }else if ((a1+2*a2)%3==1){
            if (a1>0) {
                for (int i = 0; i < 9; i++) {
                    if (i % 3 == 1 && nums[i] > 0) {
                        nums[i]--;
                        break;
                    }
                }
            }
            else{
                int count = 2;
                for (int i = 0; i < 9; i++) {
                    if (i % 3 == 2 && nums[i] > 0) {
                        nums[i]--;
                        count--;
                        if (nums[i]>0 && count>0){
                            nums[i]--;
                            count--;
                        }
                        if (count==0) break;
                    }
                }
            }
        }
        else if ((a1+2*a2)%3==2){
            if (a2>0) {
                for (int i = 0; i < 9; i++) {
                    if (i % 3 == 2 && nums[i] > 0) {
                        nums[i]--;
                        break;
                    }
                }
            }
            else{
                int count = 2;
                for (int i = 0; i < 9; i++) {
                    if (i % 3 == 1 && nums[i] > 0) {
                        nums[i]--;
                        count--;
                        if (nums[i]>0 && count>0){
                            nums[i]--;
                            count--;
                        }
                        if (count==0) break;
                    }
                }
            }
        }
        boolean addZero=false;
        for (int i=9;i>=0;i--){
            for (int j=nums[i];j>0;j--){
                if (i>0) stringBuilder.append(i);
                else{
                    addZero=true;
                    if (stringBuilder.length()>0){
                        stringBuilder.append("0");
                    }
                }
            }
        }
        if (stringBuilder.length()==0){
            if (addZero) return "0";
            return "";
        }
        else{
            return stringBuilder.toString();
        }
    }
    public static void main(String[] args){
        Solution1363 solution1363=new Solution1363();
        System.out.println(solution1363.largestMultipleOfThree(new int[]{9,8,6,8,6}));
        System.out.println(solution1363.largestMultipleOfThree(new int[]{5,8}));
        System.out.println(solution1363.largestMultipleOfThree(new int[]{8,1,9}));
    }
}
