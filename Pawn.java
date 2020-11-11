public class Pawn extends ChessPiece
{
    public Pawn(String newColor, Board theBoard)
    {
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");
    }
    
    public Pawn(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");
    }
    
    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol)
    {
        boolean isValid = false;
        Board b = super.getBoard();
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;
        String color = b.getPieceColor(currentRow, currentCol);
        if(color.equals("WHITE"))
        {
            if(rResult == 1 && (cResult <= 1 && cResult >= -1))
            {
                if(!(b.hasPiece(futureRow, futureCol)))
                {      
                    if(cResult == 0)
                        isValid = true;
                }
                if(b.hasPiece(futureRow, futureCol))
                {
                    if(b.getPieceColor(futureRow, futureCol).equals("BLACK") && cResult != 0)
                        isValid = true;
                }
            }
        }
        else
        {
            if(rResult == -1 && (cResult <= 1 && cResult >= -1))
            {
                if(!(b.hasPiece(futureRow, futureCol)))
                {      
                    if(cResult == 0)
                        isValid = true;
                }
                if(b.hasPiece(futureRow, futureCol))
                {
                    if(b.getPieceColor(futureRow, futureCol).equals("WHITE") && cResult != 0)
                        isValid = true;
                }
            }
        }
        return isValid;
    }
}
