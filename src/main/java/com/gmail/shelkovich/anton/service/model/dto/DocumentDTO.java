package com.gmail.shelkovich.anton.service.model.dto;

import javax.validation.constraints.Size;

public class DocumentDTO {

    private Long id;
    @Size(min=1, max=250)
    private String body;

    @Size(min=1, max=250)
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
