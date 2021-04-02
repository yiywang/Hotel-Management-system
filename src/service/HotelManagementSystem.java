package service;

import util.*;
import bean.*;
/** 
 * @description :This is the management module of project,
 * using the data structure to manage a set of Clients and Rooms,also providing the methods 
 * to insert, edit and delete .etc 
 * @author Yiyu Wang
 */
public class HotelManagementSystem implements IManagementSystem   {
	private LinkedList clients; //used for saving the list of Client
	private LinkedList doubleRooms;//used for saving the list of double room
	private LinkedList familyRooms;//used for saving the list of family room
	private LinkedList wings;//used for saving the list of wings
	private MatrixGraph wingMap;

	public HotelManagementSystem() {
		clients = new LinkedList();
		doubleRooms = new LinkedList();
		familyRooms = new LinkedList();
		wings = new LinkedList();
		wingMap = new MatrixGraph(10);// defaut number of wings ==10
	}

//	 * @param wing where the house is located
//	 *
//	 * @param roomNumber number of the room
//	 * 
//	 * @param status - A room can be READY, OCCUPIED, CHECKEDOUT

	@Override
	public int addDoubleRoom(String wing, int roomNumber, String status) {
		DoubleRoom x = new DoubleRoom();
		x.setWing(wing);
		x.setRoomNumber(roomNumber);
		x.setStatus(status);
		doubleRooms.addFirst(x);
		// set the total room number as the unique id
		x.setID(doubleRooms.size() + familyRooms.size());
		return (doubleRooms.size() + familyRooms.size());
	}

	@Override
	public int addFamilyRoom(String wing, int roomNumber, String status) {
		FamilyRoom x = new FamilyRoom();
		x.setWing(wing);
		x.setRoomNumber(roomNumber);
		x.setStatus(status);
		familyRooms.addFirst(x);
		x.setID(doubleRooms.size() + familyRooms.size());// set the total Rooms number as the unique id
		return (doubleRooms.size() + familyRooms.size());
	}

	@Override
	public int addClient(String name, String emailAddress) {
		Client x = new Client();
		x.setName(name);
		x.setEmailAddress(emailAddress);
		clients.addLast(x);
		x.setUnique_id(clients.size());// set the client size as the unique id
		return clients.size();
	}

	@Override
	public void printRooms() {
		if(familyRooms.isEmpty() == true && doubleRooms.isEmpty() == true) {
			System.out.println("there is no room.Please check!");
		}else {
			System.out.println("the number of rooms is " + (doubleRooms.size()+familyRooms.size()));
			System.out.println();
			System.out.println("the number of family rooms is  " + familyRooms.size()+" --->Please see the information below!");
			System.out.println();
			for(int i =0; i <= (familyRooms.size()-1);i++) {
				Room temp = new Room();
				temp =  (Room)familyRooms.get(i);

				System.out.println("ID: "+temp.getID()+"\t ROOMNUMBER: "+temp.getRoomNumber()+"\t WING: "+temp.getWing()+"\t STAT: "+temp.getStatus());
			}
			System.out.println();
			System.out.println("the number of double rooms is  " + doubleRooms.size()+" --->Please see the information below!");
			System.out.println();
			for(int i =0; i <= (doubleRooms.size()-1);i++) {
				Room temp = new Room();
				temp =  (Room)doubleRooms.get(i);

				System.out.println("ID: "+temp.getID()+"\t ROOMNUMBER: "+temp.getRoomNumber()+"\t WING: "+temp.getWing()+"\t STAT: "+temp.getStatus());
		}
		}
	}

	@Override
	public void printClients() {
		if(clients.isEmpty() == true) {
			System.out.println("there is no client.Please check!");
		}else {
			System.out.println();
			System.out.println("the number of clients is " + clients.size()+" --->Please see their information below!");
			System.out.println();
			for(int i =0; i <= (clients.size()-1);i++) {
				Client temp = new Client();
				temp =  (Client)clients.get(i);
				System.out.println("NAME: "+temp.getName()+"     EMAIL: "+temp.getEmailAddress()+"     ID: "+temp.getUnique_id()+"     ROOM: "+temp.getHotelRoom());
			}
		}
	}
	//part 2
	
	@Override
	/*
	 * Perform check in of a double room.
	 *
	 * @param client ID of a client who's requesting a room
	 *
	 * @return the id of the checked in room 
	 */
	public int checkInDoubleRoom(int client) {
		int num = 0;
		if(doubleRooms.isEmpty() == true) {
			System.out.println("There is no double room in the system, Please check!");
		}else {
			for(int i=0;i < doubleRooms.size();i++) {
				if( ((Room)doubleRooms.get(i)).getStatus() == "READY") {
					((Room)doubleRooms.get(i)).setStatus("OCCUPIED");
					num = ((Room)doubleRooms.get(i)).getID();
					break;
				}
			}
		}
		//as we know, the client ID is the sequence number of appending
		((Client)clients.get(client -1)).setHotelRoom(num);
		return num;
	}

	@Override
	public int checkInFamilyRoom(int client) {
		int num = 0;
		if(familyRooms.isEmpty() == true) {
			System.out.println("There is no double room in the system, Please check!");
		}else {
			for(int i=0;i < familyRooms.size();i++) {
				if( ((Room)familyRooms.get(i)).getStatus() == "READY") {
					((Room)familyRooms.get(i)).setStatus("OCCUPIED");
					num = ((Room)familyRooms.get(i)).getID();
					break;
				}
			}
		}
		//as we know, the client ID is the sequence number of appending
		((Client)clients.get(client -1)).setHotelRoom(num);
		return num;
	}

	@Override
	/*
	 * Perform a check out of a selected room (double  or family)
	 *
	 * @param client ID of a client who's checking out
	 * 
	 * @return true when check out was successful otherwise return false
	 */
	public boolean checkOutRoom(int client) {
		int val = ((Client)clients.get(client -1)).getHotelRoom();
		//the default room number is 0
		if( val == 0) {
			System.out.println("the client has no room yet!");
			return false;
		}else {
			((Client)clients.get(client -1)).setHotelRoom(0);
			
			//from the room number, find the room
			for(int i = 0; i< doubleRooms.size();i++) {
				if( ((Room)doubleRooms.get(i)).getID() == val) {
					((Room)doubleRooms.get(i)).setStatus("CHECKEDOUT");
				}
			}
			for(int j = 0; j < familyRooms.size(); j++) {
				if( ((Room)familyRooms.get(j)).getID() == val) {
					((Room)familyRooms.get(j)).setStatus("CHECKEDOUT");
				}
			}
			System.out.println("Check out succesfully!");
			return true;
		}

	}

	@Override
	public Vector searchAvailableRooms() {
		int avail_double_room = 0;
		int avail_family_room = 0;
		//to get the size of Vector
		for(int i = 0; i <doubleRooms.size();i++) {
			if( ((Room)doubleRooms.get(i)).getStatus() == "READY"   ) {
				avail_double_room++;
			}
		}
		for(int j = 0; j <familyRooms.size();j++) {
			if( ((Room)familyRooms.get(j)).getStatus() == "READY"   ) {
				avail_family_room++;
			}
		}
		Vector temp = new Vector(avail_double_room + avail_family_room);
		
		//to establish the Vector
		//is there some methods that make Vector's size flexible?
		
		for(int i = 0; i <doubleRooms.size();i++) {
			if( ((Room)doubleRooms.get(i)).getStatus() == "READY"   ) {
				temp.addFirst(((Room)doubleRooms.get(i)));
			}
		}
		for(int j = 0; j <familyRooms.size();j++) {
			if( ((Room)familyRooms.get(j)).getStatus() == "READY"   ) {
				temp.addFirst(((Room)familyRooms.get(j)));
			}
		}
		
		return temp;		
		
	}

	@Override
	public void printAvailableRooms() {
		for(int i = 0; i <doubleRooms.size();i++) {
			if( ((Room)doubleRooms.get(i)).getStatus() == "READY"   ) {
				Room temp1 = new Room();
				temp1 = ((Room)doubleRooms.get(i));
				System.out.println("ID: "+temp1.getID()+"\t ROOMNUMBER: "+temp1.getRoomNumber()+"\t WING: "+temp1.getWing()+"\t STAT: "+temp1.getStatus());
			}
		}
		for(int j = 0; j <familyRooms.size();j++) {
			if( ((Room)familyRooms.get(j)).getStatus() == "READY"   ) {
				Room temp2 = new Room();
				temp2 = ((Room)familyRooms.get(j));
				System.out.println("ID: "+temp2.getID()+"\t ROOMNUMBER: "+temp2.getRoomNumber()+"\t WING: "+temp2.getWing()+"\t STAT: "+temp2.getStatus());
			}
		}
		
	}

	@Override
	public void printOccupiedRooms() {
		for(int i = 0; i <doubleRooms.size();i++) {
			if( ((Room)doubleRooms.get(i)).getStatus() == "OCCUPIED"   ) {
				Room temp1 = new Room();
				temp1 = ((Room)doubleRooms.get(i));
				System.out.println("ID: "+temp1.getID()+"\t ROOMNUMBER: "+temp1.getRoomNumber()+"\t WING: "+temp1.getWing()+"\t STAT: "+temp1.getStatus());
			}
		}
		for(int j = 0; j <familyRooms.size();j++) {
			if( ((Room)familyRooms.get(j)).getStatus() == "OCCUPIED"   ) {
				Room temp2 = new Room();
				temp2 = ((Room)familyRooms.get(j));
				System.out.println("ID: "+temp2.getID()+"\t ROOMNUMBER: "+temp2.getRoomNumber()+"\t WING: "+temp2.getWing()+"\t STAT: "+temp2.getStatus());
			}
		}
		
	}
//part 3
	@Override
	public void addWing(String wingName) {
		System.out.println("you have added a new wing    "+wingName);
		Wing x = new Wing();
		x.setWingName(wingName);
		wingMap.addNode(x);
		wings.addLast(x);
	}

	@Override
	public void connectWings(String wing1, String wing2, double distance) {
		System.out.println(wing1+" and "+wing2+" have been connected!");
		Wing wingFirst = null;
		Wing wingSecond= null;
		for(int i =0;i<wings.size();i++) {
			Wing temp1 = (Wing) wings.get(i);
			if(temp1.getWingName().compareTo(wing1)==0) {
				wingFirst = temp1;
			}
		}
		for(int j =0;j<wings.size();j++) {
			Wing temp2 = (Wing) wings.get(j);
			if(temp2.getWingName().compareTo(wing2)==0) {
				wingSecond = temp2;
			}
		}
		wingMap.addEdge(wingFirst, wingSecond, distance);
		
	}

	@Override
	//the cleaning will start at the first added wing
	//and end at the last added wing
	public void organizeCleaning() {
		
		Wing start = (Wing) wings.getFirst();
		Wing end = (Wing) wings.getLast();
		
		LinkedList plans = wingMap.getEveryPath(start, end);
		
		LinkedList unsortedRoutes = new LinkedList();
		
		for(int i = 0;i < plans.size();i++) {
			Stack inside = (Stack) plans.get(i);
			Route obj = new Route(inside);
			unsortedRoutes.addFirst(obj);
		}
		
		LinkedList sortedRoutes = new LinkedList();
		//selection sort
		while(unsortedRoutes.isEmpty()==false) {
			int label = 0;
			Route biggets = (Route)unsortedRoutes.getFirst();
			for(int p = 0;p<unsortedRoutes.size();p++) {
				Route selecTemp = (Route)unsortedRoutes.get(p);
				if(biggets.compareTo(selecTemp) > 0) {
					label = p;
					biggets = (Route)unsortedRoutes.get(p);
				}
			}
			sortedRoutes.addFirst(unsortedRoutes.get(label));
			unsortedRoutes.removeIndex(label);	
		}
		//to find the FamilyRoom's Wing,put it all in the Linkedlist
		LinkedList FamiWingnames = new LinkedList();
		
		for(int i =0 ; i<familyRooms.size();i++) {
			FamilyRoom temp = (FamilyRoom)familyRooms.get(i);
			if(FamiWingnames.contain(temp.getWing()) == false) {
			FamiWingnames.addFirst(temp.getWing());
			}
		}
		//change the String wing to Obejct Wing, put all in Linkedlist
		
		LinkedList FamiWings = new LinkedList();
	
		for(int i =0;i<FamiWingnames.size();i++) {
			Wing temp1 = (Wing) wings.get(i);
			for(int j = 0;j<familyRooms.size();j++) {
				FamilyRoom x =(FamilyRoom)familyRooms.get(j);
				if(temp1.getWingName().compareTo(x.getWing())==0) {
					FamiWings.addFirst(x);
				}
			}
		}
		
		//from order to find which sortedRoute the beiginning with the all FamilyWing
		int FamiLookNum = FamiWings.size();
		// just look at the first FamiLookNum's Route,if all contain the FamiRoom
		// we will get the suitable plan
		int totalNum = sortedRoutes.size();
		int suitLabel = 0;
		for(int i = 0; i<totalNum;i++) {
			Route findTemp = (Route) sortedRoutes.get(i);
			Stack tempPlan = findTemp.plan.copy();
			int countFami = 0;
			for(int j = 0; j<FamiLookNum;j++) {
				if(FamiWings.contain(tempPlan.top())==true) {
					countFami++;
				}
			}
			if(countFami==FamiLookNum) {
				suitLabel = i;
				break;
			}
		}
		//print the route and the distance
		Route suitable = (Route) sortedRoutes.get(suitLabel);
		System.out.println("the most suitable plan is "+suitable);
		//change all the room cleaned
		for(int i = 0;i<familyRooms.size();i++) {
			FamilyRoom x =(FamilyRoom)familyRooms.get(i);
			if(x.getStatus()=="CHECKEDOUT") {
				x.setStatus("READY");
			}
		for(int j = 0;j<doubleRooms.size();j++) {
			DoubleRoom y =(DoubleRoom)doubleRooms.get(i);
			if(y.getStatus()=="CHECKEDOUT") {
				y.setStatus("READY");
			}
			
		}
	}
	}
}
