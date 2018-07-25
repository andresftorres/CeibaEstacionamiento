package org.gradle;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
    }
}
