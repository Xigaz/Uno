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
        return c.action == Actions.WILD || c.action == Actions.WILD4 || c.color == color || c.displayValue.equals(displayValue);
    }
}
