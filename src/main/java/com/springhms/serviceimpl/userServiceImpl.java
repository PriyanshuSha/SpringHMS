package com.springhms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springhms.dto.userDto;
import com.springhms.exception.globalException;
import com.springhms.model.user;
import com.springhms.repository.userRepository;
import com.springhms.service.userService;
import com.springhms.util.valueMapper;

@Service
public class userServiceImpl implements userService {

    @Autowired
	private userRepository userrepo;  
	
	
	@Override
	public user addUser(userDto u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);
		
	}

	@Override
	public List<user> getUser() {
		return userrepo.findAll();
		
	}

	@Override
	public user updateUser(userDto u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);
		
	}

	@Override
	public String deleteUser(int userid) throws globalException {
		user u2=userrepo.findByUserId(userid);
		if(u2!=null) {
			userrepo.deleteById(userid);
			return "deleted";
		}
		else {
			throw new globalException("user not found");
		}
	}

	@Override
	public String updatePhone(int userid, String phone) throws globalException {
		int st=userrepo.updatePhone(userid, phone);
		if(st==1) {
			return "updated!...";
		}
		else {
			throw new globalException("something went wrong");
		}
	}

	@Override
	public String allotRoom(int userid, int roomid) throws globalException {
		int st=userrepo.allotRoom(userid, roomid);
		if(st==1) {
			return "Room Alloted to "+userid;
		}
		else {
			throw new globalException("something went wrong");
		}
	}

	@Override
	public String login(int userid, String userName, String userPassword) throws globalException {
	    
		user u1= userrepo.findByUserId(userid);
		if(u1!=null) {
			
			if(u1.getUserName().equals(userName)) {
				
				if(u1.getUserPassword().equals(userPassword)) {
					return "Login Successfull MR. " + u1.getUserName();
				}
				else
					throw new globalException("Password not mattched ");
				
			}
			else
				throw new globalException("userName not found ");
			
		}
		else
			  throw new globalException("user not found ");
		
	}

}
