package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.User;
import com.example.taskmanager.repositories.pojo.GetUserPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT name," +
            " username," +
            " email," +
            " department," +
            " created_on," +
            " user_status" +
            " FROM task_manager.users",nativeQuery = true)
    Page<GetUserPojo> getUsersList(Pageable pageable);



}
