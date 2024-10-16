/**
 * This is the simplest object for this project. One object represents a card.
 * This will be initialized 52 times total.
 * Used in all other object classes.
 * 
 * initialized with value and suit
 * 
 * VALUES (int)
 *      1-13
 * 
 * SUITS (int)
 *      DIAMONDS == 1
 *      CLUBS == 2
 *      HEARTS == 3
 *      SPADES == 4
 */

public class Card
{
    private int value;
    private int suit;
    private boolean exists;  //this is turned to be false if the card is slated to be removed from deck.
    private boolean isKnown; //this is the value of whether the card has been uncovered by the player.

    public Card(int inValue, int inSuit)
    {
        value = inValue;
        suit = inSuit;
        exists = true;
        isKnown = true;
    }

    // This method is called on the exposed card of a stack.
    // If the param card can legally be added to stack, return true.
    public boolean canBuildDownTo(Card inCard)
    {
        if(suit % 2 == inCard.getSuit() % 2)
            return false;
        if(value != inCard.getValue()+1)
            return false;
        return true;
    }

    // This method is called on the exposed card of an ace stack.
    // If the param card can legally be added to ace stack, return true.
    public boolean canBuildUpTo(Card inCard)
    {
        if(suit != inCard.getSuit())
            return false;
        if(value != inCard.getValue()-1)
            return false;
        return true;
    }

    // slate this card to be removed from the deck when the batchIndex variable of Deck.java loops back
    public void destroy()
    {
        exists = false;
    }

    // triggered when a hidden card is uncovered
    public void reveal()
    {
        isKnown = true;
    }

    // used at the initialization of the board to cover the hidden cards
    public void hide()
    {
        isKnown = false;
    }

    public boolean exists()
        {return exists;}

    public int getValue()
        {return value;}
    
    public int getSuit()
        {return suit;}

    public boolean isKnown()
        {return isKnown;}

    public String toString()
    {
        if(!isKnown)
            return "||||||||||||||||";
        String str = "(" + value + " of ";
        if(suit == 1)      {str += "diamonds)";}
        else if(suit == 2) {str += "clubs)   ";}
        else if(suit == 3) {str += "hearts)  ";}
        else if(suit == 4) {str += "spades)  ";}
        else {str += "ERROR";}
        if(value < 10)
            {str += " ";}
        return str;
    } //EXAMPLES: "(11 of diamonds)"
      //          "(0 of clubs)    "
      //          "(13 of clubs)   "

}