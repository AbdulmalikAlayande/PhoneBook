package data.repositories;

import data.models.Phonebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookRepositoryTest {
	PhonebookRepository phonebookRepository;
	Phonebook phonebook;
	
	@BeforeEach void startWith(){
		phonebookRepository = new PhonebookRepositoryImpl();
		phonebook = new Phonebook();
		phonebook.setOwnerName("Malik");
	}
	
	@Test void testThatPhonebookCanBeSaved(){
		phonebookRepository.save(phonebook);
		assertEquals(1, phonebookRepository.count());
	}

	@Test void phoneBookIsSavedTwice_CountIsOneTest(){
		PhonebookRepository phonebookRepository1 = new PhonebookRepositoryImpl();
		Phonebook phonebook1 = new Phonebook();
		phonebookRepository1.save(phonebook1);
		phonebookRepository1.save(phonebook1);
		assertEquals(1, phonebookRepository1.count());
	}

	@Test void savePhoneBook_IdIsGeneratedTest(){
		phonebookRepository.save(phonebook);
		assertEquals(1, phonebook.getId());
	}

	@Test void savePhoneBook_FindByIdTest(){
		phonebookRepository.save(phonebook);
		Phonebook foundPhoneBook = phonebookRepository.findById(phonebook.getId());
		assertEquals(1, phonebookRepository.count());
		assertSame(foundPhoneBook, phonebook);
	}
	
	@Test void savePhonebook_FindByNameTest(){
		phonebook.setOwnerName("Alayande Abdulmalik");
		phonebookRepository.save(phonebook);
		Phonebook foundPhonebook = phonebookRepository.findByName(phonebook.getOwnerName());
		assertEquals(1, phonebookRepository.count());
		assertSame(foundPhonebook, phonebook);
	}

	@Test void savePhoneBook_DeleteByIdTest(){
		phonebookRepository.save(phonebook);
		boolean phoneBookIdDeleted = phonebookRepository.deleteById(phonebook.getId());
		assertTrue(phoneBookIdDeleted);
	}
		}