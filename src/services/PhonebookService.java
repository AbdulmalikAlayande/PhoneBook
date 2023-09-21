package services;

import data.models.Phonebook;
import dto.PhonebookRequest.PhoneBookCreationRequest;
import dto.PhonebookResponse.PhoneBookCreationResponse;

public interface PhonebookService {
	
	PhoneBookCreationResponse createPhoneBook(PhoneBookCreationRequest request);
	
	PhoneBookCreationResponse findById(int phonebookId);
	
	PhoneBookCreationResponse findByName(PhoneBookCreationRequest request);
	
	PhoneBookCreationResponse updateName(int id, String newName);
	
	int count();
	
	boolean deletePhonebookById(int id);
}
