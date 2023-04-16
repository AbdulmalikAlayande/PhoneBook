package dto.ContactsRequest;

public class ContactsCreationRequests {
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
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ContactsRequests{");
		sb.append("id=").append(id);
		sb.append(", phonebookId=").append(phonebookId);
		sb.append(", name='").append(name).append('\'');
		sb.append(", phoneNumber='").append(phoneNumber).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
