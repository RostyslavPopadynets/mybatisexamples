package nl.capaxit.mybatisexamples.mappers;

import nl.capaxit.mybatisexamples.domain.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jamiecraane on 27/06/16.
 */
public interface PersonMapper {
    List<Person> retrieveAll(@Param("fetchSize") int fetchSize);
}
