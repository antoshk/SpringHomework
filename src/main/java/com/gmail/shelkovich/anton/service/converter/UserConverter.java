package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Document;
import com.gmail.shelkovich.anton.repository.model.User;
import com.gmail.shelkovich.anton.service.model.dto.DocumentDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;

public class UserConverter {

    public static UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setRole(user.getRole());
        userDTO.setPassword(user.getPassword());
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        for(Document document: user.getDocuments()){
            userDTO.getDocuments().add(DocumentConverter.toDTO(document));
        }
        return userDTO;
    }

    public static User fromDTO(UserDTO userDTO){
        User user = new User();
        user.setRole(userDTO.getRole());
        user.setPassword(userDTO.getPassword());
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        for(DocumentDTO documentDTO: userDTO.getDocuments()){
            user.getDocuments().add(DocumentConverter.fromDTO(documentDTO));
        }
        return user;
    }
}
