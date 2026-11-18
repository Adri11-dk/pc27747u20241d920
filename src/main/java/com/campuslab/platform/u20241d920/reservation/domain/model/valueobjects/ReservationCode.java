package com.campuslab.platform.u20241d920.reservation.domain.model.valueobjects;

public record ReservationCode(String code) {

    public ReservationCode {
        if (code == null) {
            throw new IllegalArgumentException("Reservation code cannot be null");
        }
    }
}
