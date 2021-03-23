package favourite.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepository extends MongoRepository<favourite.model.ExtendedDataBlock, String>{

}
