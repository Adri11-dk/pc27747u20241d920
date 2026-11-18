package com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.repositories;

import com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.entities.ServiceReservationPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceReservationJpaRepository extends JpaRepository<ServiceReservationPersistenceEntity, Long> {
    boolean existsByReservationCode(String reservationCode);
}
