package data.repositories;

import data.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactRepositoryImpl implements ContactRepository{
	
	private int count;
	private final List<Contact> contacts = new ArrayList<>();
	
	@Override
	public Contact save(Contact contact) {
		if(!contactAlreadyExistsInPhonebook(contact.getContactPhonebookId(), contact))
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
			if (eachContact.getContactPhonebookId() == phoneBookId) if (contact == eachContact) return true;
		return false;
	}
	
	@Override
	public Contact findById(int id, int phonebookId) {
		for (Contact eachContact : contacts) {
			if (eachContact.getContactPhonebookId() == phonebookId && eachContact.getContactId() == id)
				return eachContact;
		}
		return null;
	}
	
	@Override
	public Contact findByName(String contactName, int phonebookId) {
		for (Contact eachContact : contacts) {
			if (eachContact.getContactPhonebookId() == phonebookId)
				if ( Objects.equals(eachContact.getContactName(), contactName)) return eachContact;
		}
		return null;
	}
	@Override
	public Contact findByPhoneNumber(String phoneNumber, int phonebookId) {
		for (Contact eachContact : contacts) {
			if (eachContact.getContactPhonebookId() == phonebookId)
				if ( Objects.equals(eachContact.getContactPhoneNumber(), phoneNumber)) return eachContact;
		}
		return null;
	}
	
	@Override
	public boolean deleteByPhoneNumber(String contactPhoneNumber, int phonebookId) {
		Contact foundContact = findByPhoneNumber(contactPhoneNumber, phonebookId);
		if (foundContact.getContactPhoneNumber() != null){
			contacts.remove(foundContact);
			count--;
			return true;
		}
		return false;
	}
	
	@Override
	public Contact[] sortContactsByNameInAlphabeticalOrder(int phonebookId) {
		Contact[] listOfContacts = getListOfContactsWithTheSamePhonebookId(phonebookId);
		return contactsSortedByName(listOfContacts);
	}
	
	private Contact[] contactsSortedByName(Contact[] listOfContacts) {
		for (int eachIndex = 0; eachIndex < listOfContacts.length; eachIndex++) {
			int swappedIndex = eachIndex;
			for (int indexToCompareWithEachIndex = eachIndex + 1; indexToCompareWithEachIndex < listOfContacts.length; indexToCompareWithEachIndex++) {
				if (listOfContacts[indexToCompareWithEachIndex].getContactName().toLowerCase().compareTo(listOfContacts[eachIndex].getContactName().toLowerCase()) < 0) {
					swappedIndex = indexToCompareWithEachIndex;
				}
			}
			
			Contact temporaryContact = listOfContacts[eachIndex];
			listOfContacts[eachIndex] = listOfContacts[swappedIndex];
			listOfContacts[swappedIndex] = temporaryContact;
		}
		return listOfContacts;
	}
	
	
	private Contact[] getListOfContactsWithTheSamePhonebookId(int phonebookId) {
		Contact[] listOfFoundContacts = new Contact[countPerPhoneBook(phonebookId)];
		int listOfFoundContactsCounter = 0;
		for (Contact contact : contacts) {
			if (contact.getContactPhonebookId() == phonebookId) {
				listOfFoundContacts[listOfFoundContactsCounter] = contact;
				listOfFoundContactsCounter++;
			}
		}
		return listOfFoundContacts;
	}
	
	@Override
	public boolean deleteById(int id, int phonebookId) {
		Contact foundContact = findById(id, phonebookId);
		if (foundContact.getContactId() != 0)  {
			contacts.remove(foundContact);
			count--;
			return true;
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
		for (Contact contact: contacts) if (contact.getContactPhonebookId() == phoneBookId) countOfContacts++;
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
