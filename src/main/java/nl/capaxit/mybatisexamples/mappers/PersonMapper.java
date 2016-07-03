package nl.capaxit.mybatisexamples.mappers;

import nl.capaxit.mybatisexamples.domain.Person;
import nl.capaxit.mybatisexamples.dynamic.SearchSpec;
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
}
