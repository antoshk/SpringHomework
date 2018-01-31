package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.impl.UserDao;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Transactional(readOnly = true)
    public UserDTO getByUsername(String username){
        return UserConverter.toDTO(userDao.getByUsername(username));
    }

}
