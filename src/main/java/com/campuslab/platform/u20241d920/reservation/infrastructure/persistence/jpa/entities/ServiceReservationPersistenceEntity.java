package com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.entities;

import com.campuslab.platform.u20241d920.reservation.domain.model.valueobjects.ReservationStatus;
import com.campuslab.platform.u20241d920.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "service_contract")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceReservationPersistenceEntity extends AuditableAbstractPersistenceEntity {
    @Column(name = "reservation_code", nullable = false, unique = true)
    private String reservationCode;

    @Column(name = "laboratory_id", nullable = false)
    private UUID laboratoryId;

    @Column(name = "reservation_period_start_date", nullable = false)
    private LocalDate reservationPeriodStartDate;

    @Column(name = "reservation_period_end_date", nullable = false)
    private LocalDate reservationPeriodEndDate;

    @Column(name = "equipment_batch_quantity", nullable = false)
    private Integer equipmentBatchQuantity;

    @Column(name = "equipment_batch_unit", nullable = false)
    private String equipmentBatchUnit;

    @Column(name = "access_level", nullable = false)
    private Integer accessLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    @Column(name = "reservation_notes")
    private String reservationNotes;
}

