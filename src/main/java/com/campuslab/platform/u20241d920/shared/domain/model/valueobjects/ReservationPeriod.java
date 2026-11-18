package com.campuslab.platform.u20241d920.shared.domain.model.valueobjects;

import java.time.LocalDate;

public record ReservationPeriod(LocalDate startDate, LocalDate endDate) {
    public ReservationPeriod {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }
        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be greater than start date");
        }
    }

    public boolean isExpired(LocalDate checkDate) {
        if (checkDate == null) {
            throw new IllegalArgumentException("Check date cannot be null");
        }
        return checkDate.isAfter(endDate);
    }
}
