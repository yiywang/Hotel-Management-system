package service;

public class ServiceTest {

	public static void main(String[] args) {
		HotelManagementSystem test = new HotelManagementSystem();
		System.out.println("**************************************Set Rooms******************************************");
		test.addDoubleRoom("x1", 1, "READY");
		test.addDoubleRoom("x1", 2, "READY");
		test.addDoubleRoom("y1", 3, "READY");
		test.addDoubleRoom("z1", 4, "READY");
		test.addDoubleRoom("m1", 5, "READY");
		
		test.addFamilyRoom("x1", 6, "READY");
		test.addFamilyRoom("m1", 7, "READY");
		test.addFamilyRoom("z1", 8, "READY");
		test.addFamilyRoom("y1", 9, "READY");
		test.addFamilyRoom("z1", 10, "READY");
		System.out.println();
		System.out.println("**************************************Print All Rooms******************************************");
		test.printRooms();
		System.out.println();
		System.out.println("**************************************Set Clients******************************************");

		test.addClient("Yiyu Wang", "yiyu.wang@vub.be");
		test.addClient("Bruce Lee", "Bruce.Lee@vub.be");
		test.addClient("Jackie Chan", "Jackie.Chan@vub.be");
		test.addClient("David Beckham", "David.Beckham@vub.be");
		test.addClient("Donald Trump", "Donald.Trump@vub.be");
		System.out.println();
		System.out.println("**************************************Check in Doubleroom(1 and 2)******************************************");
		System.out.println();
		test.checkInDoubleRoom(1);
		test.checkInFamilyRoom(2);
		System.out.println("*****************************Print All Clients**************************************");
		System.out.println();
		test.printClients();
		System.out.println("******************************Print All Rooms********************************************");
		System.out.println();
		test.printRooms();
		System.out.println("******************************Print All Rooms********************************************");
		System.out.println();
		System.out.println("**************************************Check out Doubleroom(1)******************************************");
		test.checkOutRoom(1);
		System.out.println();
		System.out.println("**************************************print rooms and clients******************************************");
		test.printRooms();
		test.printClients();
		System.out.println();
		System.out.println("**************************************print availible rooms******************************************");
		test.printAvailableRooms();
		System.out.println();
		System.out.println("**************************************print occupied rooms******************************************");
		test.printOccupiedRooms();
		
		test.addWing("x1");
		//I think that the first added wing is the location of cleaner
		test.addWing("y1");
		test.addWing("z1");
		//I think that the last added wing is the terminal of cleaner
		test.addWing("m1");
		
		test.connectWings("x1", "y1", 89.5);
		test.connectWings("x1", "z1", 91.3);
		test.connectWings("z1", "m1", 70.4);
		test.connectWings("y1", "z1", 101.1);
		test.connectWings("y1", "m1", 22.5);
		
		test.organizeCleaning();
		
		
	
	}

}
