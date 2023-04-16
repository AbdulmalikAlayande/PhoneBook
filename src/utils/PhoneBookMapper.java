package utils;

import data.models.Phonebook;
import dto.PhonebookRequest.PhoneBookCreationRequest;
import dto.PhonebookRequest.PhoneBookFindByIdRequest;

public class PhoneBookMapper {
	
	public static void map(PhoneBookCreationRequest request, Phonebook phonebook) {
		phonebook.setOwnerName(request.getOwnerName());
	}
	
	public static void map(PhoneBookFindByIdRequest request){
	
	}
}
