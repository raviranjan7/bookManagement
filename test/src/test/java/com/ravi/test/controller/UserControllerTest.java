package com.ravi.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ravi.test.utilities.BaseController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.test.data.model.User;
import com.ravi.test.pojo.UserRequest;
import com.ravi.test.services.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest extends BaseController{

  @Autowired
  private MockMvc mockMvc;

  private List<User> userList;

  @MockBean
  private UserService userService;

  private UserRequest userRequest;

  private String jsonRequest;
  private User user;

  @Before
  public void setup() throws Exception {
    this.userRequest = new UserRequest("user1","user1@gmail.com","user1password","user");
    this.user = new User("user1","user1","user1@gmail.com","user1password","user");
    this.userList = new ArrayList<>();
    jsonRequest = new ObjectMapper().writeValueAsString(userRequest);
    Mockito.doNothing().when(userService).updateUser("user1", userRequest);
  }

  @Test
  public void testHappyPathforPutApi() throws Exception {
    mockMvc.perform(
        put("/user/user1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest))
        .andExpect(status().isOk());
  }

  @Test
  public void testInvalidBody() throws Exception {
    mockMvc.perform(
            put("/user/user1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequest))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void testHappyPathforGet() throws Exception {
    Mockito.when(userService.getLoginUser("user1@gmail.com")).thenReturn(this.user);
    mockMvc.perform(get("/login/user1@gmail.com").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void testInvalidURLForGetRequest() throws Exception {
    mockMvc.perform(get("/login/wrongemail").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

}
