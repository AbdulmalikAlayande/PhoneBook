package data.repositories;

import data.models.Phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhonebookRepositoryImpl implements PhonebookRepository {
	
	private final List<Phonebook> phonebooks = new ArrayList<>();
	private int count;
	
	@Override
	public Phonebook save(Phonebook phonebook) {
		if (!phonebookExists(phonebook)) saveNewPhonebook(phonebook);
		return existingPhonebook(phonebook);
	}
	
	private Phonebook existingPhonebook(Phonebook phonebook) {
		return phonebook;
	}
	
	private void saveNewPhonebook(Phonebook phonebook) {
		phonebook.setId(generatedId());
		phonebooks.add(phonebook);
		count++;
	}
	
	
	private boolean phonebookExists(Phonebook phonebook) {
		for (Phonebook value : phonebooks) if (phonebook == value) return true;
		return false;
	}
	
	private int generatedId() {
		return count + 1;
	}
	
	@Override
	public int count() {
		return phonebooks.size();
	}
	
	@Override
	public Phonebook findById(int id) {
		for (Phonebook phonebook : phonebooks) {
			if (phonebook.getId() == id) {
				return phonebook;
			}
		}
		return null;
	}
	
	@Override
	public Phonebook findByName(String phonebookName) {
		for (Phonebook phonebook : phonebooks)
			if (Objects.equals(phonebook.getOwnerName(), phonebookName)) return phonebook;
		return null;
	}
	
	@Override
	public boolean deleteById(int id) {
		for (Phonebook phonebook : phonebooks)
			if (phonebook.getId() == id) {
				phonebooks.remove(phonebook);
				return true;
			}
		return false;
	}
}
