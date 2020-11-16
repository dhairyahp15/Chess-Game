/*This class is a subclass of the ChessPiece. 
 *Bishop is one of the Pieces of Chess game. 
*/
public class Bishop extends ChessPiece
{
    /*This constructor calls the parent class constructor and assigns the
    color, board reference (passed as parameters) and respective graphics 
    (in this case, black and white png file for bishop). And it sets the 
    default name to the type of piece, (in this case, bishop).*/
    public Bishop(String newColor, Board theBoard)
    {
        super("Bishop", newColor, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }

    /*This constructor is almost similar to the first constructor, it is allowing
    us to set a different name.*/
    public Bishop(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("BishopBlack.png", "BishopWhite.png");
    }

    /*This method is from the parent class, which is overrided for detecting the valid
    move for the Bishop, i.e. what possible moves can a Bishop have from current positon.*/
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol)
    {
        // The boolean variable, which is to be returned.
        boolean isValid = false;

        // This is the boolean variable to check if there is any piece, between the valid moves.
        // Since bishop could have n number of moves, which is based on the pieces which could block it.
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
        return isValid; // Returning a boolean as a valid move or not.
    } 
}
