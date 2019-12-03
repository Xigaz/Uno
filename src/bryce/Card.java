package bryce;

public class Card
{
    private String displayValue;
    private Colors color;
    private Actions action;

    public Card(String dV, Colors c, Actions a)
    {
        displayValue = dV;
        color = c;
        action = a;
    }

    public String getDisplayValue()
    {
        return displayValue;
    }

    public Colors getColor()
    {
        return color;
    }

    public Actions getAction()
    {
        return action;
    }

    public boolean canPlay(Card c)
    {
        return canPlay(c, Colors.WILD);
    }

    public boolean canPlay(Card c, Colors co)
    {
        return c.action == Actions.WILD || c.action == Actions.WILD4 || c.color == color || c.displayValue.equals(displayValue) 
            || (action == Actions.WILD && c.color == co ) || (action == Actions.WILD4 && c.color == co );
    }

    @Override
    public String toString()
    {
        StringBuilder textCard = new StringBuilder();
        String printColor = color.getPrintColor();

        textCard.append(printColor);
        textCard.append("╔════╗\n");

        textCard.append(printColor);
        textCard.append("║ ").append(String.format("%2s", displayValue)).append(" ║\n");

        textCard.append(printColor);
        textCard.append("║    ║\n");

        textCard.append(printColor);
        textCard.append("╚════╝");

        return textCard.toString();
    }
}
