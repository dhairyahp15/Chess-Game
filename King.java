public class King extends ChessPiece
{
    public King(String newColor, Board theBoard)
    {
        super("King", newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }

    public King(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("KingBlack.png", "KingWhite.png");
    }
}
