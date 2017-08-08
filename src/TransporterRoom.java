package src;

/**
 * This class inherits from and extends the Room class. The Transporter
 * Room sends the player to a random Room upon exit.
 *
 * @author Jacob Perrine
 * @version 2017.08.07
 */
public class TransporterRoom extends Room
{
    private Scenario game;
    /**
     * Create a transporter room described "description". Initially,
     * it has no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description
     */
    public TransporterRoom(String description, Scenario game)
    {
        super(description);
        this.game = game;
    }

    /**
     * Return a random room, independent of the direction parameter
     *
     * @param direction Ignored
     * @return A random room
     */
    @Override
    public Room getExit(String direction)
    {
        return findRandomRoom();
    }

    /**
     * @return a random room
     */
    private Room findRandomRoom()
    {
        return game.getRandomRoom();
    }

    /**
     * @return A description of how to exit the transporter
     */
    @Override
    public String getExitString()
    {
        return "Exits:  ????  There's gotta be a way out. Try a direction!";
    }
}
