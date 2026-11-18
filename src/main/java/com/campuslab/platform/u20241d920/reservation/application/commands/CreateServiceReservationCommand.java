package com.campuslab.platform.u20241d920.reservation.application.commands;

import java.time.LocalDate;

public record CreateServiceReservationCommand(
        String reservationCode,
        String laboratoryId,
        LocalDate periodStartDate,
        LocalDate periodEndDate,
        Integer equipmentQuantity,
        String equipmentUnit,
        Integer accessLevel,
        String status,
        String reservationNotes
) {
}
