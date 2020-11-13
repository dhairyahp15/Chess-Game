public class Bishop extends ChessPiece
{
    public Bishop(String newColor, Board theBoard)
    {
        super("Bishop", newColor, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }

    public Bishop(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol)
    {
        boolean isValid = false;
        boolean gotPiece = false;
        Board b = super.getBoard();
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;
        if(rResult == cResult || rResult == -cResult)
        {
            if(rResult > 0 && cResult > 0)
            {
                for(int i = currentRow + 1, j = currentCol + 1; i <= futureRow && j <= futureCol; i++, j++)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        else if(!(b.getPieceColor(currentRow, currentCol).equals(b.getPieceColor(i, j))))
                        {
                            isValid = true;
                            gotPiece = true;                            
                        }
                        else
                        {
                            isValid = false;
                            gotPiece = true;
                        }
                    }
                    else
                        isValid = false;
                }
            }
            if(rResult < 0 && cResult < 0)
            {
                for(int i = currentRow - 1, j = currentCol - 1; i >= futureRow && j >= futureCol; i--, j--)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        else if(!(b.getPieceColor(currentRow, currentCol).equals(b.getPieceColor(i, j))))
                        {
                            isValid = true;
                            gotPiece = true;                            
                        }
                        else
                        {
                            isValid = false;
                            gotPiece = true;
                        }
                    }
                    else
                        isValid = false;
                }
            }
            if(rResult < 0 && cResult > 0)
            {
                for(int i = currentRow - 1, j = currentCol + 1; i >= futureRow && j <= futureCol; i--, j++)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        else if(!(b.getPieceColor(currentRow, currentCol).equals(b.getPieceColor(i, j))))
                        {
                            isValid = true;
                            gotPiece = true;                            
                        }
                        else
                        {
                            isValid = false;
                            gotPiece = true;
                        }
                    }
                    else
                        isValid = false;
                }
            }
            if(rResult > 0 && cResult < 0)
            {
                for(int i = currentRow + 1, j = currentCol - 1; i <= futureRow && j >= futureCol; i++, j--)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        else if(!(b.getPieceColor(currentRow, currentCol).equals(b.getPieceColor(i, j))))
                        {
                            isValid = true;
                            gotPiece = true;                            
                        }
                        else
                        {
                            isValid = false;
                            gotPiece = true;
                        }
                    }
                    else
                        isValid = false;
                }
            }
        }
        return isValid;
    } 
}
