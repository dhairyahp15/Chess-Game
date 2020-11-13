public class Knight extends ChessPiece
{
    public Knight(String newColor, Board theBoard)
    {
        super("Knight", newColor, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");
    }

    public Knight(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");
    }

    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol)
    {
        boolean isValid = false;
        Board b = super.getBoard();
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;
        if((rResult >= -2 && rResult <= 2) && (cResult >= -2 && cResult <= 2))
        {
            if(!(b.hasPiece(futureRow, futureCol)))
            {
                if((rResult + cResult) % 2 != 0  && (futureRow != currentRow && futureCol != currentCol))
                    isValid = true;
            }
            else if(!(b.getPieceColor(currentRow, currentCol).equals(b.getPieceColor(futureRow, futureCol))))
            {
                if((rResult + cResult) % 2 != 0  && (futureRow != currentRow && futureCol != currentCol))
                    isValid = true;
            }
        }
        return isValid;
    }
}
