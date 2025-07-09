package org.example.book.dalti_back.controller;

import org.example.book.dalti_back.entity.Category;
import org.example.book.dalti_back.entity.Client;
import org.example.book.dalti_back.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<?> insertClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.insertClient(client)) ;
    }


    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping()
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Client category){
        return ResponseEntity.ok(clientService.update( category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){ //we can use void
        clientService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/{idClient}/service/{idService}")
    public void bookService(@PathVariable Long idClient, @PathVariable Long idService) {
        clientService.bookService(idClient, idService);
    }

    @DeleteMapping("/{idClient}/service/{idService}")
    public void cancelService(@PathVariable Long idClient, @PathVariable Long idService) {
        clientService.cancelService(idClient, idService);
    }


}
