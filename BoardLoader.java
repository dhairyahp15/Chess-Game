// Imported libraries for file reading purpose.
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/*This class is used for loading files from the directory, and writing it 
to 2d string array which is used to initialize the chess board int he 
GameController Class.*/
public class BoardLoader 
{
    /*Since are loading files from the board directory, I have created 
    a string as a path variable and then concatenating it to fileName.*/ 
    public static String boardFolder = ".\\Boards\\"; 

    /*The following method uses all the other methods to load board's initial 
    state from the file.*/
    public static void loadBoardState(Board theBoard, String fileName)
    {
		loadPiecesFromString(theBoard, parseFile(boardFolder + fileName));
    }

    /*This method is used to read the board state from the file and
    store it into the 2D String array. FileReader, BufferedReader are 
    used to read from file and Scanner is used to divide it into tokens
    and store it in the 2D string array.*/
    private static String[][] parseFile(String fileName)
    {
        String[][] result = null; // 2D string array, that is to be returned.
        String s = ""; // String that is used to store lines and further to be divided into tokens.
        Scanner sc = null; // Scanner to divide the string into tokens and storing it in the array.
        int row = 0, col = 0; // row and column variable for the array size.
        try
        {
            // File reader variables.
            FileReader fr = new FileReader(fileName); 
            BufferedReader br = new BufferedReader(fr);
            s = br.readLine();
            if(s != null)
            {
                sc = new Scanner(s);
                if(sc.hasNextInt())
                    row = sc.nextInt();
                else
                    System.out.println("Invalid imput File");
                if(sc.hasNextInt())
                    col = sc.nextInt();
                else
                    System.out.println("Invalid imput File");
            }

            result = new String[row][col];
            s = br.readLine();

            while(s != null)
            {
                // Running inverted loop to store the initial board state as required.
                for(int i = result.length - 1; i >= 0 ; i--) 
                {
                    sc = new Scanner(s);
                    for(int j = result[i].length - 1; j >= 0 ; j--)
                    {
                        if(sc.hasNext())
                        {
                            result[i][j] = sc.next();
                        }
                    }
                    s = br.readLine();
                }
            }
            // Closing to fix the leakages. 
            br.close();
            sc.close();
        }catch(Exception e) // to catch any type of exception and print it to the console.
        {
            System.out.println(e.toString());
        }
        return result;
    }

    // This method is used to load the pieces from the 2D array to the target Board.
    private static void loadPiecesFromString(Board targetBoard, String[][] boardCodes)
    {
        for(int i = 0; i < boardCodes.length; i++)
        {
            for(int j = 0; j < boardCodes[i].length; j++)
            {
                targetBoard.setPiece(i, j, loadChessPiece(targetBoard, boardCodes[i][j]));
            }
        }
    }

    /*Load Chess Pieces is used to determine what type of pieces should be placed
    at the given position by reading from the file. If it's E it will return null.
    Rest the first charecter will represent color and second will be the piece.*/
    private static ChessPiece loadChessPiece(Board targetBoard, String codeString)
    {
        if(codeString.charAt(0) == 'W' || codeString.charAt(0) == 'B')
        {
            String color = ""; // Determining color using the first character.\

            // Returning the ChessPieces the the respective locations and with exact color and types.
            if(codeString.charAt(0) == 'W')
                color = "WHITE";
            else    
                color = "BLACK";
            
            if(codeString.charAt(1) == 'P')
                return new Pawn(color, targetBoard);
            else if(codeString.charAt(1) == 'C')
                return new Castle(color, targetBoard);
            else if(codeString.charAt(1) == 'N')
                return new  Knight(color, targetBoard);
            else if(codeString.charAt(1) == 'B')
                return new Bishop(color, targetBoard);
            else if(codeString.charAt(1) == 'K')
                return new King(color, targetBoard);
            else if(codeString.charAt(1) == 'Q')
                return new Queen(color, targetBoard);
        }
        else if(codeString.charAt(0) == 'E') // Returning null when it's empty.
            return null;
        return null;
    }
}
