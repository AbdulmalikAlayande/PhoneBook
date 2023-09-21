package dto.ContactsResponse;

public class ContactsCreationResponse {
	private int id;
	private String name;
	private String phoneNumber;
	private int phonebookId;
	
	public int getId() {
		return id;
	}
	
	public void setContactId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setContactName(String name) {
		this.name = name;
	}
	
	public String getContactPhoneNumber() {
		return phoneNumber;
	}
	
	public void setContactPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getPhonebookId() {
		return phonebookId;
	}
	
	public void setContactPhonebookId(int phonebookId) {
		this.phonebookId = phonebookId;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ContactsCreationResponse{");
		sb.append("name='").append(getName()).append('\'');
		sb.append(", phoneNumber='").append(getContactPhoneNumber()).append('\'');
		sb.append(", phonebookId=").append(getPhonebookId());
		sb.append('}');
		return sb.toString();
	}
}
