package concepts.fluentbuilder;

public class PersonBuilder<SELF extends PersonBuilder<SELF>> {

    protected Person person = new Person();


    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public SELF firstName(String firstName){
        person.setFirstName(firstName);
        return self();
    }

    public SELF middleName(String middleName){
        person.setMiddleName(middleName);
        return self();
    }

    public SELF lastName(String lastName){
        person.setLastName(lastName);
        return self();
    }

    public SELF address(String address){
        person.setAddress(address);
        return self();
    }

    public Person build(){
        return person;
    }


    public SELF self(){
        return (SELF) this;
    }


}
