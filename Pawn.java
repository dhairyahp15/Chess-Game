/*This class is a subclass of the ChessPiece. 
 *Pawn is one of the Pieces of Chess game. 
*/
public class Pawn extends ChessPiece
{
    /*This constructor calls the parent class constructor and assigns the
    color, board reference (passed as parameters) and respective graphics 
    (in this case, black and white png file for pawn). And it sets the 
    default name to the type of piece, (in this case, Pawn).*/
    public Pawn(String newColor, Board theBoard)
    {
        super("Pawn", newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");
    }
    
    /*This constructor is almost similar to the first constructor, it is allowing
    us to set a different name.*/
    public Pawn(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("PawnBlack.png", "PawnWhite.png");
    }
    
    /*This method is from the parent class, which is overrided for detecting the valid
    move for the pawn, i.e. what possible moves can a Pawn have from current positon.*/
    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol)
    {
        // The boolean variable, which is to be returned.
        boolean isValid = false;

        // Board reference to our present board, which is used multiple times in this method.
        Board b = super.getBoard();

        /*Integer variables for storing difference between current and future positions of rows and columns, which is 
        the core logic to detect the valid moves.*/
        int rResult = futureRow - currentRow, cResult = futureCol - currentCol;

        /*Since it is Pawn, it cannot move in backward directionn, it can move only towards opponent side. 
        Therefore, the moves should be detected by differentiating between colors.*/
        // So, the string variable for the color of current piece.
        String color = b.getPieceColor(currentRow, currentCol);

        // Detecting valid moves for the WHITE color piece.
        if(color.equals("WHITE"))
        {
            /*<><>><> This is for the bonus, that the pawn can take two steps initially. <><><>*/
            if(currentRow == 1 && (rResult == 2 && cResult == 0))
            {
                if(!(b.hasPiece(currentRow + 1, currentCol)))
                isValid = true;
            }
                if(rResult == 1 && (cResult <= 1 && cResult >= -1))
            {
                if(!(b.hasPiece(futureRow, futureCol)))
                {      
                    if(cResult == 0)
                        isValid = true;
                }
                
                // Capturing move if the color is different.
                if(b.hasPiece(futureRow, futureCol))
                {
                    if(b.getPieceColor(futureRow, futureCol).equals("BLACK") && cResult != 0)
                        isValid = true;
                }
            }
        }
        // The else part is for the BLACK piece of PAWN.
        else
        {
            /*<><>><> This is for the bonus, that the pawn can take two steps initially. <><><>*/
            if(currentRow == 6 && (rResult == -2 && cResult == 0))
            {
                if(!(b.hasPiece(currentRow - 1, currentCol)))
                isValid = true;
            }
            if(rResult == -1 && (cResult <= 1 && cResult >= -1))
            {
                if(!(b.hasPiece(futureRow, futureCol)))
                {      
                    if(cResult == 0)
                        isValid = true;
                }
                
                // Capturing move if the color is different.
                if(b.hasPiece(futureRow, futureCol))
                {
                    if(b.getPieceColor(futureRow, futureCol).equals("WHITE") && cResult != 0)
                        isValid = true;
                }
            }
        }
        return isValid; // Returning a boolean as a valid move or not.
    }
}
