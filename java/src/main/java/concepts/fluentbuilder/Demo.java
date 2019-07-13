package concepts.fluentbuilder;

public class Demo {

    public static void main(String[] args) {

        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Person person = employeeBuilder.firstName("Rajeev").middleName(null)
                .worksAt("Sprinklr")
                .lastName("Hegde")
                .lives()
                    .address1("Chinnapana halli")
                    .address2("Marathahalli")
                .address("Bangalore").build();
        System.out.println(person.getMiddleName());
        System.out.println(person.getPosition());
    }
}
