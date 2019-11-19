package bryce;

import java.util.ArrayList;
import java.util.Arrays;

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
    }

    public void play()
    {
        for(int i = 0; i < 20; i++)
            players.get(0).addCard(myDeck.draw());
        dp.discardCard(myDeck.draw());
        System.out.println(players.get(0));
        System.out.println(dp);

    }

}
