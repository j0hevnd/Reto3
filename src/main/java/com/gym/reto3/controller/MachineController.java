package com.gym.reto3.controller;

import com.gym.reto3.entities.Machine;
import com.gym.reto3.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Machine> getAll(){
        return machineService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody  Machine m){
        machineService.save(m);
    }
}
