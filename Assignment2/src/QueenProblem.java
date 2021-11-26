import java.util.ArrayList;
import java.util.List;

public class QueenProblem
{

    int N ;
    List<List<Integer>> board;

    public List<List<Integer>> getBoard()
    {
        return board;
    }

    public QueenProblem(int N)
    {
        this.N = N;
        // initialize the array
        board = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++){
                row.add(0);
            }
            board.add(row);
        }
    }

    // print current board state
    public void print()
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board.get(i).get(j)
                    + " ");
            System.out.println();
        }
    }

    // check if a spot is safe for a queen to be placed.
    boolean isSafe(int row, int col)
    {

        // only checking left side as the right side as always safe
        int i, j;

        // check left side row
        for (i = 0; i < col; i++)
            if (board.get(row).get(i) == 1)
                return false;

        // check left upper diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board.get(i).get(j) == 1)
                return false;

        // check left lower diagonal
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board.get(i).get(j) == 1)
                return false;

        return true;
    }

    // recursive approach
    boolean solve(int col)
    {
        // if all placed
        if (col >= N)
            return true;

        // try placing the queens in all rows of this column
        for (int i = 0; i < N; i++) {
            // if safe to place
            if (isSafe( i, col)) {
                //place it
                List<Integer> row = board.get(i);
                row.set(col,1);
                board.set(i,row);

                // call self for rest of columns
                if (solve(col + 1))
                    return true;

                // backtrack - if no solution at board[col,i] then remove the queeen
                row = board.get(i);
                row.set(col,0);
                board.set(i,row);
            }
        }

        // if no row is good
        return false;
    }

    // call the recursive brother for the first column
    public boolean solve()
    {
        return solve(0);
    }

}