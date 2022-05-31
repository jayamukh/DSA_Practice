class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       /* int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;*/
        
        //with Binary Search
        
        int m  = matrix.length;
        int n = matrix[0].length;
        
        if(m == 0 || n==0)
            return false;
        int left = 0, right = n*m -1;
        
        int pivotInd = 0, pivotVal = 0;
        
        while(left <= right)
        {
            pivotInd = (left+right)/2;
            
            pivotVal = matrix[pivotInd/n][pivotInd%n];
            if(pivotVal > target)
            {
                right = pivotInd-1;
            }
            else if(pivotVal < target)
            {
                left = pivotInd+1;
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
}