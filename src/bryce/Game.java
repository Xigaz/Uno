package bryce;

import java.util.ArrayList;

import bryce.Player.PlayerType;

public class Game
{
    private ArrayList<Player> players = new ArrayList<>();
    DiscardPile dp = new DiscardPile();
    Deck myDeck = new Deck(dp);
    // Player currentPlayer;

    public Game(Player p)
    {
        players.add(p);
        players.add(new Player("Frodo", PlayerType.AI));
        players.add(new Player("Sam", PlayerType.AI));
        players.add(new Player("Merry", PlayerType.AI));
        players.add(new Player("Pippin", PlayerType.AI));

        for(int i = 0; i < 12; i++)
            for(Player pl : players)
                pl.addCard(myDeck.draw());

        dp.discardCard(myDeck.draw());
        // currentPlayer = players.get(0);
    }

    public void play()
    {
        
        for(Player currentPlayer : players)
        {
            int 
            if(currentPlayer.getType() == PlayerType.HUMAN)
            {
                getPlayerAction();
            }
            else
            {
                
            }

            if(currentPlayer.hasWon())
            {
                System.out.printf("Oooo!! %s just won!!", currentPlayer.getName());
                break;
            }
        }
    }

    private 

}
