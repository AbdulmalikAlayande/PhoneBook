package dto.PhonebookResponse;

import java.util.Objects;

public class PhoneBookCreationResponse {
	private int id;
	private String ownerName;
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public int getPhonebookId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PhoneBookResponse{");
		sb.append("ownerName='").append(ownerName).append('\'');
		sb.append('}');
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != PhoneBookCreationResponse.class) return false;
		PhoneBookCreationResponse newObject = (PhoneBookCreationResponse) obj;
		return Objects.equals(newObject.ownerName, ownerName);
	}
}
