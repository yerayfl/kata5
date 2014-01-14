package kata5;

public class Person {

    private String firstName;
    private String lastName;
    private String companyName;
    private String address;
    private String city;
    private String state;
    private Mail mail;
    private String web;

    public Person(String firstName, String lastName, String companyName, String address, String city, String state, Mail mail, String web) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.mail = mail;
        this.web = web;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Mail getMail() {
        return mail;
    }

    public String getWeb() {
        return web;
    }
}
