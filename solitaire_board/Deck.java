import java.util.ArrayList;

/**
 * This object will initialize with 52 cards inside.
 * It is used like a stack, but due to the peculiarities of solitaire, I'll just use an ArrayList
 * It will be used by Board.java
 * 
 * FUNCTIONALITY:
 *      initialize with 52 cards
 *      shuffle cards
 *      ability to iterate through the deck, 3 cards at a time
 *          only the topmost of the 3 cards can be popped out of the ArrayList
 */

public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();
        for(int i = 1; i < 14; i++)
        {
            for(int ii = 1; ii < 5; ii++)
            {
                cards.add(new Card(i, ii));
            }
        }
    }

    public Card pop()
    {
        Card a = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return a;
    }

    public String toString()
    {
        String str = "";
        for(int i = 0; i < cards.size(); i++)
        {
            str += (cards.get(i)) + "\n";
        }
        return str;
    }
}