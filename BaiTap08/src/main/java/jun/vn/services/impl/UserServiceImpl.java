package jun.vn.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import jun.vn.entities.User;
import jun.vn.repositories.UserRepository;
import jun.vn.services.IUserService;

public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	 public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	 
	@Override
	public void deleteAll() {
		userRepository.deleteAll();

	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);

	}

	@Override
	public void deleteById(Long id) {
		 userRepository.deleteById(id);

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		 return userRepository.count();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		 return userRepository.findById(id);
	}

	@Override
	public List<User> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return userRepository.findAllById(ids);
	}

	@Override
	public List<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return userRepository.findAll(sort);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		 return userRepository.save(entity);
	}

	@Override
	public List<User> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		 return userRepository.findByUserNameContaining(name);
	}

	@Override
	public Page<User> findByNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findByUserNameContaining(name, pageable);
	}

	@Override
	public Optional<User> findByUserName(String UserName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(UserName);
	}

}
