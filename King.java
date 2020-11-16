/*This class is a subclass of the ChessPiece. 
 *King is one of the Pieces of Chess game. 
*/
public class King extends ChessPiece
{
    /*This constructor calls the parent class constructor and assigns the
    color, board reference (passed as parameters) and respective graphics 
    (in this case, black and white png file for King). And it sets the 
    default name to the type of piece, (in this case, King).*/
    public King(String newColor, Board theBoard)
    {
        super("King", newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    /*This constructor is almost similar to the first constructor, it is allowing
    us to set a different name.*/
    public King(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    /*This method is from the parent class, which is overrided for detecting the valid
    move for the King, i.e. what possible moves can a King have from current positon.*/
    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol )
    {
        // The boolean variable, which is to be returned.
        boolean isValid = false;

        // Board reference to our present board, which is used multiple times in this method.
        Board b = super.getBoard();

        /*Integer variables for storing difference between current and future positions of rows and columns, which is 
        the core logic to detect the valid moves.*/
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;

        // Detecting valid moves in all the directions.
        if((rResult <= 1 && rResult >=-1) && (cResult <= 1 && cResult >= -1))
        {
            if(!(b.hasPiece(futureRow, futureCol)))
                isValid = true;

            // Capturing move if the color is different.
            else if(b.hasPiece(futureRow, futureCol))
            {
                if(!(b.getPieceColor(currentRow, currentCol).equals(b.getPieceColor(futureRow, futureCol))))
                    isValid = true;
            }
        }
        return isValid; // Returning a boolean as a valid move or not.
    }
}
