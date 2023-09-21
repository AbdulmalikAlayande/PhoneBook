package dto.ContactsRequest;

public class ContactsCreationRequests {
	private int phonebookId;
	private String name;
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContactPhoneNumber() {
		return phoneNumber;
	}
	
	public void setContactPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getContactPhonebookId() {
		return phonebookId;
	}
	
	public void setContactPhonebookId(int phonebookId) {
		this.phonebookId = phonebookId;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ContactsRequests{");
		sb.append(", phonebookId=").append(phonebookId);
		sb.append(", name='").append(name).append('\'');
		sb.append(", phoneNumber='").append(phoneNumber).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
