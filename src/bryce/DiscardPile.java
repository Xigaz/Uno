package bryce;

import java.util.ArrayList;

public class DiscardPile
{
    // Bold Text
    private final String ANSI_RESET = "\u001B[1;0m";
    private final String ANSI_BLACK = "\u001B[1;30m";
    private final String ANSI_RED = "\u001B[1;31m";
    private final String ANSI_GREEN = "\u001B[1;32m";
    private final String ANSI_YELLOW = "\u001B[1;33m";
    private final String ANSI_BLUE = "\u001B[1;34m";

    // Bold High Intensity
    private final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    private final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    private final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    private final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    private final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE

    // High Intensity backgrounds
    private final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    private final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    private final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    private final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    private final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
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
        pile.clear();
        currentCard = null;
        return returnValue;
    }

    public Card getCurrentCard()
    {
        return currentCard;
    }

    public String toString()
    {
        StringBuilder textHand = new StringBuilder();
        cardColor(textHand);
        textHand.append("╔════╗");
        textHand.append("\n");
        cardColor(textHand);
        textHand.append("║ ").append(String.format("%2s", currentCard.getDisplayValue())).append(" ║");
        textHand.append("\n");
        cardColor(textHand);
        textHand.append("║    ║");
        textHand.append("\n");
        cardColor(textHand);
        textHand.append("╚════╝");
        return textHand.toString();
    }

    private void cardColor(StringBuilder textHand)
    {
        if(currentCard.getColor() == Colors.BLUE)
            textHand.append(ANSI_BLUE);
        else if(currentCard.getColor() == Colors.RED)
            textHand.append(ANSI_RED);
        else if(currentCard.getColor() == Colors.GREEN)
            textHand.append(ANSI_GREEN);
        else if(currentCard.getColor() == Colors.YELLOW)
            textHand.append(ANSI_YELLOW);
        else if(currentCard.getColor() == Colors.WILD)
            textHand.append(ANSI_BLACK);
    }

}
