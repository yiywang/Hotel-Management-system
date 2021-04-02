package bean;


/**
 * @description :A public class,which is used to compact the information of client
 * @author Yiyu Wang
 */
public class Client {
	private String name;
	private String emailAddress;
	private int uniqueId;
	private int hotelRoom;
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", emailAddress=" + emailAddress + ", uniqueId=" + uniqueId + ", hotelRoom="
				+ hotelRoom + "]";
	}
	{
		System.out.println(this.toString());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getUnique_id() {
		return uniqueId;
	}
	public void setUnique_id(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getHotelRoom() {
		return hotelRoom;
	}
	public void setHotelRoom(int hotelRoom) {
		this.hotelRoom = hotelRoom;
	}
	
	public Client() {
	}
	//default hotel room is 0, which means the client has no room
	public Client(String name, String emailAddress) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		hotelRoom = 0;
	}
	
}
