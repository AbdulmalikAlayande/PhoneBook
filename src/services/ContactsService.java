package services;

import dto.ContactsRequest.ContactsCreationRequests;
import dto.ContactsResponse.ContactsCreationResponse;

public interface ContactsService {
	ContactsCreationResponse createNewContact(ContactsCreationRequests contactsCreationRequests);
	
	int getCountsOfContactsPerPhonebook(int id);
	
	ContactsCreationResponse updateSavedContact(ContactsCreationRequests contactsCreationRequests);
}
