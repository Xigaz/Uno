package bryce;

import java.util.ArrayList;

public class Player
{
    public enum PlayerType {HUMAN, AI};
    private String name;
    private ArrayList<Card> hand = new ArrayList<>();
    private PlayerType type;

    public Player(String n, PlayerType pt)
    {
        name = n;
        type = pt;
    }

    public String getName()
    {
        return name;
    }
    public PlayerType getType()
    {
        return type;
    }

    public void addCard(Card c)
    {
        hand.add(0,c);
    }

    public boolean hasWon()
    {
        return hand.size() == 0;
    }

    public boolean hasUno()
    {
        return hand.size() == 1;
    }

    public Colors getMostColor()
    {
        int[] count = new int[Colors.values().length];
        for(Card c : hand)
        {
            count[c.getColor().ordinal()]++;
        }
        count[Colors.WILD.ordinal()] = 0;
        int max = 0;
        Colors c = null;
        for(int i = 0; i < count.length;i++)
        {
            if (count[i] > max)
            {
                max = count[i];
                c = Colors.values()[i];
            }
        }
        return c;
    }

    public Card playCard(int a)
    {
        return hand.remove(a);
    }

    public int getHandSize()
    {
        return hand.size();
    }

    public String toString()
    {
        StringBuilder
                textHand = new StringBuilder(),
                top = new StringBuilder(),
                midTop = new StringBuilder(),
                midBot = new StringBuilder(),
                bot = new StringBuilder();

        textHand.append(Colors.WILD.getPrintColor());
        for(int i = 1; i <= hand.size() && i <= 10; i++)
            textHand.append(String.format("  %2d  ", i));
        textHand.append("\n");
        // for(int i = 1; i <= hand.size() && i <= 10; i++)
        //     textHand.append(String.format("----", i));
        // textHand.append("\n");
        for(int i = 1; i <= hand.size(); i++)
        {

            Card c = hand.get(i-1);
            String[] cs = c.toString().split("\n");
            top.append(cs[0]);
            midTop.append(cs[1]);
            midBot.append(cs[2]);
            bot.append(cs[3]);


            if(i % 10 == 0 && i != 0)
            {
                
                bot.append("\n");
                textHand.append(top
                    .append("\n")
                    .append(midTop.append("\n"))
                    .append(midBot.append("\n"))
                    .append(bot.append(Colors.WILD.getPrintColor()+"\n"))
                );
                top = new StringBuilder();
                midTop = new StringBuilder();
                midBot = new StringBuilder();
                bot = new StringBuilder();
                
                for(int j = 1 + i; j <= hand.size() && j % 10 < 10; j++)
                    textHand.append(String.format("  %2d  ", j));
                textHand.append("\n");
                // for(int j = 1 + i; j <= hand.size() && j % 10 < 10; j++)
                //     textHand.append(String.format("------", j));
                // textHand.append("\n");
            }    
        }
        textHand.append(top
                .append("\n")
                .append(midTop.append("\n"))
                .append(midBot.append("\n"))
                .append(bot.append("\n"))
        );

        textHand.append(Colors.WILD.getPrintColor() + "\n");

        return textHand.toString();
    }

}
