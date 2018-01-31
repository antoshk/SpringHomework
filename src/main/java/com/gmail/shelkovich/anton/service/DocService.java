package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.impl.DocDao;
import com.gmail.shelkovich.anton.repository.dao.impl.UserDao;
import com.gmail.shelkovich.anton.service.converter.DocumentConverter;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.dto.DocumentDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Autowired
    @Qualifier("docDao")
    private DocDao docDao;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<DocumentDTO> getDocuments(){
        return userService.getCurrentUser().getDocuments();
    }

    @Transactional(readOnly = true)
    public DocumentDTO getDocById(Long id){
        return DocumentConverter.toDTO(docDao.getById(id));
    }

    @Transactional
    public void addDocument(DocumentDTO document){
        UserDTO user = userService.getCurrentUser();
        user.getDocuments().add(document);
        userService.updateUser(UserConverter.fromDTO(user));
    }

    @Transactional
    public void updateDoc(DocumentDTO document){
        docDao.update(DocumentConverter.fromDTO(document));
    }

    @Transactional
    public void deleteDoc(Long id){
        if(userService.isCurrentUserDocOwner(id)) {
            docDao.delete(id);
        }
    }
}
