package service;

import util.Vector;

//  ___   ___  _  _ _ _____    ___ _  _   _   _  _  ___ ___ _ _ _ 
// |   \ / _ \| \| ( )_   _|  / __| || | /_\ | \| |/ __| __| | | |
// | |) | (_) | .` |/  | |   | (__| __ |/ _ \| .` | (_ | _||_|_|_|
// |___/ \___/|_|\_|   |_|    \___|_||_/_/ \_\_|\_|\___|___(_|_|_)
                                                               
public interface IManagementSystem {

	// Part 1
	
	/*
	 * Add a new double room with given parameters - wing where the room is located,
	 * number of the room, the status of the room
	 * (READY/OCCUPIED/CHECKEDOUT) - to the management system
	 *
	 * @param wing where the house is located
	 *
	 * @param roomNumber number of the room
	 * 
	 * @param status - A room can be READY, OCCUPIED, CHECKEDOUT
	 *
	 * @return ID of the room
	 */
	public int addDoubleRoom(String wing, int roomNumber, String status);

	/*
	 * Add a new family room with given parameters - wing where the room is located,
	 * number of the room, the status of the room
	 * (READY/OCCUPIED/CHECKEDOUT) - to the management system
	 *
	 * @param wing where the house is located
	 *
	 * @param roomNumber number of the room
	 * 
	 * @param status - A room can be READY, OCCUPIED, CHECKEDOUT
	 *
	 * @return ID of the room
	 */
	public int addFamilyRoom(String wing, int roomNumber, String status);

	/*
	 * Add a new client with given parameters - name, email address to the
	 * management system
	 *
	 * @param name name of the client
	 * 
	 * @param emailAddress email address of the client
	 *
	 * @return ID of the client
	 */
	public int addClient(String name, String emailAddress);
	
	/*
	 * Print all rooms in the system. Print number of rooms and a summary details
	 * about each one.
	 */
	public void printRooms();

	/*
	 * Print all clients. Print number of clients and a summary details
	 * about each one.
	 */
	public void printClients();

	
	// Part 2
	
	/*
	 * Perform check in of a double room.
	 *
	 * @param client ID of a client who's requesting a room
	 *
	 * @return the id of the checked in room 
	 */
	public int checkInDoubleRoom(int client);
	
	/*
	 * Perform check in of a family room.
	 *
	 * @param client ID of a client who's requesting a room
	 *
	 * @return the id of the checked in room
	 */
	public int checkInFamilyRoom(int client);
	
	/*
	 * Perform a check out of a selected room (double  or family)
	 *
	 * @param client ID of a client who's checking out
	 * 
	 * @return true when check out was successful otherwise return false
	 */
	public boolean checkOutRoom(int client);
	
	/*
	 * Search for a room based on the availability. 
	 * Available rooms are free and cleaned. 
	 *
	 * @return a Vector containing the id of the available rooms.
	*/
	public Vector searchAvailableRooms();
	
	/*
	 * Print all the rooms in state:READY
	*/
	public void printAvailableRooms();
	
	
	/*
	 * Print all the rooms in state: OCCUPIED
	*/
	public void printOccupiedRooms();
	

	//Part 3
	
	/*
	 * Adds a wing into the system
	 *
	 * @param wingName name of the wing that is added to the system
	 * 
	 */
	public void addWing(String wingName);
	
	/*
	 * Adds connection between wings into the system
	 *
	 * @param wing1 name of the first wing that is being connected
	 * 
	 * @param wing2 name of the second wing that is being connected
	 * 
	 * @param distance is the distance between the two wings
	 * 
	 */
	public void connectWings(String wing1, String wing2, double distance);
	
	/*
	 * Organise cleaning for rooms in all the wings.
	 */
	public void organizeCleaning();

}
