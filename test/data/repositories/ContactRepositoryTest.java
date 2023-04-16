package data.repositories;

import data.models.Contact;
import data.models.Phonebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryTest {
	
	ContactRepository contactRepository;
	PhonebookRepository phonebookRepository;
	Contact contact;
	private Phonebook phoneBook;
	
	@BeforeEach
	void setUp(){
		contactRepository = new ContactRepositoryImpl();
		phonebookRepository = new PhonebookRepositoryImpl();
		contact = new Contact();
		phoneBook = new Phonebook();
	}
	@Test void testThatContactsAndPhoneBookExists(){
		assertNotNull(contact);
		assertNotNull(phoneBook);
	}
	
	@Test void testNewContactCanBeSaved(){
		phonebookRepository.save(phoneBook);
		contact.setPhonebookId(phoneBook.getId());
		contactRepository.save(contact);
		assertEquals(1, contactRepository.countPerPhoneBook(contact.getPhonebookId()));
	}
	
	@Test void contactIsSavedTwice_CountIsOneTest(){
		phonebookRepository.save(phoneBook);
		contact.setPhonebookId(phoneBook.getId());
		contactRepository.save(contact);
		contactRepository.save(contact);
		assertEquals(1, contactRepository.countPerPhoneBook(contact.getPhonebookId()));
	}
	
	@Test void saveContact_IdIsGeneratedTest(){
		Contact contact1 = new Contact();
		Contact contact2 = new Contact();
		
		phonebookRepository.save(phoneBook);
		
		contact.setPhonebookId(phoneBook.getId());
		contact1.setPhonebookId(phoneBook.getId());
		contact2.setPhonebookId(phoneBook.getId());
		
		contactRepository.save(contact);
		contactRepository.save(contact1);
		contactRepository.save(contact2);
		
		assertEquals(1, contact.getId());
		assertEquals(2, contact1.getId());
		assertEquals(3, contact2.getId());
		
		assertEquals(1, contact.getPhonebookId());
		assertEquals(1, contact1.getPhonebookId());
		assertEquals(1, contact2.getPhonebookId());
		
		assertEquals(3, contactRepository.countPerPhoneBook(contact.getPhonebookId()));
		assertEquals(1, phonebookRepository.count());
	}
	
	@Test void saveContact_FindByIdTest(){
		phonebookRepository.save(phoneBook);
		contact.setPhonebookId(phoneBook.getId());
		contactRepository.save(contact);
		Contact foundContact = contactRepository.findById(contact.getId(), contact.getPhonebookId());
		assertSame(foundContact, contact);
	}
	
	@Test void saveContact_DeleteByIdTest(){
		phonebookRepository.save(phoneBook);
		contact.setPhonebookId(phoneBook.getId());
		contactRepository.save(contact);
		boolean contactIdDeleted = contactRepository.deleteById(contact.getId(), contact.getPhonebookId());
		assertTrue(contactIdDeleted);
	}
	
	@DisplayName("Test that saving a contact twice maintains a single id")
	@Test void saveContactTwice_idIsStillOne(){
		phonebookRepository.save(phoneBook);
		contact.setPhonebookId(phoneBook.getId());
		int initialId = contactRepository.save(contact).getId();
		int currentId = contactRepository.save(contact).getId();
		assertEquals(initialId, currentId);
		assertEquals(1, contactRepository.countPerPhoneBook(contact.getPhonebookId()));
	}
	
	@DisplayName("When an existing contact name is edited and resaved, test that the contact name has been updated when found")
	@Test void editAContactName_findTheContact_contactNameIsUpdatedTest(){
		phonebookRepository.save(phoneBook);
		contact.setPhonebookId(phoneBook.getId());
		contact.setName("Abdulmalik");
		int initialId = contactRepository.save(contact).getId();
		assertEquals("Abdulmalik", contact.getName());
		
		int currentId = contactRepository.save(contact).getId();
		assertEquals(initialId, currentId);
		contactRepository.editContactNameByContactId(currentId, contact.getPhonebookId(),"Moyin");
		
		assertEquals("Moyin", contactRepository.findById(currentId, contact.getPhonebookId()).getName());
	}
}