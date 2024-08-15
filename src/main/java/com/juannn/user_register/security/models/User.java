package com.juannn.user_register.security.models;

import jakarta.persistence.*;

import java.util.Collection;


@Entity
@Table(name="users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_rol",
            joinColumns = @JoinColumn(
                            name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Rol_id", referencedColumnName = "id")
            )
    private Collection<Role> roles;

    public User() {
    }

    public User(Collection<Role> roles, String password, String email, String lastName, String name) {
        this.roles = roles;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
    }

    public User(Long id, String name, String lastName, String email, String password, Collection<Role> roles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
