public class King extends ChessPiece
{
    public King(String newColor, Board theBoard)
    {
        super("King", newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    public King(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol )
    {
        boolean isValid = false;
        Board b = super.getBoard();
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;
        if((rResult <= 1 && rResult >=-1) && (cResult <= 1 && cResult >= -1))
        {
            if(!(b.hasPiece(futureRow, futureCol)))
                isValid = true;
            else if(b.hasPiece(futureRow, futureCol))
            {
                if(!(b.getPieceColor(currentRow, currentCol).equals(b.getPieceColor(futureRow, futureCol))))
                    isValid = true;
            }
        }
        return isValid;
    }
}
