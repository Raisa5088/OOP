package Task5.java;

import java.util.Collection;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        StudentStream stream = new StudentStream(1);

        StudentGroup group1 = new StudentGroup("Group 1", 20);
        StudentGroup group2 = new StudentGroup("Group 2",  15);
        StudentGroup group3 = new StudentGroup("Group 3",10);
        
    }
    Stream.addGroup(group1);
    Stream.addGroup(group2);
    Stream.addGroup(group3);

    for (StudentGroup group : stream){
        System.out.println(group);
    }

    Collection.sort(Stream.getGroups());

    for (StudentGroup group : stream){
        System.out.println(group);
    }
}
