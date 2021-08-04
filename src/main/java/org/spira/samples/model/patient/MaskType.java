package org.spira.samples.model.patient;

import java.util.Optional;

public enum MaskType {
    NONE, THIN, THICK;

    public static Optional<MaskType> fromString(String string) {
        for (MaskType type: values()) {
            if (string.equalsIgnoreCase(type.name())) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}
