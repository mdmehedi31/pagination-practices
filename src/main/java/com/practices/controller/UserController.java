package com.practices.controller;


import com.practices.dto.UserDTO;
import com.practices.entity.UserEntity;
import com.practices.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    private UserService userService;
    private static final Logger log=LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/get-all-users")
    public ResponseEntity<Page<UserEntity>> getAllUsers(@RequestParam("pageNo") Integer pageNo,
                                                        @RequestParam("pageSize") Integer pageSize,
                                                        @RequestParam(value = "sort", required = false)  String sortColumn ) {

        String sortColumnName ="id";

        if(sortColumn !=null && !sortColumn.isBlank()){
            sortColumnName =sortColumn.toLowerCase();
        }

        log.info("Sort column: "+sortColumnName);
        Sort sort = Sort.by(sortColumnName);

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        log.info("Pageable value is : {}", pageable);
        Page<UserEntity> users = userService.getAllUsers(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping("/get-all-users-filter")
    public ResponseEntity<Page<UserDTO>> getAllUsers(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                        @RequestParam(value = "sort", defaultValue = "id")  String sortColumn,
                                                        @RequestParam(value = "search", required = false) String search ) {



        log.info("Sort column: "+sortColumn);
        Sort sort = Sort.by(sortColumn);

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        log.info("Pageable value is : {}, search criteria : {}", pageable, search);
        Page<UserDTO> users = userService.getAllUsers(pageable,search);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
