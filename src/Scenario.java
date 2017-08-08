package src;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a game scenario including connected rooms and items
 *
 * @author Cara Tang and Jacob Perrine
 * @version 2017.08.07
 *
 * @modifications
 * - Moved game scenario configuration from Game class to this class' constructor
 * - Populated the rooms ArrayList with the rooms from the game scenario
 */
public class Scenario
{
    private ArrayList<Room> rooms;
    private Room startRoom;
    private Random random;

    /**
     * Constructor for objects of class Scenario
     */
    public Scenario()
    {
        random = new Random();

        // declare the rooms
        Room centerStage, backStage, westLawn, eastLawn, frontLawn,
                merchCounter, foodCourt, parkingLot, stageCatwalks;

        // configure the room descriptions
        centerStage = new Room("by the stairs leading onto center stage");
        backStage = new Room("in the back stage area");
        westLawn = new Room("trudging through the west lawn");
        eastLawn = new Room("walking along the east lawn");
        frontLawn = new Room("on the front lawn");
        merchCounter = new Room("standing near the merchandise counter");
        foodCourt = new Room("milling around the food court");
        parkingLot = new Room("in the parking lot");
        stageCatwalks = new Room("up in the catwalks above the stage");

        // configure room exits
        centerStage.setExit("north", backStage);
        centerStage.setExit("east", eastLawn);
        centerStage.setExit("south", frontLawn);
        centerStage.setExit("west", westLawn);

        backStage.setExit("south", centerStage);
        backStage.setExit("up", stageCatwalks);

        westLawn.setExit("east", centerStage);
        westLawn.setExit("south", merchCounter);

        eastLawn.setExit("south", foodCourt);
        eastLawn.setExit("west", centerStage);

        frontLawn.setExit("north", centerStage);
        frontLawn.setExit("east", foodCourt);
        frontLawn.setExit("south", parkingLot);
        frontLawn.setExit("west", merchCounter);

        merchCounter.setExit("north", westLawn);
        merchCounter.setExit("east", frontLawn);

        foodCourt.setExit("north", eastLawn);
        foodCourt.setExit("west", frontLawn);

        parkingLot.setExit("north", frontLawn);

        stageCatwalks.setExit("down", backStage);

        // initialize items and add them to rooms
        Item unknownGuitar = new Item("someone's guitar", 5);
        Item leftBoot = new Item("a single black boot. The left one", 2);
        Item rightBoot = new Item("a single black boot. The right one", 2);
        Item lightsRemote = new Item("the lights panel remote control", 1);
        centerStage.setItem(unknownGuitar);
        merchCounter.setItem(leftBoot);
        parkingLot.setItem(rightBoot);
        stageCatwalks.setItem(lightsRemote);

        // Set the start room
        startRoom = centerStage;

        // Add all the rooms to the rooms ArrayList
        rooms.add(centerStage);
        rooms.add(backStage);
        rooms.add(westLawn);
        rooms.add(eastLawn);
        rooms.add(frontLawn);
        rooms.add(merchCounter);
        rooms.add(foodCourt);
        rooms.add(parkingLot);
        rooms.add(stageCatwalks);
    }

    /**
     * @return  the start room for this scenario
     */
    public Room getStartRoom()
    {
        return startRoom;
    }

    /**
     * @return  a random room from this scenario
     */
/*    public Room getRandomRoom()
    {
        // complete this method
    }*/
}
