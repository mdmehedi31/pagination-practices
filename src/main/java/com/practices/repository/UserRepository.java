package com.practices.repository;

import com.practices.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    @Query("""
    select u from users  u where :searchCriteria is null or :searchCriteria ='' or\s 
     lower(u.username) like concat('%',lower(:searchCriteria),'%')\s
    or lower(u.email) like concat('%',lower(:searchCriteria),'%' )\s
    or lower(u.gender) like concat('%',lower(:searchCriteria),'%')\s
    or lower(u.username) like concat('%',lower(:searchCriteria),'%')\s
    or lower(u.phone) like concat('%',lower(:searchCriteria),'%')\s
    or cast(u.age as string ) like concat('%',lower(:searchCriteria),'%')\s 
""")
    Page<UserEntity> getAllUserAndFilter(String searchCriteria, Pageable pageable);
}
