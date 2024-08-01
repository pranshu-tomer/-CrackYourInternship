class Solution {
    public String numberToWords(int num) {

        if(num == 0){
            return "Zero";
        }

        int val[] = {1000,1000000,1000000000};
        // String str[] = {"","One","Two","Three","Four","Five","Six",
        // "Seven","Eight","Nine"};

        String str[] = {"Thousand","Million","Billion"};

        int n = val.length;
        int i = n-1;

        String ans = "";

        while(i >= 0){
            if(num >= val[i]){
                String curr = help(num/val[i]);
                ans = ans + " " + curr + " " + str[i];
                num = num%val[i];
            }
            i--;
        }

        String curr = help(num);
        ans = ans + " " + curr;

        i = 0;
        while(ans.charAt(i) == ' '){
            i++;
        }
        int j = ans.length()-1;
        while(ans.charAt(j) == ' '){
            j--;
        }
        ans = ans.substring(i,j+1);


        return ans;
    }

    public String help(int num){

        if(num == 0){
            return "";
        }
        
        String lastStr[] = {"","One","Two","Three","Four","Five","Six",
        "Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
        "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};

        String str[] = {"","","Twenty","Thirty","Forty","Fifty",
        "Sixty","Seventy","Eighty","Ninety"};

        String ans = "";

        int last = num%100;
        if(last < 20){
            ans = lastStr[last] + " " + ans;
        }else{
            last = num%10;
            ans = (last == 0)?ans:lastStr[last] + " " + ans;
            int n = (num%100)/10;
            ans = (n > 1)?str[n] + " " + ans:ans;
        }

        int n = num/100;
        if(n > 0){
            ans = lastStr[n] + " Hundred " + ans;
        }

        int i = 0;
        while(ans.charAt(i) == ' '){
            i++;
        }
        int j = ans.length()-1;
        while(ans.charAt(j) == ' '){
            j--;
        }
        ans = ans.substring(i,j+1);

        return ans;
    }
}