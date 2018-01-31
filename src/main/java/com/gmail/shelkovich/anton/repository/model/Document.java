package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_document")
public class Document implements Serializable {
    private static final long serialVersionUID = 8940989715379109775L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Long id;
    @Column(name = "f_body")
    private String body;

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
}
