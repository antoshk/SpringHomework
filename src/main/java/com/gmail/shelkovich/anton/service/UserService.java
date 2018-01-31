package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.impl.UserDao;
import com.gmail.shelkovich.anton.repository.model.User;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.dto.DocumentDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Transactional(readOnly = true)
    public UserDTO getCurrentUser(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return getByUsername(userDetails.getUsername());
    }

    @Transactional(readOnly = true)
    public boolean isCurrentUserDocOwner(Long id){
        for(DocumentDTO doc: getCurrentUser().getDocuments()){
            if(doc.getId().equals(id)) return true;
        }
        return false;
    }

    @Transactional
    public void updateUser(User user){
        userDao.update(user);
    }


}
