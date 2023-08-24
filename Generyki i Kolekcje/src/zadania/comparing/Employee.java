package zadania.comparing;


public class Employee implements Comparable<Employee>{
    private String name;
    private String surname;
    private Integer age;
    private Double salary;
    public Employee(String name, String surname, Integer age, Double salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
        int result = this.name.compareTo(employee.name);
        if (result != 0 ){
            return result;
        }
        result = employee.surname.compareTo(this.surname);
        if (result != 0 ){
            return result;
        }
        result = this.age - employee.age;
        if(result != 0){
            return result;
        }
        return (int)(employee.salary - this.salary);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nname='" + name +", surname='" + surname +", age=" + age + ", salary=" + salary;
    }
}
