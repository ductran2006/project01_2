package org.comit.sourse.userService;

import java.util.List;

import org.comit.sourse.bean.User;
import org.comit.sourse.useDao.Userdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private Userdao dao;

	public Page<User> listAll(int pageNumber) {
	   
	    Pageable pageable = PageRequest.of(pageNumber-1, 5);
	     
	    return dao.findAll(pageable);
	}
	
	public void save(User user) {
		dao.save(user);
	}

	public User get(int id) {
		return dao.findById(id).get();
	}

	public void delete(int id) {
		dao.deleteById(id);
	}

}
