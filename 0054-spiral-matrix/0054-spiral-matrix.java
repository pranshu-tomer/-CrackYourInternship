class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = m-1;
        int up = 0;
        int down = n-1;

        int i = 0;
        while(left <= right && up <= down){
            i = left;
            while(up <= down && i <= right){
                ans.add(matrix[up][i]);
                i++;
            }

            up++;
            i = up;
            while(left<= right && i <= down){
                ans.add(matrix[i][right]);
                i++;
            }

            right--;
            i = right;
            while(up <= down && i >= left){
                ans.add(matrix[down][i]);
                i--;
            }

            down--;
            i = down;
            while(left<= right && i >= up){
                ans.add(matrix[i][left]);
                i--;
            }
            left++;
        }

        return ans;
    }
}