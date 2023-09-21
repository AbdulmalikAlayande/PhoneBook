package services;

import dto.ContactsRequest.ContactsCreationRequests;
import dto.ContactsResponse.ContactsCreationResponse;
import dto.PhonebookRequest.PhoneBookCreationRequest;
import dto.PhonebookResponse.PhoneBookCreationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactsServiceTest {
	
	ContactsService contactsService;
	PhonebookService phonebookService;
	PhoneBookCreationRequest phoneBookCreationRequest;
	PhoneBookCreationResponse phoneBookCreationResponse;
	ContactsCreationRequests contactsCreationRequests;
	ContactsCreationResponse contactsCreationResponse;
	
	
	@BeforeEach void setUp(){
		contactsService = new ContactServiceImpl();
		phonebookService = new PhonebookServiceImpl();
		phoneBookCreationRequest = new PhoneBookCreationRequest();
		phoneBookCreationResponse = new PhoneBookCreationResponse();
		contactsCreationRequests = new ContactsCreationRequests();
		contactsCreationResponse = new ContactsCreationResponse();
	}
	
	@DisplayName("Create a new contact and save the contact test")
	@Test void saveNewContactTest(){
		phoneBookCreationRequest.setOwnerName("Abdulmalik Alayande");
		PhoneBookCreationResponse savedPhonebook = phonebookService.createPhoneBook(phoneBookCreationRequest);
		
		contactsCreationRequests.setName("Abimbola");
		contactsCreationRequests.setPhoneNumber("08090456732");
		contactsCreationRequests.setPhonebookId(savedPhonebook.getId());
		
		ContactsCreationResponse saveContact = contactsService.createNewContact(contactsCreationRequests);
		System.out.println(saveContact.getPhonebookId());
		assertEquals(1, contactsService.getCountsOfContactsPerPhonebook(savedPhonebook.getId()));
	}
	
	@Test void saveNewContact_UpdateSavedContactTest(){
		phoneBookCreationRequest.setOwnerName("Dominic");
		PhoneBookCreationResponse savedPhonebookResponse = phonebookService.createPhoneBook(phoneBookCreationRequest);
		
		contactsCreationRequests.setName("Abdulmalik Semicolon");
		contactsCreationRequests.setPhonebookId(savedPhonebookResponse.getId());
		contactsCreationRequests.setPhoneNumber("07036174617");
		
		contactsService.createNewContact(contactsCreationRequests);
		assertEquals(1, contactsService.getCountsOfContactsPerPhonebook(contactsCreationRequests.getPhonebookId()));
		
		contactsCreationRequests.setName("Abdulmalik");
		contactsService.updateSavedContact(contactsCreationRequests);
		assertEquals(1, contactsService.getCountsOfContactsPerPhonebook(contactsCreationRequests.getPhonebookId()));
	}
}