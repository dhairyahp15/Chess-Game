/*This class is a subclass of the ChessPiece. 
 *Queen is one of the Pieces of Chess game. 
*/
public class Queen extends ChessPiece
{
    /*This constructor calls the parent class constructor and assigns the
    color, board reference (passed as parameters) and respective graphics 
    (in this case, black and white png file for Queen). And it sets the 
    default name to the type of piece, (in this case, Queen).*/
    public Queen(String newColor, Board theBoard)
    {
        super("Queen", newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    /*This constructor is almost similar to the first constructor, it is allowing
    us to set a different name.*/
    public Queen(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    /*This method is from the parent class, which is overrided for detecting the valid
    move for the Queen, i.e. what possible moves can a Queen have from current positon.*/
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol)
    {
        // The boolean variable, which is to be returned.
        boolean isValid = false;

        // This is the boolean variable to check if there is any piece, between the valid moves.
        // Since queen could have n number of moves, which is based on the pieces which could block it.
        boolean gotPiece = false;

        // Board reference to our present board, which is used multiple times in this method.
        Board b = super.getBoard();

        /*Integer variables for storing difference between current and future positions of rows and columns, which is 
        the core logic to detect the valid moves.*/
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;

        // Detecting valid moves Diagonally using cResult and rResult logic.
        if(rResult == cResult || rResult == -cResult)
        {
            // Checking moves on the top right side of the current row and column.
            if(rResult > 0 && cResult > 0)
            {
                for(int i = currentRow + 1, j = currentCol + 1; i <= futureRow && j <= futureCol; i++, j++)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
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

            // Checking moves on the bottom left side of the current row and column.
            if(rResult < 0 && cResult < 0)
            {
                for(int i = currentRow - 1, j = currentCol - 1; i >= futureRow && j >= futureCol; i--, j--)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
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

            // Checking moves on the bottom right side of the current row and column.
            if(rResult < 0 && cResult > 0)
            {
                for(int i = currentRow - 1, j = currentCol + 1; i >= futureRow && j <= futureCol; i--, j++)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
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

            // Checking moves on the top left side of the current row and column.
            if(rResult > 0 && cResult < 0)
            {
                for(int i = currentRow + 1, j = currentCol - 1; i <= futureRow && j >= futureCol; i++, j--)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, j)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
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
        // Detecting valid moves for the Same Row, (i.e. horizontal moves).
            // Checking moves on the right side of the current columnn.    
            if(cResult > 0)
            {
                for(int i = currentCol + 1; i <= futureCol; i++)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(currentRow, i)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
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

            // Checking moves on the left side of the current columnn.
            if(cResult < 0)
            {
                for(int i = currentCol - 1; i >= futureCol; i--)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(currentRow, i)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
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

        // Detecting valid moves for the Same Column, (i.e. vertical moves).
            // Checking moves on the Top of the current row.
            if(rResult > 0)
            {
                for(int i = currentRow + 1; i <= futureRow; i++)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, currentCol)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
                        else if(!(b.getPieceColor(i, currentCol)).equals(b.getPieceColor(currentRow, currentCol)))
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

            // Checking moves on the bottom of the current row.
            if(rResult < 0)
            {
                for(int i = currentRow - 1; i >= futureRow; i--)
                {
                    // This will check for the valid moves until it gets any kind of chess piece in between.
                    if(!gotPiece)
                    {
                        if(!(b.hasPiece(i, currentCol)))
                            isValid = true;
                        
                            // Capturing move if the color is different.
                        else if(!(b.getPieceColor(i, currentCol)).equals(b.getPieceColor(currentRow, currentCol)))
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
        return isValid; // Returning a boolean as a valid move or not.
    }
}
