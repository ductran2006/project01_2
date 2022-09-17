package org.comit.sourse.useDao;

import java.util.List;

import org.comit.sourse.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Userdao extends JpaRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE CONCAT(u.firstname, ' ', u.lastname, ' ', u.username, ' ', u.id) LIKE %?1%")
	public List<User> findAll(String keyword);
	
	
	/*
	 * @Query("SELECT p FROM User p WHERE CONCAT(p.id,' ', p.firstname, ' ', p.lastname, ' ', p.username,"
	 * + " ' ', p.password, ' ', p.address,' ', p.phone, ' ', p.email) LIKE %?1%")
	 * public Page<User> findAll(String keyword, Pageable pageable);
	 */
}
