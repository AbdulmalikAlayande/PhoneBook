package services;

import data.models.Phonebook;
import data.repositories.PhonebookRepository;
import data.repositories.PhonebookRepositoryImpl;
import dto.PhonebookRequest.PhoneBookCreationRequest;
import dto.PhonebookResponse.PhoneBookCreationResponse;
import utils.PhoneBookMapper;

public class PhonebookServiceImpl implements PhonebookService {
	private final PhonebookRepository phonebookRepository = new PhonebookRepositoryImpl();
	
	@Override
	public PhoneBookCreationResponse createPhoneBook(PhoneBookCreationRequest request) {
		Phonebook phonebook = new Phonebook() ;
		PhoneBookMapper.map(request, phonebook);
		phonebookRepository.save(phonebook);
		PhoneBookCreationResponse phoneBookCreationResponse = new PhoneBookCreationResponse();
		phoneBookCreationResponse.setOwnerName(phonebook.getOwnerName());
		phoneBookCreationResponse.setId(phonebook.getId());
		return phoneBookCreationResponse;
	}
	
	@Override
	public PhoneBookCreationResponse findById(int phonebookId) {
		Phonebook foundPhonebook = phonebookRepository.findById(phonebookId);
		PhoneBookCreationResponse response = new PhoneBookCreationResponse();
		response.setId(foundPhonebook.getId());
		response.setOwnerName(response.getOwnerName());
		return response;
	}
	
	@Override
	public PhoneBookCreationResponse findByName(PhoneBookCreationRequest request) {
		Phonebook foundPhonebook = phonebookRepository.findByName(request.getOwnerName());
		PhoneBookCreationResponse response = new PhoneBookCreationResponse();
		response.setOwnerName(foundPhonebook.getOwnerName());
		return response;
	}
	
	@Override
	public PhoneBookCreationResponse updateName(int id, String newName) {
		Phonebook foundPhonebook = phonebookRepository.findById(id);
		foundPhonebook.setOwnerName(newName);
		phonebookRepository.save(foundPhonebook);
		PhoneBookCreationResponse response = new PhoneBookCreationResponse();
		response.setOwnerName(foundPhonebook.getOwnerName());
		response.setId(foundPhonebook.getId());
		return response;
	}
	
	@Override
	public int count() {
		return phonebookRepository.count();
	}
	
	@Override
	public boolean deletePhonebookById(int id) {
		return phonebookRepository.deleteById(id);
	}
	
}
