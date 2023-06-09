package Task5.java;

public class StudentGroup  implements Comparable<StudentGroup>{
    private String name;
    private int numberOfStudent;

    public StudentGroup(String name, int numberOfStudent){
        this.name = name;
        this.numberOfStudent = numberOfStudent;
    }

    public Sting getName(){
        return name;
    }

    public int getNumberOfStudent(){
        return numberOfStudent;
    }

    public int compareIo(StudentGroup othGroup){
        return Integer.compare(this.numberOfStudent, othGroup.numberOfStudent);

    }

    public String toString(){
        return "Group" + name"("+ numberOfStudent" +" students)";
        
    }
}
