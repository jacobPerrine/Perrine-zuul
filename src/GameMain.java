package src;

/**
 * Main launching point for the Summer Swing application.
 *
 * @author Jacob Perrine
 * @version 2017.07.24
 *
 * @modifications
 * -added the Week4Test.display() call in main() in order to test
 *  whether Git and GitHub were configured correctly
 * -added Week4Test.anotherDisplay() to test after game.play() resolves
 */
public class GameMain
{
    /**
     * Main argument to launch the program.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        Week4Test.display(); // test
        game.play();
        Week4Test.anotherDisplay(); // test
    }
}
