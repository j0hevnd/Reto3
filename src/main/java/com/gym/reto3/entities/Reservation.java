package com.gym.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;
    private Date startDate;
    private String status="created";

    @ManyToOne
    @JoinColumn(name = "machineId")
    @JsonIgnoreProperties("reservation")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservation", "messages"})
    private Client client;

    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private List<Score> score;

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }
}
