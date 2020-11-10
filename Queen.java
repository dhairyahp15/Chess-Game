public class Queen extends ChessPiece
{
    public Queen(String newColor, Board theBoard)
    {
        super("Queen", newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }

    public Queen(String name, String newColor, Board theBoard)
    {
        super(name, newColor, theBoard);
        super.setGraphics("QueenBlack.png", "QueenWhite.png");
    }
}
