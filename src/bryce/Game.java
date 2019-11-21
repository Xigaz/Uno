package bryce;

import java.util.ArrayList;

public class Game
{
    private ArrayList<Player> players = new ArrayList<>();
    DiscardPile dp = new DiscardPile();
    Deck myDeck = new Deck(dp);


    public Game(Player p)
    {
        players.add(p);
        players.add(new Player("Frodo"));
        players.add(new Player("Sam"));
        players.add(new Player("Merry"));
        players.add(new Player("Pippin"));

        for(int i = 0; i < 12; i++)
            for(Player pl : players)
                pl.addCard(myDeck.draw());

        dp.discardCard(myDeck.draw());
    }

    public void play()
    {
        for(Player currentPlayer : players)
        {
            System.out.println(currentPlayer);

        }
        
        

    }

}
