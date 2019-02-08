public class QueenBoard{
  //2D array stores QueenBoard
  //-1 is Queen, and
  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    for(int x:board[r]) board[r][x] -=1;
    for(int y:board) board[x][c] -=1;
    board[r][c] = -1;
  }
  private boolean removeQueen(int r, int c){
    for(int x:board[r]) board[r][x] +=1;
    for(int y:board) board[x][c] +=1;
    board[r][c] = 0;
  }


  /*
  @return The output string formatted as follows:
  All numbers that represent queens are replaced with 'Q'
  all others are displayed as underscores '_'
  There are spaces between each symbol:
  _ _ Q _
  Q _ _ _
  _ _ _ Q
  _ Q _ _
  */
  public String toString(){}



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){}

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){}


}
