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
}
