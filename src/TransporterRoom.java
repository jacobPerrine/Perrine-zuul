package src;

import java.util.HashMap;

/**
 * This class inherits from and extends the Room class. The Transporter
 * Room sends the player to a random Room upon exit.
 *
 * @author Jacob Perrine
 * @version 2017.08.07
 */
public class TransporterRoom extends Room
{
    public TransporterRoom(String description)
    {
        super(description);
    }
    /**
     * Return a random room, independent of the direction parameter
     *
     * @param direction Ignored
     * @return A random room
     */
    public Room getExit(String direction)
    {
        return findRandomRoom();
    }

    /**
     * @return a random room
     */
    private Room findRandomRoom()
    {

    }
}
