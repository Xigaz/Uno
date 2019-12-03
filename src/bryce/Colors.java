package bryce;


public enum Colors {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    WILD("Black");

    private final String printColor;
    private final String displayColor;

    private Colors(String c)
    {
        String ANSI_BLUE = "\u001B[1;34m";
        String ANSI_BLACK = "\u001B[1;30m";
        String ANSI_RED = "\u001B[1;31m";
        String ANSI_GREEN = "\u001B[1;32m";
        String ANSI_YELLOW = "\u001B[1;33m";
        displayColor = c;

        switch (c)
        {
            case "Red":
                printColor = ANSI_RED;
                break;
            case "Green":
                printColor = ANSI_GREEN;
                break;
            case "Blue":
                printColor = ANSI_BLUE;
                break;
            case "Yellow":
                printColor = ANSI_YELLOW;
                break;
            default:
                printColor = ANSI_BLACK;
                break;
        }
    }

    public String getPrintColor()
    {
        return printColor;
    }
    public String toString()
    {
        return displayColor;
    }

};
