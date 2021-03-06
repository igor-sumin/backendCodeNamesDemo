package com.netcracker.repositories;

import com.netcracker.entities.Room;
import com.netcracker.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomRef(String roomRef);

    @Query(
        value = "select count(*) from rooms",
        nativeQuery = true)
    int countRooms();

    @Query(
        value = "select * from rooms limit 1 offset :room",
        nativeQuery = true)
    Room findRandRoom(int room);
}
