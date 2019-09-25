package bryce;

public class Main
{

    public static void main(String[] args)
    {
        DiscardPile dp = new DiscardPile();
        Deck myDeck = new Deck(dp);
        Player me = new Player();
        for(int i = 0; i < 20; i++)
            me.addCard(myDeck.draw());
        dp.discardCard(myDeck.draw());
        System.out.println(me);
        System.out.println(dp);
    }
}
