
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
        boolean likePiece = false;
        Board b = super.getBoard();
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;
        
        if((rResult >= -7 && rResult <= 7) && (cResult >= -7 && rResult <= 7))
        {
            if(currentRow == futureRow)
            {
                if(cResult > 0)
                {
                    for(int i = currentCol + 1; i <= futureCol; i++)
                    {
                        if(!likePiece)
                        {
                            if(!(b.hasPiece(currentRow, i)))
                                isValid = true;
                            else if(!(b.getPieceColor(currentRow, i)).equals(b.getPieceColor(currentRow, currentCol)))
                            {
                                isValid = true;
                                likePiece = true;
                            }
                            else
                            {
                                isValid = false;
                                break;
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
                        if(!likePiece)
                        {
                            System.out.println(i);
                            if(!(b.hasPiece(currentRow, i)))
                                isValid = true;
                            else if(!(b.getPieceColor(currentRow, i)).equals(b.getPieceColor(currentRow, currentCol)))
                            {
                                isValid = true;
                                likePiece = true;
                            }
                            else
                            {
                                isValid = false;
                                break;
                            }
                        }
                        else
                        {
                           isValid = false;
                            break;
                        }
                    }
                }
            }
            else if(currentCol == futureCol)
            {
                if(rResult > 0)
                {
                    for(int i = currentRow + 1; i <= futureRow; i++)
                    {
                        if(!likePiece)
                        {
                            if(!(b.hasPiece(i, currentCol)))
                                isValid = true;
                            else if(!(b.getPieceColor(i, currentCol)).equals(b.getPieceColor(currentRow, currentCol)))
                            {
                                isValid = true;
                                likePiece = true;
                            }
                            else
                            {
                                isValid = false;
                                break;
                            }
                        }
                        else
                            isValid = false;
                    }
                }
                if(rResult < 0)
                {
                    for(int i = currentRow -1; i >= futureRow; i--)
                    {
                        if(!likePiece)
                        {
                            if(!(b.hasPiece(i, currentCol)))
                                isValid = true;
                            else if(!(b.getPieceColor(i, currentCol)).equals(b.getPieceColor(currentRow, currentCol)))
                            {
                                isValid = true;
                                likePiece = true;
                            }
                            else
                            {
                                isValid = false;
                                break;
                            }
                        }
                        else
                            isValid = false;
                    }
                }
            }
        }
        return isValid;
    }
}
