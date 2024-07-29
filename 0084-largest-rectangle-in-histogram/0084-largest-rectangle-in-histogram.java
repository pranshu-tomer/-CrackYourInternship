class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int ans = 0;
        Stack<Integer> temp = new Stack<>();

        for(int i=0; i<n; i++){

            while(!temp.isEmpty() && heights[temp.peek()] >= heights[i]){
                int curr = temp.pop();
                int left = (temp.isEmpty())?-1:temp.peek();
                int val = (heights[curr]*(i-left-1));
                ans = Math.max(ans,val);
            }

            temp.push(i);
        }

        while(!temp.isEmpty()){
            int curr = temp.pop();
            int left = (temp.isEmpty())?-1:temp.peek();
            int val = (heights[curr]*(n-left-1));
            ans = Math.max(ans,val);
        }

        return ans;
    }
}