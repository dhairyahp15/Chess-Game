
public class Castle extends ChessPiece
{
    public Castle(String newColor, Board theBoard)
    {
        super("Castle", newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    public Castle(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("CastleBlack.png", "CastleWhite.png");
    }

    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol)
    {
        boolean isValid = false;
        boolean gotPiece = false;
        Board b = super.getBoard();
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;

        if(currentRow == futureRow)
        {
            if(cResult > 0)
            {
                for(int i = currentCol + 1; i <= futureCol; i++)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(currentRow, i)))
                            isValid = true;
                        else if(!(b.getPieceColor(currentRow, i)).equals(b.getPieceColor(currentRow, currentCol)))
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
            if(cResult < 0)
            {
                for(int i = currentCol - 1; i >= futureCol; i--)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(currentRow, i)))
                            isValid = true;
                        else if(!(b.getPieceColor(currentRow, i)).equals(b.getPieceColor(currentRow, currentCol)))
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
        else if(currentCol == futureCol)
        {
            if(rResult > 0)
            {
                for(int i = currentRow + 1; i <= futureRow; i++)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, currentCol)))
                            isValid = true;
                        else if(!(b.getPieceColor(i, currentCol)).equals(b.getPieceColor(currentRow, currentCol)))
                        {
                            isValid = true;
                            gotPiece = true;                        }
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
            if(rResult < 0)
            {
                for(int i = currentRow - 1; i >= futureRow; i--)
                {
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, currentCol)))
                            isValid = true;
                        else if(!(b.getPieceColor(i, currentCol)).equals(b.getPieceColor(currentRow, currentCol)))
                        {
                            isValid = true;
                            gotPiece = true;                        }
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
