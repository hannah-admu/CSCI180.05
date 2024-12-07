package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//this isnt in our specs i just thought itd be useful to have 
	User findByid(Long id);
    User findByIdNumber(Double idNumber);
    List<User> findByUsername(String username);

}
