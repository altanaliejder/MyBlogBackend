package com.example.myblog.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","stories"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username",unique = true,nullable = false)
    @NotNull
    @NotBlank
    private String username;


    @Column(name = "email",unique = true,nullable = false)
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Column(name = "password",nullable = false)
    @NotNull
    @NotBlank
    @Length(min = 4)
    private String password;

    @Column(name = "name",nullable = false)
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "surname",nullable = false)
    @NotNull
    @NotBlank
    private String surname;

    @OneToMany(mappedBy = "user")
    private List<Story> stories;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
