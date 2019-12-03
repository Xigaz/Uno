package bryce;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("\u001B[1;30m");
        System.out.print("Enter your name: ");
        String n = input.nextLine();
        boolean playAgain = true;

        while(playAgain)
        {
            Player me = new Player(n, Player.PlayerType.HUMAN);
            Game g = new Game(me);
            g.play();
            System.out.print("\u001B[1;30m");
            System.out.print("Would You like to play again (Y/N)? ");
            playAgain = input.nextLine().matches("[YyEeSs]");
        }
        input.close();
    }
}
