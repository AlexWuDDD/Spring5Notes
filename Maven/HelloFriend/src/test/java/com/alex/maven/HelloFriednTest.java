package com.alex.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloFriednTest {
    
    @Test
    public void testHelloFriend(){
        HelloFriend helloFriend = new HelloFriend();
        String results = helloFriend.sayHelloToFriend("Amy");
        assertEquals("Hello Amy! I am Alex", results);
    }
}
