package nl.capaxit.mybatisexamples.repository;

import nl.capaxit.mybatisexamples.domain.Person;
import nl.capaxit.mybatisexamples.mappers.PersonMapper;

import java.util.List;

/**
 * Created by jamiecraane on 27/06/16.
 */
public class PersonRepository {
    private PersonMapper personMapper;

    public List<Person> retrieveAll(final int fetchSize) {
        return personMapper.retrieveAll(fetchSize);
    }
}
