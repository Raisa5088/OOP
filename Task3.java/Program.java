package Task3.java;

import java.util.Random;

public class Program {

    static Random random =new Random ();


    static Worker generateEmployee(){
        String[] names = new String[] {" Анатолий ", " Глеб" , "Клим", " Мартин", "Владен", "Клим", "Панкратий",}
        String[] surnames = new String[]{ " Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирбков", "Копылов",}
        int salary = random.nextInt(origin:20000, bound:80000);
        return new Worker(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)]salary);

    }
    public static void main (String[] args){
       Employee[] employees = new Employee[10];
       for (int i =0; i< employees.length; i++){

       }
       Arrays.sort(employees);
       
       for(Employee employees : employees){
        System.out.println(employees);
       }

    

}
