package com.practices.services;


import com.practices.dto.UserDTO;
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

    public Page<UserDTO> getAllUsers(Pageable pageable, String search) {
        return this.userRepository.getAllUserAndFilter(search,pageable).map(user -> new UserDTO(user.getId(), user.getUsername(), user.getEmail(),
                user.getPhone(), user.getAge(), user.getGender(),user.getUserAddress()));
    }

}
