package com.gym.reto3.repository.crudrepository;

import com.gym.reto3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
