/**
 * This will be a simple testing class.
 */

public class Runner
{
    public static void main(String[] args)
    {
        Card testCard = new Card(1, 1);
        Deck testDeck = new Deck();
        Board testBoard = new Board();
        Game testGame = new Game();
        //System.out.println(testCard);
        //System.out.println(testDeck);
        System.out.println(testBoard);
        
        System.out.println(new Card(1, 1).canBuildUpTo(new Card(2, 1)));
        System.out.println(new Card(1, 1).canBuildUpTo(new Card(2, 2)));
        System.out.println(new Card(1, 1).canBuildUpTo(new Card(1, 1)));
        System.out.println(new Card(1, 1).canBuildUpTo(new Card(1, 2)));

        System.out.println(new Card(2, 1).canBuildDownTo(new Card(2, 1)));
        System.out.println(new Card(2, 1).canBuildDownTo(new Card(2, 2)));
        System.out.println(new Card(2, 1).canBuildDownTo(new Card(1, 1)));
        System.out.println(new Card(2, 1).canBuildDownTo(new Card(1, 2)));
    }
}