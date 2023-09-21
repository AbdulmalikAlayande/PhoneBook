package data.repositories;

import data.models.Phonebook;

public interface PhonebookRepository {
	
	
	Phonebook save(Phonebook phonebook);
	
	int count();
	
	Phonebook findById(int id);
	
	Phonebook findByName(String phonebookName);
	
	boolean deleteById(int id);
	}
