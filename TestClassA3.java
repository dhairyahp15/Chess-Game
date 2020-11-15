public class TestClassA3{
	
  private static final int pauseTime = 3000;

  public static void main(String[] args){

    // I usually just comment these out as I need them / don' need them. 
    // it can be hard to tell what is being tested!
    // This is all just provided as an example, you should be testing your own code yourself. 
    // And providing the test class as part of the handin package. 
    
  	/*phase1();
  	StdDraw.show(pauseTime);  // Draw all art and pause for 1 second
  	phase2(); // Castle and Pawn Test
  	StdDraw.show(pauseTime); // Draw all art and pause for 1 second
    phase3_king();
    StdDraw.show(pauseTime); // Draw all art and pause for 1 second
    phase3_pawn();
    StdDraw.show(pauseTime); // Draw all art and pause for 1 second
    phase3_knight();
    StdDraw.show(pauseTime); // Draw all art and pause for 1 second
    phase3_castle();
    StdDraw.show(pauseTime); // Draw all art and pause for 1 second
    phase3_bishop();
    StdDraw.show(pauseTime); // Draw all art and pause for 1 second*/
    phase3_queen();
    StdDraw.show(pauseTime); // Draw all art and pause for 1 second
  }

  // Should be a board with one red and one black tile in the corners (see images. )
  public static void phase1(){
    Board b = new Board();

    System.out.println("------::: PHASE 1 TESTS :::-----");

    ChessPiece c1 = new King("BLACK", b);
    ChessPiece c2 = new Pawn("Pawn", "BLACK", b);

    System.out.println("CONSTRUCTOR TEST:");
    System.out.println(c1.toString());
    System.out.println(c2.toString());

    System.out.println("\nAttempt 1 - Error - No Tiles: ");
    b.drawBoard();
    b.drawPiece(1,1);
    b.drawPiece(6,6);


    // This should fail since there is no pieces on the board yet and drawPiece draws the piece. 
    try{
      System.out.println("Attempt 2 - (1,1) (6,6) Corner Tiles: OOPS - it should be BLACK or Board.black, not Black ");
      b.setPiece(1,1, new Pawn("Pawn1", "Black", b));
      b.setPiece(6,6, new Pawn("Pawn2", "Whites", b));
      b.drawPiece(1,1);
      b.drawPiece(6,6);
    }catch(Exception e){
      System.out.println(e);
      // e.printStackTrace();
    }


    b.setPiece(1,1, new Pawn("Pawn3", "BLACK", b));
    b.setPiece(6,6, new Pawn("Pawn4", "WHITE", b));
    b.drawPiece(1,1);
    b.drawPiece(6,6);

    b.setPiece(2,2, new Pawn("Pawn5", "BLACK", b));
    b.setPiece(5,5, new Pawn("Pawn6", "WHITE", b));
    b.drawPieces();
  }

  // Should be the board set up with tiles 
  // Test Selected on given tiles. 
  public static void phase2(){
    Board b = new Board();

    System.out.println("-----::: PHASE 2 TESTS :::-----");
    System.out.println("Testing BoardLoader method: ");
    BoardLoader.loadBoardState(b, "StandardBoard.txt");
    b.drawBoard();
    b.drawPieces();

    StdDraw.show(pauseTime);  // Draw all art and pause for 1 second

    b.setPiece(5,5, new Pawn("Pawn5", "BLACK", b));
    b.setPiece(2,2, new Pawn("Pawn6", "WHITE", b));
    b.setPiece(2,5, new Castle("CastleB1", "BLACK", b));
    b.setPiece(5,2, new Castle("CastleW1", "WHITE", b));

    System.out.println("hasPiece " + 2 + "," + 5 + b.hasPiece(2,5));
    System.out.println("hasPiece " + 3 + "," + 5 + b.hasPiece(3,5));
    b.drawBoard();
    b.drawPieces();

    b.drawSelectedForSingleMove(2,5,7,5);
    b.drawSelectedForSingleMove(2,5,2,7);

    StdDraw.show(pauseTime);  // Draw all art and pause for 1 second
  }

  // Should be the board set up with tiles 
  // Test Selected on given tiles. 

  public static void phase3()
  {
    Board b = new Board();
    b.setPiece(5,5, new Pawn("Pawn5", "BLACK", b));
    b.setPiece(2,2, new Pawn("Pawn6", "WHITE", b));
    b.drawBoard();
    b.drawPieces();

    b.drawSelectedForAllValidMoves(2,2);
    StdDraw.show(pauseTime);  // Draw all art and pause for 1 second
    b.drawSelectedForAllValidMoves(5,5);
    StdDraw.show(pauseTime);  // Draw all art and pause for 1 second
    // Clear selection
    b.drawBoard();
    b.drawPieces();
  }
  public static void phase3_king(){
    Board b = new Board();

    System.out.println("-----::: PHASE 3 TESTS :::-----");
    System.out.println("\nTesting KING Piece:");
    b.setPiece(5, 5, new King("KingB", "BLACK", b));
    b.setPiece(0, 0, new King("KingW", "WHITE", b));
    b.setPiece(5, 4, new Pawn("Pawn1", "WHITE", b));
    b.setPiece(1, 0, new Pawn("Pawn1", "BLACK", b));
    b.drawBoard();
    b.drawPieces();
    b.drawSelectedForAllValidMoves(5, 5);
    b.drawSelectedForAllValidMoves(0, 0);
  }

  public static void phase3_pawn()
  {
    Board b = new Board();

    System.out.println("\nTesting PAWN Piece:");
    b.setPiece(6, 7, new Pawn("PawnB", "BLACK", b));
    b.setPiece(1, 1, new Pawn("PawnW", "WHITE", b));
    b.setPiece(5, 6, new Pawn("Pawn1", "BLACK", b));
    b.setPiece(6, 6, new Bishop("Bishop", "WHITE", b));
    b.setPiece(2, 2, new Pawn("Pawn1", "BLACK", b));
    b.drawBoard();
    b.drawPieces();
    b.drawSelectedForAllValidMoves(6, 7);
    b.drawSelectedForAllValidMoves(1, 1);
  }

  public static void phase3_knight()
  {
    Board b = new Board();

    System.out.println("\nTesting KNIGHT Piece:");
    b.setPiece(4, 5, new Knight("KnightB", "BLACK", b));
    b.setPiece(0, 1, new Knight("KinghtW", "WHITE", b));
    b.setPiece(6, 6, new Bishop("Bishop", "WHITE", b));
    b.drawBoard();
    b.drawPieces();
    b.drawSelectedForAllValidMoves(4, 5);
    b.drawSelectedForAllValidMoves(0, 1);
  }

  public static void phase3_castle()
  {
    Board b = new Board();

    System.out.println("\nTesting CASTLE Piece:");
    b.setPiece(4, 5, new Castle("CastleW", "WHITE", b));
    b.setPiece(6, 3, new Bishop("BishopB", "BLACK", b));
    b.setPiece(4, 1, new Pawn("PawnW", "BLACK", b));
    b.setPiece(4, 3, new Castle("CastleB", "BLACK", b));
    b.setPiece(1, 3, new Bishop("Bishop1", "WHITE", b));
    b.drawBoard();
    b.drawPieces();
    b.drawSelectedForAllValidMoves(4, 3);
  }

  public static void phase3_bishop()
  {
    Board b = new Board();
    
    System.out.println("\nTesting BISHOP Piece:");
    b.setPiece(2, 4, new Bishop("BishopB", "BLACK", b));
    b.setPiece(4, 6, new Pawn("PawnB", "BLACK", b));
    b.setPiece(3, 3, new Pawn("PawnB", "WHITE", b));
    b.setPiece(1, 1, new Knight("PawnB", "BLACK", b));
    b.drawBoard();
    b.drawPieces();
    b.drawSelectedForAllValidMoves(2, 4);
  }

  public static void phase3_queen()
  {
    Board b = new Board();
    
    System.out.println("\nTesting QUEEN Piece:");
    b.setPiece(2, 4, new Queen("QueenB", "BLACK", b));
    b.setPiece(5, 4, new Queen("QueenW", "WHITE", b));
    b.setPiece(2, 1, new Pawn("PawnW", "WHITE", b));
    b.setPiece(2, 7, new Pawn("PawnB", "BLACK", b));
    b.setPiece(6, 0, new Pawn("PawnW", "BLACK", b));
    b.setPiece(0, 2, new Knight("KnightB", "BLACK", b));
    b.drawBoard();
    b.drawPieces();
    b.drawSelectedForAllValidMoves(2, 4);
  }

} 