package src;

/**
 * This class is a modification of the main class of the "World of Zuul",
 * a very simple text based adventure game authored by Michael Kölling 
 * and David J. Barnes. This modification, "Summer Swing", casts the player
 * as a musician trying to find and collect their bandmates in order to play,
 * and hopefully win first prize, at a music festival.
 *  
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all
 * rooms, the parser, the timer, and starts the game. It also evaluates
 * and executes the commands that the parser returns.
 * 
 * @author  Michael Kölling, David J. Barnes, and Jacob Perrine
 * @version 2017.08.07
 * 
 * @modifications
 * - Moved the contents of createRooms() to the Scenario class; deleted createRooms()
 * - Set currentRoom in Game() to use the start room value of the Scenario class
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private TimeClock timer;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        timer = new TimeClock();
        Scenario game = new Scenario();
        currentRoom = game.getStartRoom();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thanks for playing. Bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Summer Swing!");
        System.out.println("This is an updated but rather boring " +
                           "adventure game.");
        System.out.println("Type 'help' to see the options available " +
                           "to you.");
        System.out.println();
        look();
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command The command to be processed.
     * 
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if(commandWord.equals("help")) {
            printHelp();
        }
        else if(commandWord.equals("go")) {
            goRoom(command);
            timer.incrementTime(10);
            // only action that advances the in-game clock
        }
        else if(commandWord.equals("look")) {
            look();
        }
        else if(commandWord.equals("time")) {
            time();
        }
        else if(commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information, including the current 
     * objective and a list of the command words.
     */
    private void printHelp() 
    {
        System.out.println("Find your bandmates so you can play the show!");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getCommands());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            look();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * 
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
     * Allow the player to see the description (including exits and items)
     * of the current room at will.
     */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * Allow the player to check the in-game time.
     */
    private void time()
    {
        System.out.println("The current time is " + timer.timeToString());
    }
}
