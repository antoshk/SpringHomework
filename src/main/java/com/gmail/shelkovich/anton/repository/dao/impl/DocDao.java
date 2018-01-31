package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.model.Document;
import org.springframework.stereotype.Repository;


@Repository("docDao")
public class DocDao extends GenericDaoImpl<Document, Long> {
    public DocDao() {
        super(Document.class);
    }

}
