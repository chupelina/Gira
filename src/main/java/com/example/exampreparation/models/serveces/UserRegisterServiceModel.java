package com.example.exampreparation.models.serveces;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterServiceModel {
    @Length(min =3, max =20, message = "Username must be between 3 and 20 characters!")
    @NotBlank
    private String username;
    @Email(message = "Email cannot be empty")
    @NotBlank
    private String email;
    @Length(min =3, max =20, message = "Password must be between 3 and 20 characters!")
    @NotBlank
    private String password;
    @Length(min =3, max =20, message = "Password must be between 3 and 20 characters!")
    @NotBlank
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterServiceModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
