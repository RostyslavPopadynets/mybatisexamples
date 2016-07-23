package nl.capaxit.mybatisexamples.common.mappers;

import nl.capaxit.mybatisexamples.common.domain.Address;
import nl.capaxit.mybatisexamples.common.domain.Person;
import nl.capaxit.mybatisexamples.demos.dynamic.SearchSpec;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;

/**
 * Created by jamiecraane on 27/06/16.
 */
public interface PersonMapper {
    List<Person> retrieveAll(@Param("fetchSize") int fetchSize);

    List<Person> retrieveAllPersons(ResultHandler<Person> resultHandler);

    List<Person> retrieveAllIncludingAddresses();

    List<Person> find(@Param("searchSpec") SearchSpec searchSpec);

    void insert(@Param("person") Person person);

    void insertAddress(@Param("address") Address address, @Param("personId") Long personId);

    void delete(@Param("personId") Long id);
}
