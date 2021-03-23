package gifdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import gifdetails.model.ExtendedDataBlock;


@Repository
public interface DataRepository extends MongoRepository<ExtendedDataBlock, String>{

}
