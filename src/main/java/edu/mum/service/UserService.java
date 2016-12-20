package edu.mum.service;

import java.util.List;
import java.util.Set;

import edu.mum.domain.User;
 
public interface UserService {

	public void save(User member);
	public void update(User member);
   	public void saveFull( User member);  		

	public List<User> findAll();
	public User findByMemberNumber(Integer memberId);

	public User findOne(Long id);
	public User findOneFull(Long id);
	
	public List<User> findAllJoinFetch();
	public List<User> findByGraph();
		
}
