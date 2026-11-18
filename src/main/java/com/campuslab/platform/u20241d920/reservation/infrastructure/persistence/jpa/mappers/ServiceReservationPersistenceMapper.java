package com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.mappers;

import com.campuslab.platform.u20241d920.reservation.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u20241d920.reservation.domain.model.valueobjects.LaboratoryId;
import com.campuslab.platform.u20241d920.reservation.domain.model.valueobjects.ReservationCode;
import com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.entities.ServiceReservationPersistenceEntity;
import com.campuslab.platform.u20241d920.shared.domain.model.valueobjects.EquipmentBatch;
import com.campuslab.platform.u20241d920.shared.domain.model.valueobjects.ReservationPeriod;

public class ServiceReservationPersistenceMapper {

    public static EquipmentReservation toDomain(ServiceReservationPersistenceEntity entity) {
        return new EquipmentReservation(
                entity.getId(),
                new ReservationCode(entity.getReservationCode()),
                new LaboratoryId(entity.getLaboratoryId()),
                new ReservationPeriod(entity.getReservationPeriodStartDate(), entity.getReservationPeriodEndDate()),
                new EquipmentBatch(entity.getEquipmentBatchQuantity(), entity.getEquipmentBatchUnit()),
                entity.getAccessLevel(),
                entity.getStatus(),
                entity.getReservationNotes()
        );
    }

    public static ServiceReservationPersistenceEntity toEntity(EquipmentReservation reservation) {
        return ServiceReservationPersistenceEntity.builder()
                .reservationCode(reservation.getReservationCode().code())
                .laboratoryId(reservation.getLaboratoryId().value())
                .reservationPeriodStartDate(reservation.getReservationPeriod().startDate())
                .reservationPeriodEndDate(reservation.getReservationPeriod().endDate())
                .equipmentBatchQuantity(reservation.getEquipmentBatch().quantity())
                .equipmentBatchUnit(reservation.getEquipmentBatch().unit())
                .accessLevel(reservation.getAccessLevel())
                .status(reservation.getStatus())
                .reservationNotes(reservation.getReservationNotes())
                .build();
    }

}
