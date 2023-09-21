package dto.PhonebookRequest;

import data.models.Phonebook;

import java.util.Objects;

public class PhoneBookFindByIdRequest {
	private int id;
	private String ownerName;
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Phonebook{");
		sb.append("id=").append(id);
		sb.append(", ownerName='").append(ownerName).append('\'');
		sb.append('}');
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object theObject){
		if (theObject.getClass() != this.getClass()) return false;
		PhoneBookFindByIdRequest anyObject = (PhoneBookFindByIdRequest) theObject;
		return Objects.equals(ownerName, anyObject.ownerName) && id == anyObject.id;
	}
}
