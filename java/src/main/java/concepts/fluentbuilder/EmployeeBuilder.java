package concepts.fluentbuilder;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {

    public EmployeeBuilder worksAt( String worksAt){
        this.person.setPosition(worksAt);
        return self();
    }

    @Override
    public EmployeeBuilder middleName(String middleName) {
        if(middleName == null)
            middleName = "__NA__";
        return super.middleName(middleName);
    }

    @Override
    public EmployeeBuilder self() {
        return this;
    }
}
