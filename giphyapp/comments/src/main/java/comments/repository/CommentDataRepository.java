package comments.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import comments.model.ExtendedCommentBlock;



@Repository
public interface CommentDataRepository extends MongoRepository<ExtendedCommentBlock, String>{

	@Query("{'userID' : ?0}")
	List<ExtendedCommentBlock> findCommentsByUserId(String userId);
	@Query("{'gifID' : ?0}")
	List<ExtendedCommentBlock> findCommentsByGifId(String gifId);
}

