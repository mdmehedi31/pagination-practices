package com.practices.services;


import com.practices.entity.UserEntity;
import com.practices.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Page<UserEntity> getAllUsers(Pageable pageable) {
     return this.userRepository.findAll(pageable);
    }

    public Page<UserEntity> getAllUsers(Pageable pageable, String search) {
        return this.userRepository.getAllUserAndFilter(search,pageable);
    }

}
