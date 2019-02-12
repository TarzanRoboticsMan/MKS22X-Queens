public class QueenBoard{
    /*public static void main(String[]args){
    QueenBoard obj = new QueenBoard(6);
    obj.addQueen(1,1);
    obj.addQueen(3,3);
    System.out.println(obj);
    obj.addQueen(4,2);
    obj.removeQueen(4,2);
    System.out.println(obj);
  }*/
  //2D array stores QueenBoard
  //-1 is Queen, and
  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    boolean check = true;
    for(int x=0;x<board[r].length;x++){
      if(board[r][x] == -1) check = false;
    }
    for(int y=0;y<board.length;y++){
      if(board[r][y] == -1) check = false;
    }
    if(board[r][c]==0 && check){
      for(int x=0;x<board[r].length;x++) board[r][x] +=1;
      for(int y=0;y<board.length;y++) board[y][c] +=1;
      board[r][c] = -1;
      return true;
    }
    return false;
  }
  private boolean removeQueen(int r, int c){
    for(int x=0;x<board[r].length;x++) board[r][x] -=1;
    for(int y=0;y<board.length;y++) board[y][c] -=1;
    board[r][c] = 0;
    return true;
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
  public String toString(){
    String ans ="";
    for(int row=0;row<board.length;row++){
      for(int col=0;col<board[row].length;col++){
        if(board[row][col]==-1) ans+="Q ";
        else ans+="_ ";
      }
      ans+="\n";
    }
    return ans;
  }



  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;

  *        true when the board is solveable, and leaves the board in a solved state

  *@throws IllegalStateException when the board starts with any non-zero value

  */
  public boolean solve(){
    int[][] test = new int[board.length][board.length];
    if(!board.equals(test)) throw new IllegalStateException();
    return solveR(0);
  }

  private boolean solveR(int x){
    if(x>board.length) return true;
    for(int c=0;c<board[x].length;c++){
      if(addQueen(x,c)){
        if(solveR(x+1))return true;
        removeQueen(x,c);
      }
    }
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    int[][] test = new int[board.length][board.length];
    if(!board.equals(test)) throw new IllegalStateException();
    return solve2(0, 0);
  }

  private int solve2(int x, int solutions){
    if(x>board.length) return 1;
    for(int c=0;c<board[x].length;c++){
      if(addQueen(x,c)){
        solutions += solve2(x+1, 0);
        removeQueen(x,c);
      }
    }
    return solutions;
  }
}
