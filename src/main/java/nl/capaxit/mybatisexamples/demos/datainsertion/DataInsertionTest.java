package nl.capaxit.mybatisexamples.demos.datainsertion;

import nl.capaxit.mybatisexamples.common.domain.Address;
import nl.capaxit.mybatisexamples.common.domain.Person;
import nl.capaxit.mybatisexamples.common.mappers.PersonMapper;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.DatabaseSetup;
import nl.capaxit.mybatisexamples.infrastructure.mybatis.SessionTemplate;

/**
 * Created by jamiecraane on 23/07/16.
 */
public class DataInsertionTest {
    public static void main(String[] args) {
        new DataInsertionTest().run();
    }

    private void run() {
        new DatabaseSetup().executeScript("db/migration/V1__initial.sql");
        new DatabaseSetup().executeScript("init-db.sql");

        final Person person = getPerson("Jan", "Jansen");
        person.addAddress(getAddress("Amsterdam", "Kerkstraat"));
        person.addAddress(getAddress("Rotterdam", "kerkstraat"));
        person.addAddress(getAddress("Amsterdam", "Kalverstraat"));

        SessionTemplate.executeInTransaction(session -> {
            final PersonMapper personMapper = session.getMapper(PersonMapper.class);
            personMapper.insert(person);
            person.getAddresses()
                    .forEach(
                            address -> session.getMapper(PersonMapper.class)
                                    .insertAddress(address, person.getId()));
            return null;
        });


        final Person retrieved = SessionTemplate.execute(session -> session.getMapper(PersonMapper.class).selectById(person.getId()));
        System.out.println("retrieved = " + retrieved);

        SessionTemplate.executeInTransaction(session -> {
            session.getMapper(PersonMapper.class).delete(person.getId());
            return null;
        });

        System.out.println("Person = " + SessionTemplate.execute(session -> session.getMapper(PersonMapper.class).selectById(person.getId())));
    }

    private Address getAddress(final String city, final String street) {
        final Address address = new Address();
        address.setCity(city);
        address.setStreet(street);
        return address;
    }

    private Person getPerson(final String firstName, final String lastName) {
        final Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }
}
