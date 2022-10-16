package com.gym.reto3.services;

import com.gym.reto3.entities.Client;
import com.gym.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client c) {
        Optional<Client> cat = clientRepository.getClient(c.getIdClient());
        if (c.getIdClient() == null || cat.isEmpty()) {
            return clientRepository.save(c);
        }
        return c;
    }

    public Client update(Client c) {
        Optional<Client> ClientServer = clientRepository.getClient(c.getIdClient());
        if (ClientServer.isPresent() && c.getIdClient() != null && c.getName() != null) {
            ClientServer.get().setName(c.getName());
            ClientServer.get().setEmail(c.getEmail());
            ClientServer.get().setAge(c.getAge());
            ClientServer.get().setPassword(c.getPassword());
            return clientRepository.save(ClientServer.get());
        }
        return c;
    }

    public Boolean delete(int id){
        Optional<Client> ClientId = clientRepository.getClient(id);
        if (ClientId.isPresent()) {
            clientRepository.delete(ClientId.get());
            return true;
        }
        return false;
    }
}
