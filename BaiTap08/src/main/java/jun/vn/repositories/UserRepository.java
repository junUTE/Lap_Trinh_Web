package jun.vn.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import jun.vn.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	List<User> findByUserNameContaining(String userName);
	
	org.springframework.data.domain.Page<User> findByUserNameContaining(String name, Pageable pageable);
    Optional<User> findByUserName(String name);
}
