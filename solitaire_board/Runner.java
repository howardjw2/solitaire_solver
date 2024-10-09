import java.util.Scanner;

/**
 * This will be a simple testing class.
 */

public class Runner
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Card testCard = new Card(1, 1);
        Deck testDeck = new Deck();
        Board testBoard = new Board();
        Game testGame = new Game();
        //System.out.println(testCard);
        //System.out.println(testDeck);
        String input1;
        String input2;
        System.out.println(testBoard);
        while(true)
        {
            System.out.println("MOVING STACK TO STACK:");
            input1 = sc.nextLine();
            if(input1.equals("end"))
            {
                break;
            }
            input2 = sc.nextLine();
            if(input2.equals("end"))
            {
                break;
            }

            testBoard.move(Integer.valueOf(input1), Integer.valueOf(input2));
            System.out.println(testBoard);
        }

        while(true)
        {
            System.out.println("MOVING STACK TO ACE STACK:");
            input1 = sc.nextLine();
            if(input1.equals("end"))
            {
                break;
            }

            testBoard.elevate(Integer.valueOf(input1));
            System.out.println(testBoard);
        }
        
        while(true)
        {
            System.out.println("MOVING ACE STACK TO STACK:");
            input1 = sc.nextLine();
            if(input1.equals("end"))
            {
                break;
            }
            input2 = sc.nextLine();
            if(input2.equals("end"))
            {
                break;
            }

            testBoard.moveFromAceStack(Integer.valueOf(input1), Integer.valueOf(input2));
            System.out.println(testBoard);
        }
    }
}