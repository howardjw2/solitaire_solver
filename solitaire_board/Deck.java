import java.util.ArrayList;

/**
 * This object will initialize with 52 cards inside.
 * It is used like a stack, but due to the peculiarities of solitaire, I'll just use an ArrayList
 * It will be used by Board.java
 * 
 * FUNCTIONALITY:
 *      initialize with 52 cards
 *      shuffle cards
 *      ability to iterate through the deck, 3 cards at a time (this is the "batch" variable)
 *          only the topmost of the 3 cards can be popped out of the ArrayList
 */

public class Deck
{
    private ArrayList<Card> cards;
    private Card[] batch;
    private int batchIndex;

    public Deck()
    {
        batchIndex = 0;
        cards = new ArrayList<Card>();
        for(int i = 1; i < 14; i++)
        {
            for(int ii = 1; ii < 5; ii++)
            {
                cards.add(new Card(i, ii));
            }
        }
        this.shuffle();
        batch = new Card[3]; //batch is the triplet of cards that can be seen by the player
                             //where only the last of the three cards is accessible.
        batch[0] = cards.get(0);
        batch[1] = cards.get(1);
        batch[2] = cards.get(2);
    }

    /**
     * iterates through the deck one batch at a time
     * at end of deck, batch will only contain numCards % 3 cards.
     * when batch reaches end of deck, next turn() will restart to beginning of deck.
     */
    public void turn()
    {
        if(batchIndex >= cards.size())
        {
            batchIndex = 0;
        }
        else
        {
            batchIndex += 3;
        }

        batch = new Card[3];
        if(batchIndex >= cards.size())
        {
            return;
        }
        if(cards.size() > (0 + batchIndex))
        {
            batch[0] = cards.get(0 + batchIndex);
            if(cards.size() > (1 + batchIndex))
            {
                batch[1] = cards.get(1 + batchIndex);
                if(cards.size() > (2 + batchIndex))
                {
                    batch[2] = cards.get(2 + batchIndex);
                }
            }
        }
    }

    // remove and return the card at the end of the deck
    public Card pop()
    {
        Card a = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return a;
    }

    //randomizes the order of the "cards" variable
    public void shuffle()
    {
        for(int i = cards.size()-1; i > 0; i--)
        {
            int index = (int)(Math.random()*(i+1));
            Card a = cards.get(index);
            cards.remove(index);
            cards.add(a);
        }
    }

    public Card[] getBatch()
    {
        return batch;
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