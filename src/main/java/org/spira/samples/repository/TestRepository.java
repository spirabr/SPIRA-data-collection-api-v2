package org.spira.samples.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.spira.samples.model.audio.TestAudio;

public class TestRepository implements PanacheMongoRepository<TestAudio> {

    public TestAudio saveTestAudio(TestAudio testAudio) {
        persist(testAudio);
        return testAudio;
    };
}
