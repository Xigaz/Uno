package bryce;

import java.util.ArrayList;

public class DiscardPile
{
    private ArrayList<Card> pile = new ArrayList<>();
    private Card currentCard;

    public void discardCard(Card d)
    {
        pile.add(d);
        currentCard = d;
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
