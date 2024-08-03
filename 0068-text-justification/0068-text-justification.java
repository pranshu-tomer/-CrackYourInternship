class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder("");

        int len = 0;
        int total = 0;
        for(int i=0; i<words.length; i++){
            String word = words[i];

            if(len+word.length() <= maxWidth){
                len = len + word.length() + 1;
                total++;
            }else{
                len = len - total;
                int space = (total > 1)?
                (maxWidth - len)/(total-1):(maxWidth - len);
                int rem = (total > 1)?(maxWidth - len)%(total-1):0;

                String s = "";
                while(space > 0){
                    s = s + " ";
                    space--;
                }

                boolean spaceIncluded = false;
                while(total > 1){
                    curr.append(words[i-total]);
                    total--;
                    curr.append(s);
                    if(rem > 0){
                        curr.append(' ');
                        rem--;
                    }
                    spaceIncluded = true;
                }

                curr.append(words[i-total]);
                if(!spaceIncluded){
                    curr.append(s);
                }
                total = 1;
                len = words[i].length()+1;
                ans.add(curr.toString());
                curr = new StringBuilder("");
            }
        }

        int n = words.length;
        int space = maxWidth-len+total;
        while(total > 0){
            curr.append(words[n-total]);
            if(space > 0) curr.append(' ');
            space--;
            total--;
        }

        while(space > 0){
            curr.append(' ');
            space--;
        }

        ans.add(curr.toString());

        return ans;
    }
}