package com.springhms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springhms.dto.roomDto;
import com.springhms.exception.globalException;
import com.springhms.model.room;
import com.springhms.repository.roomRepository;
import com.springhms.service.roomService;
import com.springhms.util.valueMapper;

@Service
public class roomServiceImpl implements roomService {
	
	@Autowired
	private roomRepository roomrepo;
	
	@Override
	public room addRoom(roomDto r1) {
		room r2=valueMapper.convertoRoom(r1);
		return roomrepo.save(r2);
	}

	@Override
	public List<room> getRoom() {
		return roomrepo.findAll();
	}
	
	@Override
	public room updateRoom(roomDto r1) {
		room r2=valueMapper.convertoRoom(r1);
		return roomrepo.save(r2);	
	}

	@Override
	public String deleteRoom(int roomid) throws globalException {
		room r2=roomrepo.findByRoomId(roomid);
		if(r2!=null) {
			roomrepo.deleteById(roomid);
			return "deleted";
		}
		else {
			throw new globalException("Room Notfound");
		}
	}

}
