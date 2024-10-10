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
        String input;
        //System.out.println(testBoard);

        //testBoard.getDeck().shaveBatch();

        //System.out.println(testBoard);

        while(true)
        {
            System.out.println(testBoard);
            System.out.println("WHAT ACTION? (end, turn, move, raise)");
            input = sc.nextLine();
            int position;
            int depth;
            try
            {
                if(input.equals("end"))
                    break;
                
                else if(input.equals("turn"))
                {
                    testBoard.getDeck().turn();
                }
                
                else if(input.equals("move"))
                {
                    System.out.println("Which section's exposed card should be moved?");
                    input = sc.nextLine();
                    if(input.equals("b"))
                    {
                        System.out.println("Which stack do you want to move this card to?");
                        input = sc.nextLine();
                        if(input.equals("d") || input.equals("c") || input.equals("h") || input.equals("s"))
                        {
                            testBoard.moveBatchToAceStack();
                        }
                        else
                        {
                            testBoard.moveBatchToStack(Integer.valueOf(input)-1);
                        }
                    }
                    else if(input.equals("d") || input.equals("c") || input.equals("h") || input.equals("s"))
                    {
                        if(input.equals("d"))
                            position = 0;
                        else if(input.equals("c"))
                            position = 1;
                        else if(input.equals("h"))
                            position = 2;
                        else if(input.equals("s"))
                            position = 3;
                        else
                        {
                            System.out.println("BAD INPUT");
                            break;
                        }
                        System.out.println("Which stack do you want to move this card to?");
                        input = sc.nextLine();

                        testBoard.moveAceStackToStack(position, Integer.valueOf(input)-1);
                    }

                    else
                    {
                        position = Integer.valueOf(input);

                        System.out.println("How many cards in this stack do you want to move?");
                        depth = Integer.valueOf(sc.nextLine());

                        System.out.println("Which stack do you want to move this card to?");
                        input = sc.nextLine();
                        testBoard.moveStackToStack(position-1, Integer.valueOf(input)-1, depth-1);
                    }
                    
                }

                else if(input.equals("raise"))
                {
                    System.out.println("Which section's exposed card should be raised to an ace stack?");
                    input = sc.nextLine();
                    if(input.equals("b"))
                    {
                        testBoard.moveBatchToAceStack();
                    }
                    else
                    {
                        testBoard.moveStackToAceStack(Integer.valueOf(input)-1);
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("BAD INPUT");
            }
            System.out.print("\n\n\n\n\n\n");
        }

        /*
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
        */
    }
}