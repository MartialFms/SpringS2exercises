package fr.fms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.fms.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public List<User> findAll();
	public Page<User> findByLoginContains(String login, Pageable pageable);
	public void deleteById(Long id);
	
	@Modifying
	@Transactional
	@Query("update User u set u.adminRight= :a where u.id= :id")
	public void updateUserRight(@Param("a")boolean adminRight,@Param("id")long id);

}
