package com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.adapters;

import com.campuslab.platform.u20241d920.reservation.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u20241d920.reservation.domain.repositories.ServiceReservationRepository;
import com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.mappers.ServiceReservationPersistenceMapper;
import com.campuslab.platform.u20241d920.reservation.infrastructure.persistence.jpa.repositories.ServiceReservationJpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ServiceReservationPersistenceAdapter implements ServiceReservationRepository {

    private final ServiceReservationJpaRepository repository;

    public ServiceReservationPersistenceAdapter(ServiceReservationJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public EquipmentReservation save(EquipmentReservation equipmentReservation) {
        if (equipmentReservation == null) {
            return null;
        }
        var result = repository.save(ServiceReservationPersistenceMapper.toEntity(equipmentReservation));
        return ServiceReservationPersistenceMapper.toDomain(result);
    }

    @Override
    public boolean existsByReservationCode(String code) {
        return repository.existsByReservationCode(code);
    }
}
