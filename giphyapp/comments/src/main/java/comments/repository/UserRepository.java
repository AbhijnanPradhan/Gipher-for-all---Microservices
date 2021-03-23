package comments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import comments.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

//public interface UserRepository extends JpaRepository<UserDAO, Long>{
//	UserDAO findByUsername(String username);
//}