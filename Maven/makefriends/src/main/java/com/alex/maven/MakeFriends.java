package com.alex.maven;

public class MakeFriends {
    public String makeFriends(String name){
        HelloFriend friend = new HelloFriend();
        friend.sayHelloToFriend("Amy");
        String str = "Hey, " + friend.getMyName() + " make a friend please.";
        System.out.println(str);
        return str;
    }
}
