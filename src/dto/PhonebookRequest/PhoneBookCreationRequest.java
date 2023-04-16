package dto.PhonebookRequest;

public class PhoneBookCreationRequest {
	private String ownerName;
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PhoneBookCreationRequest{");
		sb.append("ownerName='").append(ownerName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
