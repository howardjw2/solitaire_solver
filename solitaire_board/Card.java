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
    public Card(int inValue, int inSuit)
    {
        value = inValue;
        suit = inSuit;
    }

    public int getValue()
        {return value;}
    
    public int getSuit()
        {return suit;}
    
    public String toString()
    {
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