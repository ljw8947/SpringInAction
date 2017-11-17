package spittr;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jwlv on 2017/11/7.
 */
public class Spitter {
    private Long id;

    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;

    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;

    @NotNull
    //@Size(min=2, max=30, message="{firstName.size}")
    @Size(min=2, max=30, message="First name must be between {min} and {max} characters long.from code")
    private String firstName;

    @NotNull(message="not null")
    @Size(min=2, max=30, message="{lastName.size}")
    private String lastName;

    @NotNull(message="not null")
    @Email(message="{email.valid}")
    @NotEmpty(message="not empty")
    private String email;

    public String getEmail() {
        return email;
    }

    public Spitter setEmail(String email) {
        this.email = email;
        return this;
    }



    public Long getId() {
        return id;
    }

    public Spitter setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Spitter setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Spitter setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Spitter setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Spitter setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Spitter() {}

    public Spitter(
            @NotNull @javax.validation.constraints.Size(min = 5, max = 16) String username,
            @NotNull @javax.validation.constraints.Size(min = 5, max = 25) String password,
            @NotNull @javax.validation.constraints.Size(min = 2, max = 30) String firstName,
            @NotNull @javax.validation.constraints.Size(min = 2, max = 30) String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Long id,
                   @NotNull @javax.validation.constraints.Size(min = 5, max = 16) String username,
                   @NotNull @javax.validation.constraints.Size(min = 5, max = 25) String password,
                   @NotNull @javax.validation.constraints.Size(min = 2, max = 30) String firstName,
                   @NotNull @javax.validation.constraints.Size(min = 2, max = 30) String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password", "email");
    }
}
