package bryce;

import java.util.ArrayList;

public class DiscardPile
{
    private ArrayList<Card> pile = new ArrayList<>();
    private Card currentCard;
    private Colors wildColor = Colors.WILD;

    public boolean discardCard(Card d)
    {
        if(currentCard == null || currentCard.canPlay(d, wildColor))
        {
            pile.add(d);
            currentCard = d;
            wildColor = Colors.WILD;
            return true;
        }
        else
            return false;
    }

    public void setWildColor(Colors c)
    {
        wildColor = c;
    }

    public Colors getWildColor()
    {
        return wildColor;
    }

    public ArrayList<Card> reshuffle()
    {
        ArrayList<Card> returnValue = new ArrayList<>(pile);
        currentCard = returnValue.remove(returnValue.size()-1);
        pile.clear();
        return returnValue;
    }

    public Card getCurrentCard()
    {
        return currentCard;
    }

    public String toString()
    {
        StringBuilder textHand = new StringBuilder();
        textHand.append(currentCard.getColor().getPrintColor());
        textHand.append("╔════╗\n");
        textHand.append("║ ").append(String.format("%2s", currentCard.getDisplayValue())).append(" ║\n");
        textHand.append("║    ║\n");
        textHand.append("╚════╝\n");
        textHand.append(Colors.WILD.getPrintColor());
        return textHand.toString();
    }
}
