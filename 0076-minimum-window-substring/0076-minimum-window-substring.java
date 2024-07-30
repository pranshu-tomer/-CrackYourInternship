class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        HashMap<Character,Integer> temp = new HashMap<>();
        for(int i=0; i<m; i++){
            temp.put(t.charAt(i),temp.getOrDefault(t.charAt(i),0)+1);
        }

        int l = 0;
        int r = 0;
        int count = 0;

        int len = Integer.MAX_VALUE;
        int idx = -1;
        while(l < n && r < n){
            char curr = s.charAt(r);
            if(temp.containsKey(curr)){
                int val = temp.get(curr);
                val--;
                if(val >= 0){
                    count++;
                }
                temp.put(curr,val);
            }
            while(l < n && count == m){
                if(len > (r-l+1)){
                    len = r-l+1;
                    idx = l;
                }
                curr = s.charAt(l);
                if(temp.containsKey(curr)){
                    int val = temp.get(curr);
                    val++;
                    if(val > 0){
                        count--;
                    }
                    temp.put(curr,val);
                }
                l++;
            }
            r++;
        }
        
        if(idx == -1){
            return "";
        }else{
            return s.substring(idx,idx+len);
        }
    }
}