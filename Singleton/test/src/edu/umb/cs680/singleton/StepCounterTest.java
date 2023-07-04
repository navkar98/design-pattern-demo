package edu.umb.cs680.singleton;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.singleton.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class StepCounterTest {
    @Test
    public void checkNonNullInstance(){
        StepCounter step = StepCounter.getInstance();
        assertNotNull( step );
    }

    @Test
    public void checkMultipleInstanceHashCodeUsingAssertEquals(){
        StepCounter step1 = StepCounter.getInstance();
        StepCounter step2 = StepCounter.getInstance();
        assertEquals(step1.hashCode(),step2.hashCode() );
    }

    @Test
    public void checkMultipleInstanceHashCodeUsingAssertSame(){
        StepCounter step1 = StepCounter.getInstance();
        StepCounter step2 = StepCounter.getInstance();
        assertSame(step1,step2);
    }
}
