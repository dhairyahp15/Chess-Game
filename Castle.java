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
}
