import java.util.ArrayList;

/**
 * This object will contain the remaining deck as well as the whole game state
 * 
 * CONTAINS:
 *      ace stacks
 *      card stacks
 *      instance of deck object (used to populate the card piles)
 * 
 * FUNCTIONALITY:
 *      move card from stack to stack
 *      move card from stack to ace-stack
 *      move card from ace-stack to stack
 *      (make sure to add hidden-card functionality)
 * 
 */

public class Board
{
    private Deck deck;
    private ArrayList<ArrayList<Card>> stacks;
    private ArrayList<ArrayList<Card>> aceStacks;

    public Board()
    {
        deck = new Deck();
        stacks = new ArrayList<ArrayList<Card>>();
        aceStacks = new ArrayList<ArrayList<Card>>();
        for(int i = 0; i < 7; i++) //initialize stacks
        {
            stacks.add(new ArrayList<Card>());
        }
        for(int i = 0; i < 7; i++) //completely populates the board
        {
            for(int ii = 0; ii < i+1; ii++)
            {
                stacks.get(i).add(deck.pop());
            }
        }
        for(int i = 0; i < 4; i++) //initializes empty ace stacks
        {
            aceStacks.add(new ArrayList<Card>());
        }
        for(int i = 0; i < 4; i++) //adds 0-value cards to ace stacks for ease of programming
        {
            aceStacks.get(i).add(new Card(0, i+1));
        }
    }

    public String toString()
    {
        String str = "";
        str += "\n";

        for(int i = 0; i < 4; i++)
        {
            if(i == 0)
                str += "Diamonds = ";
            else if(i == 1)
                str += "Clubs    = ";
            else if(i == 2)
                str += "Hearts   = ";
            else if(i == 3)
                str += "Spades   = ";
            for(int ii = 0; ii < aceStacks.get(i).size(); ii++)
            {
                str += aceStacks.get(i).get(ii) + " ";
            }
            str += "\n";
        }

        str += "\n\n";
        for(int i = 0; i < stacks.size(); i++)
        {
            str += "Stack: " + (i+1) + " = ";
            for(int ii = 0; ii < stacks.get(i).size(); ii++)
            {
                str += stacks.get(i).get(ii) + " ";
            }
            str += "\n";
        }
        return str;
    }
}