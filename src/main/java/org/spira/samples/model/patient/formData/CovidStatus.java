package org.spira.samples.model.patient.formData;

import java.util.Optional;

/**
 * Indicates whether patient had covid
 */
public enum CovidStatus {

    TRUE, FALSE, UNKNOWN;

    public static Optional<CovidStatus> fromString(String string) {
        for (CovidStatus type: values()) {
            if (string.equalsIgnoreCase(type.name())) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}
