import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class BoardLoader 
{
    public static void loadBoardState(Board theBoard, String fileName)
    {
        loadPiecesFromString(theBoard, parseFile(fileName));
    }

    private static String[][] parseFile(String fileName)
    {
        String[][] result = null;
        String s = "";
        Scanner sc = null;
        int row = 0, col = 0;
        try
        {
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

            br.close();
            sc.close();
        }catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return result;
    }

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

    private static ChessPiece loadChessPiece(Board targetBoard, String codeString)
    {
        if(codeString.charAt(0) == 'W' || codeString.charAt(0) == 'B')
        {
            String color = "";
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
        return null;
    }
}
