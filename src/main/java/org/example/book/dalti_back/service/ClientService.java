package org.example.book.dalti_back.service;

import org.example.book.dalti_back.entity.Category;
import org.example.book.dalti_back.entity.Client;
import org.example.book.dalti_back.repository.ClientRepo;
import org.example.book.dalti_back.repository.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepo clientRepo;
    public ClientService(ClientRepo clientRepo) {
        super();
        this.clientRepo = clientRepo;
    }

    @Autowired
    private ServiceRepo serviceRepo;

    public Client insertClient(Client client) {
        return clientRepo.save(client);
    }

    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    public Client findById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    public Client update(Client category) {
        return clientRepo.save(category);
    }

    public void deleteById(Long id) {
        clientRepo.deleteById(id);
    }

    public void bookService(Long idClient, Long idService) {
        Client client = clientRepo.findById(idClient).orElse(null);
        org.example.book.dalti_back.entity.Service service = serviceRepo.findById(idService).orElse(null);
        service.getClients().add(client);
        serviceRepo.save(service);
    }
    public void cancelService(Long idClient, Long idService) {
        Client client = clientRepo.findById(idClient).orElse(null);
        org.example.book.dalti_back.entity.Service service = serviceRepo.findById(idService).orElse(null);
        client.getServices().remove(service);
        service.getClients().remove(client);
        serviceRepo.save(service);
    }

}
