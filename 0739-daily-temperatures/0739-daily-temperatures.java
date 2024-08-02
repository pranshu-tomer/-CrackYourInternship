class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Stack<Integer> temp = new Stack<>();
        int ans[] = new int[n];

        for(int i=0; i<n; i++){

            while(!temp.isEmpty() && temperatures[temp.peek()]<temperatures[i]){
                int idx = temp.pop();
                ans[idx] = i - idx;
            }

            temp.push(i);
        }

        while(!temp.isEmpty()){
            ans[temp.pop()] = 0;
        }
        
        return ans;
    }
}