package org.spira.samples.repository.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class TestAudioEntity extends PanacheMongoEntity {
    private byte[] data;
}
