package services;

import data.models.Contact;
import data.repositories.ContactRepository;
import data.repositories.ContactRepositoryImpl;
import dto.ContactsRequest.ContactsCreationRequests;
import dto.ContactsResponse.ContactsCreationResponse;
import dto.PhonebookResponse.PhoneBookCreationResponse;
import utils.ContactsMapper;

public class ContactServiceImpl implements ContactsService{
	private final PhonebookService phonebookService = new PhonebookServiceImpl();
	private final ContactRepository contactRepository = new ContactRepositoryImpl();
	
	@Override
	public ContactsCreationResponse createNewContact(ContactsCreationRequests contactsCreationRequests) {
		Contact newContact = new Contact();
		ContactsMapper.map(newContact, contactsCreationRequests);
		contactRepository.save(newContact);
		ContactsCreationResponse contactsCreationResponse = new ContactsCreationResponse();
		responseMapper(contactsCreationResponse, newContact);
		return contactsCreationResponse;
	}
	
	@Override
	public int getCountsOfContactsPerPhonebook(int id) {
		return contactRepository.countPerPhoneBook(id);
	}
	
	@Override
	public ContactsCreationResponse updateSavedContact(ContactsCreationRequests contactsCreationRequests, String newName) {
		Contact foundContact = contactRepository.findByName(contactsCreationRequests.getName(), contactsCreationRequests.getContactPhonebookId());
		foundContact.setName(newName);
		contactRepository.save(foundContact);
		ContactsCreationResponse response = new ContactsCreationResponse();
		responseMapper(response, foundContact);
		return response;
	}
	
	@Override
	public ContactsCreationResponse findContactByName(ContactsCreationRequests contactsCreationRequests) {
		Contact foundContact = contactRepository.findByName(contactsCreationRequests.getName(), contactsCreationRequests.getContactPhonebookId());
		ContactsCreationResponse response = new ContactsCreationResponse();
		responseMapper(response, foundContact);
		return response;
	}
	
	@Override
	public ContactsCreationResponse findContactByPhoneNumber(ContactsCreationRequests contactsCreationRequests) {
		Contact foundContact = contactRepository.findByPhoneNumber(contactsCreationRequests.getContactPhoneNumber(), contactsCreationRequests.getContactPhonebookId());
		System.out.println("The found contact phone number is: "+foundContact.getContactPhoneNumber());
		ContactsCreationResponse response = new ContactsCreationResponse();
		responseMapper(response, foundContact);
		return response;
	}
	
	@Override
	public boolean DeleteContactById(int id, int phonebookId) {
		return contactRepository.deleteById(id, phonebookId);
	}
	
	@Override
	public boolean DeleteContactByPhoneNumber(String contactPhoneNumber, int phonebookId) {
		return contactRepository.deleteByPhoneNumber(contactPhoneNumber, phonebookId);
	}
	
	@Override
	public ContactsCreationResponse[] sortContactsByNameInAlphabeticalOrder(int phonebookId) {
		PhoneBookCreationResponse response = phonebookService.findById(phonebookId);
		Contact[] foundListOfContact = contactRepository.sortContactsByNameInAlphabeticalOrder(response.getPhonebookId());
		ContactsCreationResponse[] responses = new ContactsCreationResponse[foundListOfContact.length];
		int responsesCounter = 0;
		for (int i = 0; i < responses.length; i++) {
			responseMapper(responses[responsesCounter], foundListOfContact[i]);
			responsesCounter++;
		}
		return responses ;
	}
	
	private void responseMapper(ContactsCreationResponse response, Contact contact){
		response.setContactName(contact.getContactName());
		response.setContactId(contact.getContactId());
		response.setContactPhoneNumber(contact.getContactPhoneNumber());
		response.setContactPhonebookId(contact.getContactPhonebookId());
	}
}
