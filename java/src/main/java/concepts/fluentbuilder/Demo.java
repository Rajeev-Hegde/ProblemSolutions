package concepts.fluentbuilder;

public class Demo {

    public static void main(String[] args) {

        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Person person = employeeBuilder.firstName("Rajeev").middleName(null).lastName("Hegde").address("Bangalore").worksAt("Sprinklr").build();
        System.out.println(person.getMiddleName());
    }
}
