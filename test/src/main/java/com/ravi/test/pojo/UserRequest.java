package com.ravi.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ravi.test.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private String type;
    public User convertToUser(Long sid, String userId) {
        return new User(sid, userId, this.name, this.email, this.password, this.type);
    }
    public User convertToUser(String userId) {
        return new User(userId, this.name, this.email, this.password, this.type);
    }
}
