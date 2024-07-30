class Solution {
    public String intToRoman(int num) {
        String ch[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int val[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};

        int i = 12;
        String ans = "";

        while(num > 0){
            if(num >= val[i]){
                ans = ans + ch[i];
                num = num - val[i];
            }else{
                i--;
            }
        }

        return ans;
    }
}