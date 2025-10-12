import java.util.ArrayList;
import java.util.List;
class Solution {
    List<List<String>> res=new ArrayList<>(10);
    boolean isSafe(int [][] board,int []pos,int n)
    {
        int cnt=0;
        for (int i = 0; i <n ; i++) {
            if(board[pos[0]][i]==1)
                return  false;
            if(board[i][pos[1]]==1)
                return  false;
        }
        // check main diagonal
        int x=pos[0];
        int y=pos[1];
        while (x>0 && y>0) {
            x--;
            y--;
        }
        // will start from start
        for(int i= x,j=y;i<board.length && j<board[0].length;i++,j++)
        {
            if(board[i][j]==1)
                return  false;
        }
        
        x=pos[0];
        y=pos[1];
        while (x<board.length-1 && y>0)
        {
            x++;
            y--;
        }
        // in L manner 
        for (int i = x,j=y; i>=0 && j<board.length; i--,j++) {
            if(board[i][j]==1)
                return  false;
        }
        return  true;
    }
    void printBoard(int [][] board)
    {
        List<String> snap=new ArrayList<>(board.length);
        for (int i = 0; i < board.length; i++) {
            StringBuilder str=new StringBuilder(board.length);
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]==1)
                    str.append('Q');
                else str.append('.');
            }
            snap.add(str.toString());
        }
        res.add(snap);
    }
    void dfs(int [] [] board,int row)
    {
        if(row>=board.length)
        {
            // print board
            printBoard(board);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(isSafe(board,new int[]{row,i}, board.length))
            {
                board[row][i]=1;
                dfs(board,row+1);
                board[row][i]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int [][] board=new int[n][n];
        dfs(board,0);
        return  res;
    }
}