package medium;

public class Solution6079 {



    public String discountPrices(String sentence, int discount) {
        String[] arr=sentence.split(" ");
        StringBuilder result=new StringBuilder();
        for (int i=0;i<arr.length;i++){
            Double doublt = valid(arr[i]);
            if (doublt==null) result.append(arr[i]);
            else{
                result.append("$")
                        .append(String.format("%.2f",doublt*(100-discount)/100));
            }
            if (i< arr.length-1) result.append(" ");
        }
        return result.toString();
    }


    public Double valid(String s){
        if (!s.startsWith("$")) return null;
        else{
            try {
                return Double.valueOf((s.substring(1)));
            }
            catch (Exception e){
                return null;
            }
        }
    }
}
