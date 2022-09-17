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

	public List<User> ListAll(String keyword) {
		if (keyword != null)
			return dao.findAll(keyword);
		return dao.findAll();
	}

	/*
	 * public Page<User> listAll(int pageNum, String sortField, String sortDir) {
	 * int pageSize = 5; Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
	 * sortDir.equals("asc") ? Sort.by(sortField).ascending() :
	 * Sort.by(sortField).descending() );
	 * 
	 * return dao.findAll(pageable); }
	 */

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
