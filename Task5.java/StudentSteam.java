package Task5.java;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentSteam implements Iterable<StudentGroup> {
    private int sreamNumber;

    private List<StudentGroup> groups;

    public StudentSteam(int streamNumber){
        this.sreamNumber=streamNumber;

        this.groups = new ArrayList<>();
    }

    public void addGroup(StudentGroup groups){
        this.groups.add(groups);
    }

    public int getStreamNumber(){
        return streamNumber;
    }

    public List<StudentGroup> getGroups(){
        return groups;
    }

    public Iterator<StudentGroup> iterator(){
        return groups.iterator();
    }
}

