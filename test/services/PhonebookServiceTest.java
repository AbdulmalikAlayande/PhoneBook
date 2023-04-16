package services;

import data.repositories.PhonebookRepository;
import data.repositories.PhonebookRepositoryImpl;
import dto.PhonebookRequest.PhoneBookCreationRequest;
import dto.PhonebookRequest.PhoneBookFindByIdRequest;
import dto.PhonebookResponse.PhoneBookCreationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhonebookServiceTest {
	
	PhonebookService phonebookService;
	PhonebookRepository phonebookRepository;
	PhoneBookCreationRequest phonebookCreationRequest;
	PhoneBookFindByIdRequest phoneBookFindByIdRequest;
	@BeforeEach
	void setUp() {
		phonebookCreationRequest = new PhoneBookCreationRequest();
		phonebookService = new PhonebookServiceImpl();
		phonebookRepository = new PhonebookRepositoryImpl();
		phoneBookFindByIdRequest = new PhoneBookFindByIdRequest();
	}
	
	@DisplayName("Save new phonebook to the list of phonebooks test")
	@Test void saveNewPhonebookTest(){
		PhoneBookCreationRequest newRequest = new PhoneBookCreationRequest();
		newRequest.setOwnerName("Basira");
		PhoneBookCreationResponse newResponse = phonebookService.createPhoneBook(newRequest);
		phonebookCreationRequest.setOwnerName("Bolade");
		PhoneBookCreationResponse response = phonebookService.createPhoneBook(phonebookCreationRequest);
		assertSame(phonebookCreationRequest.getOwnerName(), response.getOwnerName());
		assertSame(newRequest.getOwnerName(), newResponse.getOwnerName());
		assertEquals(2, phonebookService.count());
	}
	
	@DisplayName("find phonebook from the list of phonebooks by the phonebook's id test")
	@Test void saveNewPhoneBook_FindByIdTest(){
		phonebookCreationRequest.setOwnerName("Abdulmalik Hakimi Ogbon Sodiki");
		PhoneBookCreationResponse savedPhonebook = phonebookService.createPhoneBook(phonebookCreationRequest);
		
		PhoneBookCreationResponse foundPhonebook = phonebookService.findById(savedPhonebook.getId());
		foundPhonebook.setOwnerName(savedPhonebook.getOwnerName());
		assertEquals(foundPhonebook, savedPhonebook);
	}
	
	@DisplayName("find phonebook from the list of phonebooks by the phonebook's name test")
	@Test void saveNewPhoneBook_FindByNameTest(){
		phonebookCreationRequest.setOwnerName("Abdulmalik Alayande");
		PhoneBookCreationResponse savedPhonebook = phonebookService.createPhoneBook(phonebookCreationRequest);
		
		PhoneBookCreationResponse foundPhonebook = phonebookService.findByName(phonebookCreationRequest);
		foundPhonebook.setOwnerName(savedPhonebook.getOwnerName());
		assertEquals(savedPhonebook, foundPhonebook);
	}
	
	@DisplayName("update test")
	@Test void savePhonebookTwice_UpdatePhonebookTest(){
		phonebookCreationRequest.setOwnerName("Molik");
		PhoneBookCreationResponse response = phonebookService.createPhoneBook(phonebookCreationRequest);
		response = phonebookService.updateName(response.getId(), "Malik");
		assertSame("Malik", response.getOwnerName());
		assertEquals(1, phonebookService.count());
	}
	
	@DisplayName("Delete test")
	@Test void savePhonebook_DeleteByIdTest(){
		phonebookCreationRequest.setOwnerName("Molik");
		PhoneBookCreationResponse response = phonebookService.createPhoneBook(phonebookCreationRequest);
		boolean isDeletedPhonebook = phonebookService.deletePhonebookById(response.getId());
		assertTrue(isDeletedPhonebook);
		assertEquals(0, phonebookService.count());
	}
}
