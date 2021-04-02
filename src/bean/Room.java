package bean;
/**
 * @description :A public super class,which is used to compact the information of room
 * @author Yiyu Wang
 */
public class Room {
	
	private String wing;
	private int roomNumber;
	private String status;
	private int id;
	
	
	@Override
	public String toString() {
		return "Room [wing=" + wing + ", roomNumber=" + roomNumber + ", status=" + status + ", id=" + id + "]";
	}

	public Room(String wing, int roomNumber, String status,int id) {
		this.wing = wing;
		this.roomNumber = roomNumber;
		this.status = status;
		this.id = id;
	}
	
	public String getWing() {
		return wing;
	}
	public void setWing(String wing) {
		this.wing = wing;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public Room() {
	}
	

	
	
	
	
}
