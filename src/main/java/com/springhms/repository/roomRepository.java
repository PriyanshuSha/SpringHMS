package com.springhms.repository;

import org.springframework.stereotype.Repository;
import com.springhms.model.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface roomRepository extends JpaRepository<room,Integer> {
   
	@Query(value="select * from room where room_id=?1",nativeQuery=true)
	room findByRoomId(int roomid);
	
}
