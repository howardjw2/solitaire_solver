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
    private ArrayList<Card> batch; //this contains the ~3 cards from the deck that are shown to the player at a time
    private int batchIndex; //this variable starts at position 0 and iterates through the deck 3 cards at a time
    private int batchCardIndex; //this variable keeps track of the position of the batch's exposed card

    public Deck()
    {
        batchIndex = 0;
        batchCardIndex = 2;
        cards = new ArrayList<Card>();
        for(int i = 1; i < 14; i++)
        {
            for(int ii = 1; ii < 5; ii++)
            {
                cards.add(new Card(i, ii));
            }
        }
        this.shuffle();
        batch = new ArrayList<Card>(); //batch is the triplet of cards that can be seen by the player
                             //where only the last of the three cards is accessible.
        batch.add(cards.get(0));
        batch.add(cards.get(1));
        batch.add(cards.get(2));
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
            batchCardIndex = 0;
            for(int i = 0; i < cards.size(); i++)
            {
                if(!cards.get(i).exists())
                {
                    cards.remove(i);
                    i--;
                }
            }
        }
        else
        {
            batchIndex += 3;
            batchCardIndex = batchIndex;
        }

        batch = new ArrayList<Card>();
        if(batchIndex >= cards.size())
        {
            return;
        }
        if(cards.size() > (0 + batchIndex))
        {
            batch.add(cards.get(0 + batchIndex));
            batchCardIndex++;
            if(cards.size() > (1 + batchIndex))
            {
                batch.add(cards.get(1 + batchIndex));
                batchCardIndex++;
                if(cards.size() > (2 + batchIndex))
                {
                    batch.add(cards.get(2 + batchIndex));
                    batchCardIndex++;
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

    //this method is called when the exposed batch card is removed
    public void shaveBatch()
    {
        if(batch.size() == 0)
        {
            System.out.println("EMPTY BATCH ERROR");
            return;
        }
        batch.remove(batch.size()-1);
        //System.out.println("REMOVED " + cards.get(batchCardIndex));
        cards.get(batchCardIndex).destroy();
        batchCardIndex--;
        if(batch.size() == 0)
        {
            if(batchCardIndex < 0)
                return;
            batch.add(cards.get(batchCardIndex));
        }
    }

    public ArrayList<Card> getBatch()
    {
        return batch;
    }

    public Card getBatchCard()
    {
        if(batch.size() == 0)
            return null;
        if(batch.size() == 1)
            return batch.get(0);
        if(batch.size() == 2)
            return batch.get(1);
        if(batch.size() == 3)
            return batch.get(2);
        System.out.println("IMPROPER BATCH SIZE");
        return null;
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