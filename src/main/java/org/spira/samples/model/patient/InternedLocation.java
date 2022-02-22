package org.spira.samples.model.patient;

import java.util.Optional;

public enum InternedLocation {
    NURSERY, ICU;

    public static Optional<InternedLocation> fromString(String string) {
        for (InternedLocation type: values()) {
            if (string.equalsIgnoreCase(type.name())) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}
