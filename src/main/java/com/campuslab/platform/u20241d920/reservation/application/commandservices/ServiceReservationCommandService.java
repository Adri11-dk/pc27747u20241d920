package com.campuslab.platform.u20241d920.reservation.application.commandservices;

import com.campuslab.platform.u20241d920.reservation.application.commands.CreateServiceReservationCommand;
import com.campuslab.platform.u20241d920.reservation.domain.model.aggregates.EquipmentReservation;

public interface ServiceReservationCommandService {
    EquipmentReservation handle(CreateServiceReservationCommand command);
}
