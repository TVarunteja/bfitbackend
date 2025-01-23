package com.bfit.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bfit.jfsd.springboot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public User checkUserLogin(String eemail,String epassword);
	
}
