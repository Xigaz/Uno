package bryce;

import java.util.ArrayList;

public class Player
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

    private String name;
    private ArrayList<Card> hand = new ArrayList<>();

    public void addCard(Card c)
    {
        hand.add(c);
    }

    public String toString()
    {
        StringBuilder textHand = new StringBuilder();

        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getColor() == Colors.BLUE)
                textHand.append(ANSI_BLUE);
            else if(hand.get(i).getColor() == Colors.RED)
                textHand.append(ANSI_RED);
            else if(hand.get(i).getColor() == Colors.GREEN)
                textHand.append(ANSI_GREEN);
            else if(hand.get(i).getColor() == Colors.YELLOW)
                textHand.append(ANSI_YELLOW);
            else if(hand.get(i).getColor() == Colors.WILD)
                textHand.append(ANSI_BLACK);
            textHand.append("╔════╗");
        }
        textHand.append("\n");
//        for(int i = 0; i < hand.size(); i++)
//        {
//            if(hand.get(i).getColor() == Colors.BLUE)
//                textHand.append(ANSI_BLUE);
//            else if(hand.get(i).getColor() == Colors.RED)
//                textHand.append(ANSI_RED);
//            else if(hand.get(i).getColor() == Colors.GREEN)
//                textHand.append(ANSI_GREEN);
//            else if(hand.get(i).getColor() == Colors.YELLOW)
//                textHand.append(ANSI_YELLOW);
//            else if(hand.get(i).getColor() == Colors.WILD)
//                textHand.append(ANSI_BLACK);
//            textHand.append("║    ║");
//        }
//        textHand.append("\n");
        for(Card c : hand)
        {
            if(c.getColor() == Colors.BLUE)
                textHand.append(ANSI_BLUE);
            else if(c.getColor() == Colors.RED)
                textHand.append(ANSI_RED);
            else if(c.getColor() == Colors.GREEN)
                textHand.append(ANSI_GREEN);
            else if(c.getColor() == Colors.YELLOW)
                textHand.append(ANSI_YELLOW);
            else if(c.getColor() == Colors.WILD)
                textHand.append(ANSI_BLACK);
            textHand.append("║ ").append(String.format("%2s", c.getDisplayValue())).append(" ║");
        }
        textHand.append("\n");
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getColor() == Colors.BLUE)
                textHand.append(ANSI_BLUE);
            else if(hand.get(i).getColor() == Colors.RED)
                textHand.append(ANSI_RED);
            else if(hand.get(i).getColor() == Colors.GREEN)
                textHand.append(ANSI_GREEN);
            else if(hand.get(i).getColor() == Colors.YELLOW)
                textHand.append(ANSI_YELLOW);
            else if(hand.get(i).getColor() == Colors.WILD)
                textHand.append(ANSI_BLACK);
            textHand.append("║    ║");
        }
        textHand.append("\n");
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getColor() == Colors.BLUE)
                textHand.append(ANSI_BLUE);
            else if(hand.get(i).getColor() == Colors.RED)
                textHand.append(ANSI_RED);
            else if(hand.get(i).getColor() == Colors.GREEN)
                textHand.append(ANSI_GREEN);
            else if(hand.get(i).getColor() == Colors.YELLOW)
                textHand.append(ANSI_YELLOW);
            else if(hand.get(i).getColor() == Colors.WILD)
                textHand.append(ANSI_BLACK);
            textHand.append("╚════╝");
        }

        return textHand.toString();
    }

}
