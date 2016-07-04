package nl.capaxit.mybatisexamples.common.mappers;

import nl.capaxit.mybatisexamples.common.domain.Product;

import java.util.List;

/**
 * Created by jamiecraane on 01/07/16.
 */
public interface ProductMapper {
    List<Product> retrieveAll();
}
