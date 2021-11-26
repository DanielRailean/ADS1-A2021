import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class QueenProblemTest
{

    QueenProblem queen;
    int maxN = 20;


    @Test
    public void checkRandomSize(){
        for(int i=4;i<=maxN;i++){
            queen = new QueenProblem(i);
            queen.solve();
            queen.print();
            assertTrue(IsValid(queen.getBoard()));
        }
    }

    public boolean IsValid(List<List<Integer>> board)
    {
        int N = board.size();
        for(int i= 0;i<N;i++){
            for(int j= 0;j<N;j++){
                if(board.get(i).get(j)==1){
                    List<Integer> row = board.get(i);
                    row.set(j,0);
                    board.set(i,row);
                    if(!isSafe(board,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isSafe(List<List<Integer>> board,int row, int col)
    {

        int i, j;

        // check left side row
        for (i = 0; i < col; i++)
            if (board.get(row).get(i) == 1)
                return false;

        // check left upper diagonal
        for (i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
            if (board.get(i).get(j) == 1)
                return false;

        // check left lower diagonal
        for (i = row, j = col; j >= 0 && i < board.size(); i++, j--)
            if (board.get(i).get(j) == 1)
                return false;

        return true;
    }


}
