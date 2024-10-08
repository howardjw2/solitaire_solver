import java.util.ArrayList;

/**
 * This object will contain the remaining deck as well as the whole game state
 * 
 * CONTAINS:
 *      ace piles
 *      card piles
 *      instance of deck object (used to populate the card piles)
 * 
 * FUNCTIONALITY:
 *      move card from pile to pile
 *      move card from pile to ace-pile
 *      move card from ace-pile to pile
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
        for(int i = 0; i < 7; i++)
        {
            stacks.add(new ArrayList<Card>());
        }
        for(int i = 0; i < 4; i++) //initializes ace piles with 0-value cards for ease of programming
        {
            aceStacks.add(new ArrayList<Card>());
        }
        for(int i = 0; i < 4; i++) //initializes ace piles with 0-value cards for ease of programming
        {
            aceStacks.get(i).add(new Card(0, i+1));
        }
    }
}