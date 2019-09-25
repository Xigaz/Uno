package bryce;

import java.util.ArrayList;

public class DiscardPile
{
    ArrayList<Card> pile = new ArrayList<>();
    Card currentCard;

    public void discardCard(Card d)
    {
        pile.add(d);
        currentCard = d;
    }

    public ArrayList<Card> reshuffle()
    {
        ArrayList<Card> returnValue = new ArrayList<>(pile);
        pile.clear();
        currentCard = null;
        return returnValue;
    }

    public Card getCurrentCard()
    {
        return currentCard;
    }
}
