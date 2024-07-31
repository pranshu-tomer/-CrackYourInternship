class Solution {
    public String simplifyPath(String path) {

       Stack<String> temp = new Stack<>();

       int i=0;
       int n=path.length();

       while(i<n){
            int j=i;
            i++;
            while(i < n && path.charAt(i) != '/'){
                i++;
            }
            if(i == j+1 || (i == j+2 && path.charAt(i-1) == '.')){
                continue;
            }
            if(i == j+3 && path.charAt(i-1) == path.charAt(i-2) && 
            path.charAt(i-1) == '.'){
                if (!temp.isEmpty()) temp.pop();
                continue;
            }
            temp.push(path.substring(j,i));
       }

       path = "";
       while(!temp.isEmpty()){
            path = temp.pop() + path;
       }

       if(path == ""){
            return "/";
       }       

       return path;
    }
}