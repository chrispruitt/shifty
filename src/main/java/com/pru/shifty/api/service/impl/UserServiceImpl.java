package com.pru.shifty.api.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.pru.shifty.api.service.UserService;
import com.pru.shifty.api.util.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pru.shifty.api.model.User;


//I cheated a lot here to allow the USER API to work without an actual data source
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    //For test data population
	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User get(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User getByUsername(String username) {
		for(User user : users){
			if(user.getUsername().equalsIgnoreCase(username)){
				return user;
			}
		}
		return null;
	}

    //normally I would let the datasource control the index, but is just to generate dummy users
	public User create(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
        return user;
	}

	public void update(long id, User userToUpdate) {
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                userToUpdate.setId(id);
                users.add(userToUpdate);
                return;
            }
        }
	}

	public void delete(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return getByUsername(user.getUsername())!=null;
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Sam", "sam", Role.ADMIN));
		users.add(new User(counter.incrementAndGet(),"Tom", "tom", Role.RESIDENT));
		users.add(new User(counter.incrementAndGet(),"Jerome", "jerome", Role.RESIDENT));
		users.add(new User(counter.incrementAndGet(),"Silvia", "silvia", Role.RESIDENT));
		return users;
	}

}
