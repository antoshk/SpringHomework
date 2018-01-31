package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Document;
import com.gmail.shelkovich.anton.service.model.dto.DocumentDTO;

public class DocumentConverter {
    public static DocumentDTO toDTO(Document document){
        DocumentDTO documentDTO = new DocumentDTO();
        documentDTO.setBody(document.getBody());
        documentDTO.setTitle(document.getTitle());
        documentDTO.setId(document.getId());
        return documentDTO;
    }

    public static Document fromDTO(DocumentDTO documentDTO){
        Document document = new Document();
        document.setBody(documentDTO.getBody());
        document.setId(documentDTO.getId());
        document.setTitle(documentDTO.getTitle());
        return document;
    }
}
