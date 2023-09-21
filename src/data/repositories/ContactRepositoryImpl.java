package data.repositories;

import data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
	
	private int count;
	private List<Contact> contacts = new ArrayList<>();
	
	@Override
	public Contact save(Contact contact) {
		if(!contactAlreadyExistsInPhonebook(contact.getPhonebookId(), contact))
			saveNewContact(contact);
		return updatedExistingContact(contact);
	}
	
	private Contact updatedExistingContact(Contact contact) {
		return contact;
	}
	
	private void saveNewContact(Contact contact) {
		contact.setId(generateId());
		contacts.add(contact);
	}
	
	private boolean contactAlreadyExistsInPhonebook(int phoneBookId, Contact contact) {
		for (Contact eachContact : contacts)
			if (eachContact.getPhonebookId() == phoneBookId) if (contact == eachContact) return true;
		return false;
	}
	
	@Override
	public Contact findById(int id, int phonebookId) {
		for (Contact eachContact : contacts) {
			if (eachContact.getPhonebookId() == phonebookId) if (eachContact.getId() == id) return eachContact;
		}
		return null;
	}
	
	@Override
	public boolean deleteById(int id, int phonebookId) {
		for (Contact eachContact : contacts) {if (eachContact.getPhonebookId() == phonebookId)
			if (eachContact.getId() == id) contacts.remove(eachContact); return true;
		}
		return false;
	}
	
	@Override
	public Contact editContactById(int contactId) {
		return null;
	}
	
	@Override
	public Contact editContactNameByContactId(int contactId, int phonebookId, String newName) {
		Contact foundContact = findById(contactId, phonebookId);
		boolean isFoundContact = contacts.contains(foundContact);
		if (isFoundContact){
			foundContact.setName(newName);return foundContact;}
		return null;
	}
	
	@Override
	public int countPerPhoneBook(int phoneBookId) {
		int countOfContacts = 0;
		for (Contact contact: contacts) if (contact.getPhonebookId() == phoneBookId) countOfContacts++;
		return countOfContacts;
	}
	
	private int generateId() {
		count = count+1;
		return count;
	}
	
	@Override
	public int count() {
		return contacts.size();
	}
	
}
