package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class UserServiceImpl implements edu.mum.service.UserService {
	
 	@Autowired
	private UserDao memberDao;

 	@Autowired
 	UserCredentialsService credentialsService;

    public void save( User user) {  		
		memberDao.save(user);
	}
	
    public void update( User user) {  		
		memberDao.update(user);
	}
	
    @Override
   	public void saveFull( User user) {  		
  		credentialsService.save(user.getUserCredentials());
  		memberDao.save(user);
	}
  	

	public List<User> findAll() {
		List<User> users = (List<User>)memberDao.findAll();
		for(User user : users)
			System.out.println("List of user displayed !! "+user.getFirstName() );
		return (List<User>)memberDao.findAll();
	}

	public User findByMemberNumber(Integer memberId) {
		return memberDao.findByMemberNumber(memberId);
	}
 
	public User findOne(Long id) {
		System.out.println("Inside memberservice method : " + id);
		return memberDao.findOne(id);
	}
	
	public User findOneFull(Long id) {
		User user = this.findOne(id);
		
// OR 		"SELECT p FROM Member m JOIN FETCH m.userCredentials WHERE m.id = (:id)"
		user.getUserCredentials();
		
		return  user;
	}
	
	public List<User> findAllJoinFetch() {
		return memberDao.findAllJoinFetch();
	}
	
 	@Override
	public List<User> findByGraph() {
		return  memberDao.findByGraph();
	}

}
