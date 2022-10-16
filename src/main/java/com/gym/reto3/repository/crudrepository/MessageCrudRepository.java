package com.gym.reto3.repository.crudrepository;

import com.gym.reto3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
