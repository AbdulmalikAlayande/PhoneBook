package services;

import data.models.Contact;
import data.repositories.ContactRepository;
import data.repositories.ContactRepositoryImpl;
import dto.ContactsRequest.ContactsCreationRequests;
import dto.ContactsResponse.ContactsCreationResponse;
import utils.ContactsMapper;

public class ContactServiceImpl implements ContactsService{
	private final ContactRepository contactRepository = new ContactRepositoryImpl();
	
	@Override
	public ContactsCreationResponse createNewContact(ContactsCreationRequests contactsCreationRequests) {
		Contact newContact = new Contact();
		ContactsMapper.map(newContact, contactsCreationRequests);
		contactRepository.save(newContact);
		ContactsCreationResponse contactsCreationResponse = new ContactsCreationResponse();
		contactsCreationResponse.setName(newContact.getName());
		contactsCreationResponse.setPhoneNumber(newContact.getPhoneNumber());
		contactsCreationResponse.setPhonebookId(newContact.getPhonebookId());
		return contactsCreationResponse;
	}
	
	@Override
	public int getCountsOfContactsPerPhonebook(int id) {
		return contactRepository.count();
	}
	
	@Override
	public ContactsCreationResponse updateSavedContact(ContactsCreationRequests contactsCreationRequests) {
		Contact foundContact = contactRepository.findById(contactsCreationRequests.getId(), contactsCreationRequests.getPhonebookId());
		ContactsMapper.updateMapper(foundContact, contactsCreationRequests);
		contactRepository.save(foundContact);
		ContactsCreationResponse response = new ContactsCreationResponse();
		response.setPhonebookId(foundContact.getPhonebookId());
		response.setName(foundContact.getName());
		response.setPhoneNumber(foundContact.getPhoneNumber());
		return response;
	}
}
