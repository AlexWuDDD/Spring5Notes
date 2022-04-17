package com.alex.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloTest {
    
    @Test
    public void testHello(){
        Hello hello = new Hello();
        String results = hello.sayHello("alex");
        assertEquals("Hello alex!", results);
    }
}
