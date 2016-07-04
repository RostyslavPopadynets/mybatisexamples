package nl.capaxit.mybatisexamples.common.mappers;

import nl.capaxit.mybatisexamples.common.domain.Document;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jamiecraane on 30/06/16.
 */
public interface DocumentMapper {
    void insertDocument(@Param("json") String json);

    List<Document> retrieveAll();
}
