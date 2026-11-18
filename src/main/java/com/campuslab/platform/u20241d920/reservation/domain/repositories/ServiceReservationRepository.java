package com.campuslab.platform.u20241d920.reservation.domain.repositories;

import com.campuslab.platform.u20241d920.reservation.domain.model.aggregates.EquipmentReservation;

public interface ServiceReservationRepository {
    EquipmentReservation save(EquipmentReservation equipmentReservation);
    boolean existByReservationCode(String code);
}
