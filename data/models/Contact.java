package data.models;

public class Contact {
	private int id;
	private int phonebookId;
	private String name;
	private String phoneNumber;
	
	public String getContactName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContactPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getContactId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getContactPhonebookId() {
		return phonebookId;
	}
	
	public void setPhonebookId(int phonebookId) {
		this.phonebookId = phonebookId;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Contact{");
		sb.append("id=").append(id);
		sb.append(", phonebookId=").append(phonebookId);
		sb.append(", name='").append(name).append('\'');
		sb.append(", phoneNumber='").append(phoneNumber).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
