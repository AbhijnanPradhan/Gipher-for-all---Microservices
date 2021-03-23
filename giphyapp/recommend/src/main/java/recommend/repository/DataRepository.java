package recommend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import recommend.model.ExtendedDataBlock;




@Repository
public interface DataRepository extends MongoRepository<ExtendedDataBlock, String>{

}
