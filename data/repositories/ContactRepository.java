package data.repositories;

import data.models.Contact;

public interface ContactRepository {
	Contact save(Contact contact);
	int count();
	
	int countPerPhoneBook(int phoneBookId);
	
	Contact findById(int id, int phonebookId);
	Contact findByName(String contactName, int phonebookId);
	
	boolean deleteById(int id, int phonebookId);
	
	Contact editContactById(int contactId);
	
	Contact editContactNameByContactId(int id, int phonebookId, String newName);
	
	Contact findByPhoneNumber(String phoneNumber, int phonebookId);
	
	boolean deleteByPhoneNumber(String contactPhoneNumber, int phonebookId);
	
	Contact[] sortContactsByNameInAlphabeticalOrder(int phonebookId);
}
