package concepts.fluentbuilder;

public class PersonAddressBuilder extends PersonBuilder<PersonAddressBuilder>{

    public PersonAddressBuilder(Person person){
        this.person = person;
    }

    public PersonAddressBuilder address1(String addr1){
        person.setAddress1(addr1);
        return self();
    }

    public PersonAddressBuilder address2(String addr2){
        person.setAddress2(addr2);
        return self();
    }

    @Override
    public PersonAddressBuilder self() {
        return super.self();
    }
}
