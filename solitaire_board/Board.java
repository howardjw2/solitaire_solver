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
    }

    /**
     * takes as input the position (0-6) of the stack we want to move the card from
     *      and the position (0-6) of the stack we want to move the card to
     * 
     * returns a boolean of whether the action went through or if it was impossible
     */
    public boolean moveStackToStack(int source, int target)
    {
        ArrayList<Card> stack1 = stacks.get(source);
        ArrayList<Card> stack2 = stacks.get(target);
        if(stack1.size()==0) //if moving card cannot exist, stop
            return false;
        Card card1 = stack1.get(stack1.size()-1);
        if(stack2.size()==0) //if empty space, only king can go here
        {
            if(card1.getValue() != 13)
            {
                return false;
            }
            else
            {
                stack2.add(card1);
                stack1.remove(stack1.size()-1);
                return true;
            }
        }
        Card card2 = stack2.get(stack2.size()-1);
        if(card2.canBuildDownTo(card1))
        {
            stack2.add(card1);
            stack1.remove(stack1.size()-1);
            return true;
        }
        return false;
    }

    /**
     * takes as input the position (0-6) of the stack we want to move the card from
     *      (the ace stack is automatically chosen based on the exposed card's suit)
     * 
     * returns a boolean of whether the action went through or if it was impossible
     */
    public boolean moveStackToAceStack(int source) //move a card from stack to the appropriate ace stack
    {
        ArrayList<Card> stack = stacks.get(source);
        if(stack.size()==0)
            return false;
        Card card1 = stack.get(stack.size()-1);
        ArrayList<Card> aceStack = aceStacks.get(card1.getSuit()-1);
        if(aceStack.size() == 0)
        {
            if(card1.getValue() == 1)
            {
                aceStack.add(card1);
                stack.remove(stack.size()-1);
                return true;
            }
            else
            {
                return false;
            }
        }
        Card card2 = aceStack.get(aceStack.size()-1);
        if(card2.canBuildUpTo(card1))
        {
            aceStack.add(card1);
            stack.remove(stack.size()-1);
            return true;
        }
        return false;
    }

    /**
     * takes as input the position (0-3) of the ace stack we want to move the card from
     *      and the position (0-6) of the stack we want to move the card to
     * 
     * returns a boolean of whether the action went through or if it was impossible
     */
    public boolean moveAceStackToStack(int source, int target)
    {
        ArrayList<Card> aceStack = aceStacks.get(source);
        ArrayList<Card> stack = stacks.get(target);
        if(aceStack.size() == 0)
        {
            return false;
        }
        Card card1 = aceStack.get(aceStack.size()-1);
        if(stack.size() == 0)
        {
            if(card1.getValue() == 13)
            {
                stack.add(card1);
                aceStack.remove(aceStack.size()-1);
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    public boolean moveBatchToStack(int target)
    {
        if(deck.getBatch().size() == 0)
            return false;

        Card card1 = deck.getBatchCard();
        ArrayList<Card> stack = stacks.get(target);
        if(stack.size() == 0)
        {
            if(card1.getValue() == 13)
            {
                stack.add(card1);
                this.getDeck().shaveBatch();
            }
            return false;
        }

        Card card2 = stack.get(stack.size()-1);
        if(card2.canBuildDownTo(card1))
        {
            stack.add(card1);
            this.getDeck().shaveBatch();
        }
        return false;
    }

    public boolean moveBatchToAceStack()
    {
        if(deck.getBatch().size() == 0)
            return false;

        Card card1 = deck.getBatchCard();
        ArrayList<Card> aceStack = aceStacks.get(card1.getSuit()-1);
        if(aceStack.size() == 0)
        {
            if(card1.getValue() == 1)
            {
                aceStack.add(card1);
                this.getDeck().shaveBatch();
            }
            return false;
        }

        Card card2 = aceStack.get(aceStack.size()-1);
        if(card2.canBuildUpTo(card1))
        {
            aceStack.add(card1);
            this.getDeck().shaveBatch();
        }
        return false;
    }

    public Deck getDeck()
    {
        return deck;
    }

    public String toString()
    {
        String str = "";
        ArrayList<Card> batch = deck.getBatch();
        str += "\n";
        for(int i = 0; i < batch.size(); i++)
        {
            str += batch.get(i);
            str += " ";
        }

        str += "\n\n";
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