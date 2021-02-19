package com.example.exampreparation.models.serveces;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLoginModel {
    @Email(message = "Email cannot be empty")
    @NotBlank
    private String email;
    @Length(min =3, max =20, message = "Password must be between 3 and 20 characters!")
    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLoginModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
