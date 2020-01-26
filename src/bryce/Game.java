package bryce;

import java.util.ArrayList;
import java.util.Scanner;

import bryce.Player.PlayerType;

public class Game
{
    private ArrayList<Player> players = new ArrayList<>();
    private DiscardPile dp = new DiscardPile();
    private Deck myDeck = new Deck(dp);
    // Player currentPlayer;
    private boolean isReverse = false;
    private boolean playedWild = false;

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
        Card c = myDeck.draw(); 
        while(c.getAction() != Actions.NUMBER)
        {
            myDeck.putCardBack(c);
            c = myDeck.draw();
        }
        dp.discardCard(c);
        // currentPlayer = players.get(0);
    }

    public void play()
    {
        Player currentPlayer = players.get(0);
        boolean cardDone = false;

        for(int i = 0; !currentPlayer.hasWon(); )
        {

            currentPlayer = players.get(i);
            playedWild = false;
            // if(currentPlayer.getType() == PlayerType.HUMAN)
            //     System.out.println("\033[H\033[2J");
            System.out.println(Colors.WILD.getPrintColor());
            System.out.printf("%s it's your turn:", currentPlayer.getName());
            System.out.println(Colors.WILD.getPrintColor());
            System.out.println();
            System.out.println(dp.getCurrentCard());
                        
            Actions a = dp.getCurrentCard().getAction();
            if (cardDone)
            {
                a = Actions.NUMBER;
                cardDone = false;
            }

            switch(a)
            {
                case WILD4:
                    currentPlayer.addCard(myDeck.draw());
                    currentPlayer.addCard(myDeck.draw());
                case DRAW2:
                    currentPlayer.addCard(myDeck.draw());
                    currentPlayer.addCard(myDeck.draw());
                case SKIP:
                    cardDone = true;
                    break;
                case REVERSE:
                    cardDone = true;
                case NUMBER:
                    if(dp.getWildColor() != Colors.WILD)
                    {
                        System.out.printf("\n%sWild Color is %s\n", dp.getWildColor().getPrintColor(), dp.getWildColor());
                    }
                    
                    if(currentPlayer.getType() == PlayerType.HUMAN)
                        System.out.println(currentPlayer);
                    doPlayerAction(currentPlayer);
                    break;
                case WILD:
                    if(dp.getWildColor() != Colors.WILD)
                    {
                        System.out.printf("\n%sWild Color is %s\n", dp.getWildColor().getPrintColor(), dp.getWildColor());
                    }
                    
                    if(currentPlayer.getType() == PlayerType.HUMAN)
                        System.out.println(currentPlayer);
                    doPlayerAction(currentPlayer);
                    
                    break;
            }
            if (!cardDone || playedWild)
                switch(dp.getCurrentCard().getAction())
                {
                    case REVERSE:
                        isReverse = !isReverse;
                        break;
                    case WILD:
                    case WILD4:
                        if(currentPlayer.getType() == PlayerType.HUMAN)
                        {
                            Scanner input = new Scanner(System.in);
                            System.out.println("Choose a color: ");
                            for(int j = 0; j < Colors.values().length-1;j++)
                            {
                                Colors c = Colors.values()[j];
                                System.out.printf("%d) %s\n", j, c);
                            }
                            dp.setWildColor(Colors.values()[input.nextInt()]);
                        }
                        else
                            dp.setWildColor(currentPlayer.getMostColor());
                        break;
                    default: 
                }

            if (currentPlayer.hasUno())
                System.out.println("\n\nUNO!!\n\n");
            
            if(isReverse)
            {
                i--;
                i = i < 0 ? players.size() + i : i;
            }
            else
            {    
                i++;
                i = i >= players.size() ? 0 : i;
            }
        }
        System.out.printf("Oooo!! %s just won!!\n\n", currentPlayer.getName());
            
    }

    private void doPlayerAction(Player currentPlayer)
    {
        if(currentPlayer.getType() == PlayerType.HUMAN)
        {
            int a = -1;
            while(a == -1 || !(a <= currentPlayer.getHandSize() && a > 0) )
            {
                Scanner input = null;
                try{
                    input = new Scanner(System.in);
                    System.out.print("\n0) Draw\nCard Number) Play Card\n> ");
                    a = input.nextInt();
                    System.out.println();
                    if(a > 0 && a <= currentPlayer.getHandSize())
                    {
                            
                            Card c = currentPlayer.playCard(a-1);
                            if(!dp.discardCard(c))
                            {
                                currentPlayer.addCard(c);
                                a = -1;
                                continue;
                            }
                            else
                            {    
                                if (dp.getCurrentCard().getAction() == Actions.WILD || dp.getCurrentCard().getAction() == Actions.WILD4)
                                    playedWild = true;
                                return;
                            }
                    }
                    else if (a == 0)
                    {
                        currentPlayer.addCard(myDeck.draw());
                        return;
                    }
                    else
                            continue;
                }
                catch(NumberFormatException e)
                {
                    continue;
                }
            }
        }
        else
        {
            boolean played = false;
            for(int i = 0; !played && i < currentPlayer.getHandSize(); i++)
            {                
                Card c = currentPlayer.playCard(i);
                
                if(!dp.discardCard(c))
                {
                    currentPlayer.addCard(c);
                }
                else
                {
                    played = true;
                    if (dp.getCurrentCard().getAction() == Actions.WILD || dp.getCurrentCard().getAction() == Actions.WILD4)
                        playedWild = true;
                }
            }
            if (!played)
                currentPlayer.addCard(myDeck.draw());
        }
        
    }

}
