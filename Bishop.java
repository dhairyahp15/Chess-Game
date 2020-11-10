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
}
