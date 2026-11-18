package com.campuslab.platform.u20241d920.shared.domain.model.valueobjects;

public record EquipmentBatch(Integer quantity, String unit) {

    public EquipmentBatch {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Unit cannot be null or blank");
        }
    }

    public EquipmentBatch addUnits(Integer additionalQuantity) {
        if (additionalQuantity == null || additionalQuantity <= 0) {
            throw new IllegalArgumentException("Additional quantity must be greater than zero");
        }
        if ((long) this.quantity + additionalQuantity > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Total quantity cannot exceed Integer.MAX_VALUE");
        }
        return new EquipmentBatch(this.quantity + additionalQuantity, this.unit);
    }
}

