package com.gym.reto3.services;

import com.gym.reto3.entities.Machine;
import com.gym.reto3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachineById(int id) {
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine c) {
        Optional<Machine> cat = machineRepository.getMachine(c.getId());
        if (c.getId() == null || cat.isEmpty()) {
            return machineRepository.save(c);
        }
        return c;
    }

    public Machine update(Machine c) {
        Optional<Machine> MachineServer = machineRepository.getMachine(c.getId());
        if (MachineServer.isPresent() && c.getId() != null && c.getName() != null) {
            MachineServer.get().setName(c.getName());
            MachineServer.get().setBrand(c.getBrand());
            MachineServer.get().setYear(c.getYear());
            MachineServer.get().setDescription(c.getDescription());
            return machineRepository.save(MachineServer.get());
        }
        return c;
    }

    public Boolean delete(int id){
        Optional<Machine> MachineId = machineRepository.getMachine(id);
        if (MachineId.isPresent()) {
            machineRepository.delete(MachineId.get());
            return true;
        }
        return false;
    }
}
