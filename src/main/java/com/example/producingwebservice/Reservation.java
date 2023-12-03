package com.example.producingwebservice;

import java.util.Date;
import java.util.UUID;

public class Reservation {
        private String reservation_id;
        private Date startDate;
        private Date endDate;
        private User client;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReservation_id() {
        return reservation_id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Reservation(Date startDate, Date endDate, User client) {
        this.reservation_id = UUID.randomUUID().toString();
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                "} ";
    }
    // Constructor, getters, setters for startDate and endDate...

        public boolean overlaps(Date start, Date end) {
            return !(start.after(endDate) || end.before(startDate));
        }
}
