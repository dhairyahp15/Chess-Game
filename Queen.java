public class Queen extends ChessPiece
{
    public Queen(String newColor, Board theBoard)
    {
        super("Queen", newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    public Queen(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol)
    {
        boolean isValid = false;
        boolean gotPiece = false;
        Board b = super.getBoard();
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;

        if(rResult == cResult || rResult == -cResult)
        {
            if(rResult > 0 && cResult >= 0)
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
            if(rResult < 0 && cResult <= 0)
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
            if(rResult <= 0 && cResult > 0)
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
            if(rResult >= 0 && cResult < 0)
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
        else if(currentRow == futureRow || currentCol == futureCol)
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
