class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int i=0; i<haystack.length(); i++){

            int temp = i;
            int j = 0;
            while(j<needle.length()&&i<haystack.length()        
            &&haystack.charAt(i)== needle.charAt(j)){
                i++;
                j++;
            }
            if(j == needle.length()){
                return temp;
            }
            if(i == haystack.length()){
                return -1;
            }
            i = temp;
        }

        return -1;
    }
}