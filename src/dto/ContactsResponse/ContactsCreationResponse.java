package dto.ContactsResponse;

public class ContactsCreationResponse {
	private String name;
	private String phoneNumber;
	private int phonebookId;
	
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
	
	public int getPhonebookId() {
		return phonebookId;
	}
	
	public void setPhonebookId(int phonebookId) {
		this.phonebookId = phonebookId;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ContactsCreationResponse{");
		sb.append("name='").append(getName()).append('\'');
		sb.append(", phoneNumber='").append(getPhoneNumber()).append('\'');
		sb.append(", phonebookId=").append(getPhonebookId());
		sb.append('}');
		return sb.toString();
	}
}
