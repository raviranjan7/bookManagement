package com.ravi.test.data.model;

import javax.persistence.*;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
@Getter
@Setter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Long sid;
    @Column(name = "user_id", nullable = false)
    private String userId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "type", nullable = false)
    private String type;

    public Long getSid() {
        return sid;
    }

    public String getPassword() {
        return password;
    }

    public User(String userId, String name, String email, String password, String type) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }
}
