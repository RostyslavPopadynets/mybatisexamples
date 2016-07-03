package nl.capaxit.mybatisexamples.mappers;

import nl.capaxit.mybatisexamples.domain.Custom;

import java.util.List;

/**
 * Created by jamiecraane on 03/07/16.
 */
public interface CustomMapper {
    List<Custom> retrieveAll();
}
