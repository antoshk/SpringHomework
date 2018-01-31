package com.gmail.shelkovich.anton.service.model.dto;

import com.gmail.shelkovich.anton.repository.model.Role;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class UserDTO {

    private Long id;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    @Size(max=25, message = "{eg.user.tooLongUsername}")
    private String username;

    @Size(min=6, max=25, message = "{reg.user.passwordNotInRange}")
    private String password;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String confirmPassword;

    private Role role;
    private List<DocumentDTO> documents = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }
}
