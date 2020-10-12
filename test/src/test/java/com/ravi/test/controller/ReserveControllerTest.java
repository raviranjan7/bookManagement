package com.ravi.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ravi.test.data.model.Book;
import com.ravi.test.pojo.BookRequest;
import com.ravi.test.services.BookService;
import com.ravi.test.services.ReserveService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(value = ReserveController.class)

public class ReserveControllerTest extends BaseController{
    @Autowired
    private MockMvc mockMvc;

    private List<Book> bookList;

    @MockBean
    private ReserveService reserveService;

    @Before
    public void setup() throws Exception {
        this.bookList = new ArrayList<>();
        Mockito.doReturn(1).when(reserveService).updateReserve("user1", "book1");
    }

    @Test
    public void testHappyPathforPutApi() throws Exception {
        mockMvc.perform(
                post("/reserve/book/book1/user/user1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testInvalidBody() throws Exception {
        mockMvc.perform(
                post("/wrongurl")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testHappyPathforGet() throws Exception {
        Mockito.when(reserveService.getReservedBooks("user1")).thenReturn(this.bookList);
        mockMvc.perform(get("/reserve/user1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testInvalidURLForGetRequest() throws Exception {
        mockMvc.perform(get("/wrongUrl").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
