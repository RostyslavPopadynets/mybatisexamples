package nl.capaxit.mybatisexamples.common.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamiecraane on 27/06/16.
 */
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Address> addresses = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void addAddress(final Address address) {
        addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", addresses='").append(getAddresses()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
