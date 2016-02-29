package com.funfit.usjr.thesis.backend.data.dao.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Users;

/**
 * 
 * @author victor
 *
 */
@Transactional
public interface UserDao extends GenericDao<Users>{
	public boolean checkEmail(String email);
	public List<Users> index();
	public List<Users> filterWorld();
}