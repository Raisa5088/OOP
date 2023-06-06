package Task3.java;

public class Worker extends Employee {
    public Worker(String name, String surname, double salary){
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary(){
        return salary; 
    }

    @Override
    public String toString(){
        return String.format(""%s %s"; Рабочий; Среднемесячная заработной плата (фиксированная месячная оплата):%.2f (руб)"),
        surname, name, calculateSalary());
    }


    def __init__(self, name='Petr', surname='Vasechkin', position='singer', wage=100, bonus=20);
    this.name = name;
    this.surname = surname;
    this.position = position;
    tjis.income = {'wage': wage, 'bonus': bonus};


    def get_full_name(self);
    return self.name + ' ' + self.surname;

    def get_full_salary(self);
    return self._income['wage'] + self._income['bonus'];


    v_pet = Position('Vasilii', 'Petechkin', 'dancer', 110, 30);
    return(f'New attributes are: {v_pet.name}, {v_pet.surname}, {v_pet.position}, {v_pet._income}');
    return(f'Total salary of {v_pet.get_full_name()} is {v_pet.get_full_salary()}');
}

