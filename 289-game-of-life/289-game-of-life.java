class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] newBoard = new int[board.length][board[0].length];
        //boolean[][] vis = new boolean[][];
        
        int m = board.length;
        int n = board[0].length;
        
        int[][] dirs = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        for(int i = 0; i< m; i++)
        {
            for(int j = 0; j< n; j++)
            {
                int member = board[i][j];
                if(member == 0)
                {
                    int count  = 0;
                    for(int[] dir:dirs)
                    {
                        int newi = i+dir[0];
                         int newj = j+dir[1];
                        if(newi>=0 && newi < m && newj>=0 && newj < n)
                        {
                            if(board[newi][newj] == 1)
                                count ++;
                        }
                    }
                    if(count == 3)
                    {
                        newBoard[i][j] = 1;
                    }
                }
                else // 1
                {
                    int zeroCount  = 0;
                    int oneCount  = 0;
                    for(int[] dir:dirs)
                    {
                        int newi = i+dir[0];
                         int newj = j+dir[1];
                        if(newi>=0 && newi < m && newj>=0 && newj < n)
                        {
                            
                            if(board[newi][newj] == 1)
                                oneCount++;
                           
                        }
                        
                        if(oneCount < 2)
                            newBoard[i][j] = 0;
                        else if(oneCount >= 2 && oneCount <= 3)
                            newBoard[i][j] = 1;
                        else if(oneCount > 3)
                            newBoard[i][j] = 0;
                    }
                }
                //System.out.println(newBoard[i][j]);
            }
            
        }
        
      for(int i=0; i<board.length; i++)
  for(int j=0; j<board[i].length; j++)
    board[i][j]=newBoard[i][j];
        
    }
}