public class Knight extends ChessPiece
{
    public Knight(String newColor, Board theBoard)
    {
        super("Knight", newColor, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");
    }

    public Knight(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("KnightBlack.png", "KnightWhite.png");
    }
}
