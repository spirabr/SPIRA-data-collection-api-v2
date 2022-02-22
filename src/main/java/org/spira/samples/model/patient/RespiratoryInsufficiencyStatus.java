package org.spira.samples.model.patient;

import java.util.Optional;

public enum RespiratoryInsufficiencyStatus {
    TRUE, FALSE;

    public static Optional<RespiratoryInsufficiencyStatus> fromString(String string) {
        for (RespiratoryInsufficiencyStatus type: values()) {
            if (string.equalsIgnoreCase(type.name())) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}
