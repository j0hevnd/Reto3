package com.gym.reto3.repository;

import com.gym.reto3.entities.Machine;
import com.gym.reto3.repository.crudrepository.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MachineRepository {
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }

    public Optional<Machine> getMachine(int id){
        return machineCrudRepository.findById(id);
    }

    public Machine save(Machine m){
        return machineCrudRepository.save(m);
    }

    public void delete(Machine m){
        machineCrudRepository.delete(m);
    }
}
