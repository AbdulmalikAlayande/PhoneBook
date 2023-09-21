package utils;

import data.models.Contact;
import dto.ContactsRequest.ContactsCreationRequests;

public class ContactsMapper {
	public static void map(Contact newContact, ContactsCreationRequests contactsCreationRequests) {
		newContact.setName(contactsCreationRequests.getName());
		newContact.setPhoneNumber(contactsCreationRequests.getContactPhoneNumber());
		newContact.setPhonebookId(contactsCreationRequests.getContactPhonebookId());
	}
	
	public static void updateMapper(Contact foundContact, ContactsCreationRequests contactsCreationRequests){
		foundContact.setName(contactsCreationRequests.getName());
		foundContact.setPhoneNumber(contactsCreationRequests.getContactPhoneNumber());
		foundContact.setPhonebookId(contactsCreationRequests.getContactPhonebookId());
	}
}
