package bryce;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> deck = new ArrayList<>();
    private DiscardPile pile;

    public Deck(DiscardPile dp)
    {
        pile = dp;
        //Create Cards for all 76 colored numbers
        for(int i = 1; i <= 9; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                deck.add(new Card(String.valueOf(i), Colors.BLUE, Actions.NUMBER));
                deck.add(new Card(String.valueOf(i), Colors.RED, Actions.NUMBER));
                deck.add(new Card(String.valueOf(i), Colors.GREEN, Actions.NUMBER));
                deck.add(new Card(String.valueOf(i), Colors.YELLOW, Actions.NUMBER));
            }
        }
        deck.add(new Card("0", Colors.BLUE, Actions.NUMBER));
        deck.add(new Card("0", Colors.RED, Actions.NUMBER));
        deck.add(new Card("0", Colors.GREEN, Actions.NUMBER));
        deck.add(new Card("0", Colors.YELLOW, Actions.NUMBER));

        //Create Cards for all 8 Draw 2 ActionCards
        for(int j = 0; j < 2; j++)
        {
            deck.add(new Card("+2", Colors.BLUE, Actions.DRAW2));
            deck.add(new Card("+2", Colors.RED, Actions.DRAW2));
            deck.add(new Card("+2", Colors.GREEN, Actions.DRAW2));
            deck.add(new Card("+2", Colors.YELLOW, Actions.DRAW2));
        }

        //Create Cards for all 8 Reverse ActionCards
        for(int j = 0; j < 2; j++)
        {
            deck.add(new Card("R", Colors.BLUE, Actions.REVERSE));
            deck.add(new Card("R", Colors.RED, Actions.REVERSE));
            deck.add(new Card("R", Colors.GREEN, Actions.REVERSE));
            deck.add(new Card("R", Colors.YELLOW, Actions.REVERSE));
        }

        //Create Cards for all 8 Skip ActionCards
        for(int j = 0; j < 2; j++)
        {
//            deck.add(new Card(String.valueOf('\u20E0'), Colors.BLUE, Actions.SKIP));
//            deck.add(new Card(String.valueOf('\u20E0'), Colors.RED, Actions.SKIP));
//            deck.add(new Card(String.valueOf('\u20E0'), Colors.GREEN, Actions.SKIP));
//            deck.add(new Card(String.valueOf('\u20E0'), Colors.YELLOW, Actions.SKIP));
            deck.add(new Card("S", Colors.BLUE, Actions.SKIP));
            deck.add(new Card("S", Colors.RED, Actions.SKIP));
            deck.add(new Card("S", Colors.GREEN, Actions.SKIP));
            deck.add(new Card("S", Colors.YELLOW, Actions.SKIP));
        }


        //Create Cards for all 4 WildCards
        for(int j = 0; j < 4; j++)
        {
            deck.add(new Card("W", Colors.WILD, Actions.WILD));
        }

        //Create Cards for all 4 Draw 4 WildCards
        for(int j = 0; j < 4; j++)
        {
            deck.add(new Card("+4", Colors.WILD, Actions.WILD4));
        }
        for(int i = 0; i < 7; i++)
            Collections.shuffle(deck);
    }

    public Card draw()
    {
        if(deck.size() == 0)
            reshuffle();

        return deck.remove(0);
    }

    private void reshuffle()
    {
        deck = pile.reshuffle();
        for(int i = 0; i < 7; i++)
            Collections.shuffle(deck);
    }

    public void putCardBack(Card c)
    {
        deck.add(c);
    }

}
