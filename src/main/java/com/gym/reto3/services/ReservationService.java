package com.gym.reto3.services;

import com.gym.reto3.entities.Reservation;
import com.gym.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservationById(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation c) {
        if (c.getidReservation() == null) {
            return reservationRepository.save(c);
        } else {
            Optional<Reservation> reservation = reservationRepository.getReservation(c.getidReservation());
            if (reservation.isPresent()) {
                return c;
            } else {
                return reservationRepository.save(c);
            }
        }
    }

    public Reservation update(Reservation c) {
        Optional<Reservation> ReservationServer = reservationRepository.getReservation(c.getidReservation());
        if (ReservationServer.isPresent() && c.getidReservation() != null) {
            ReservationServer.get().setStartDate(c.getStartDate());
            return reservationRepository.save(ReservationServer.get());
        }
        return c;
    }

    public Boolean delete(int id){
        Optional<Reservation> ReservationId = reservationRepository.getReservation(id);
        if (ReservationId.isPresent()) {
            reservationRepository.delete(ReservationId.get());
            return true;
        }
        return false;
    }
}
