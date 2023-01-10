package utm.fcim.cursdb.repository;

import org.springframework.data.repository.CrudRepository;
import utm.fcim.cursdb.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
