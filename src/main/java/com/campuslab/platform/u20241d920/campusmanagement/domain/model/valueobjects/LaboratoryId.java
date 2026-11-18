package com.campuslab.platform.u20241d920.campusmanagement.domain.model.valueobjects;

import java.util.UUID;

public record LaboratoryId(UUID value) {

    public LaboratoryId {
        if (value == null) {
            throw new IllegalArgumentException("LaboratoryId cannot be null");
        }
    }
}
