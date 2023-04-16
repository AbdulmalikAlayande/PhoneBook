package data.models;

public class Contact {
	private int id;
	private int phonebookId;
	private String name;
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPhonebookId() {
		return phonebookId;
	}
	
	public void setPhonebookId(int phonebookId) {
		this.phonebookId = phonebookId;
	}
}
