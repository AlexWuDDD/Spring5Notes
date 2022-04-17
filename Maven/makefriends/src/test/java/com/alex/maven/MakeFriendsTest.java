package com.alex.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MakeFriendsTest {
    
    @Test
    public void testMakeFriends(){
        MakeFriends makeFriends = new MakeFriends();
        String str = makeFriends.makeFriends("Amy");
        assertEquals("Hey, Alex make a friend please.", str);
    }
}
