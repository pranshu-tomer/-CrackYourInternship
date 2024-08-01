class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length == 0){
            return new ArrayList<>();
        }

        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> temp = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String frequency = help(strs[i]);
            List<String> curr;
            if(temp.containsKey(frequency)){
                curr = temp.get(frequency);
            }else{
                curr = new ArrayList<>();
            }
            curr.add(strs[i]);
            temp.put(frequency,curr);
        }

        for(Map.Entry<String,List<String>> entry : temp.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }

    public String help(String str){

        int arr[] = new int[26];

        for(char ch : str.toCharArray()){
            arr[ch-'a']++;
        }

        char c = 'a';
        StringBuilder st = new StringBuilder("");
        for(int f : arr){
            if(f != 0){
                st.append(c);
                st.append(f);
            }
            c++;
        }

        return st.toString();
    }
}