package services;

import dto.ContactsRequest.ContactsCreationRequests;
import dto.ContactsResponse.ContactsCreationResponse;

public interface ContactsService {
	ContactsCreationResponse createNewContact(ContactsCreationRequests contactsCreationRequests);
	
	int getCountsOfContactsPerPhonebook(int id);
	
	ContactsCreationResponse updateSavedContact(ContactsCreationRequests contactsCreationRequests, String newName);
	
	ContactsCreationResponse findContactByName(ContactsCreationRequests contactsCreationRequests);
	
	ContactsCreationResponse findContactByPhoneNumber(ContactsCreationRequests contactsCreationRequests);
	
	boolean DeleteContactById(int id, int phonebookId);
	
	boolean DeleteContactByPhoneNumber(String contactPhoneNumber, int phonebookId);
	
	ContactsCreationResponse[] sortContactsByNameInAlphabeticalOrder(int phonebookId);
}
