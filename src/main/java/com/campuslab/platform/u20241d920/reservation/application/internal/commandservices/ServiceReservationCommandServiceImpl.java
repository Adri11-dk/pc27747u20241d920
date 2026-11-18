package com.campuslab.platform.u20241d920.reservation.application.internal.commandservices;

import com.campuslab.platform.u20241d920.reservation.application.commands.CreateServiceReservationCommand;
import com.campuslab.platform.u20241d920.reservation.application.commandservices.ServiceReservationCommandService;
import com.campuslab.platform.u20241d920.reservation.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u20241d920.reservation.domain.model.valueobjects.LaboratoryId;
import com.campuslab.platform.u20241d920.reservation.domain.model.valueobjects.ReservationCode;
import com.campuslab.platform.u20241d920.reservation.domain.model.valueobjects.ReservationStatus;
import com.campuslab.platform.u20241d920.reservation.domain.repositories.ServiceReservationRepository;
import com.campuslab.platform.u20241d920.shared.domain.model.valueobjects.EquipmentBatch;
import com.campuslab.platform.u20241d920.shared.domain.model.valueobjects.ReservationPeriod;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class ServiceReservationCommandServiceImpl implements ServiceReservationCommandService {

    private final ServiceReservationRepository repository;

    public ServiceReservationCommandServiceImpl(ServiceReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public EquipmentReservation handle(CreateServiceReservationCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("command cannot be null");
        }

        UUID laboratoryUuid = UUID.fromString(command.laboratoryId());

        ReservationStatus status = (command.status() == null || command.status().isBlank())
             ? ReservationStatus.PENDING
             : ReservationStatus.valueOf(command.status().toUpperCase());

        var equipmentReservation = new EquipmentReservation(
                new ReservationCode(command.reservationCode()),
                new LaboratoryId(laboratoryUuid),
                new ReservationPeriod(command.periodStartDate(), command.periodEndDate()),
                new EquipmentBatch(command.equipmentQuantity(), command.equipmentUnit()),
                command.accessLevel(),
                status,
                command.reservationNotes()
        );
        return repository.save(equipmentReservation);
    }
}
