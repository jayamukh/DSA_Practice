class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m  = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n-1;
        while(i >= 0 && i <= m-1 && j >=0 && j<=n-1)
        {
            if(target == matrix[i][j])
            {
                return true;
            }
            if (matrix[i][j] > target) {
        j--;
      } else {
        i++;
      }
            
        
        }
        return false;
    }
}