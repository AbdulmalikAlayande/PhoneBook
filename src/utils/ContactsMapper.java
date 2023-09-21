package utils;

import data.models.Contact;
import dto.ContactsRequest.ContactsCreationRequests;

public class ContactsMapper {
	public static void map(Contact newContact, ContactsCreationRequests contactsCreationRequests) {
		newContact.setName(contactsCreationRequests.getName());
		newContact.setPhoneNumber(contactsCreationRequests.getPhoneNumber());
		newContact.setPhonebookId(contactsCreationRequests.getPhonebookId());
	}
	
	public static void updateMapper(Contact newContact, ContactsCreationRequests contactsCreationRequests){
		newContact.setName(contactsCreationRequests.getName());
		newContact.setPhoneNumber(contactsCreationRequests.getPhoneNumber());
		newContact.setPhonebookId(contactsCreationRequests.getPhonebookId());
	}
}
