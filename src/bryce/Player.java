package bryce;

import java.util.ArrayList;

public class Player
{

    private String name;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String n)
    {
        name = n;
    }

    public void addCard(Card c)
    {
        hand.add(c);
    }

    public String toString()
    {
        StringBuilder
                textHand = new StringBuilder(),
                top = new StringBuilder(),
                midTop = new StringBuilder(),
                midBot = new StringBuilder(),
                bot = new StringBuilder();

        for(Card c : hand)
        {
            String[] cs = c.toString().split("\n");
            top.append(cs[0]);
            midTop.append(cs[1]);
            midBot.append(cs[2]);
            bot.append(cs[3]);
        }
        textHand.append(top
                .append("\n")
                .append(midTop.append("\n"))
                .append(midBot.append("\n"))
                .append(bot.append("\n"))
        );

        textHand.append("\n");

        return textHand.toString();
    }

}
