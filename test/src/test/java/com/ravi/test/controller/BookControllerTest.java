package com.ravi.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ravi.test.utilities.BaseController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.test.data.model.Book;
import com.ravi.test.pojo.BookRequest;
import com.ravi.test.services.BookService;
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
@WebMvcTest(value = BookController.class)
public class BookControllerTest extends BaseController{

  @Autowired
  private MockMvc mockMvc;

  private List<Book> bookList;

  @MockBean
  private BookService bookService;

  private BookRequest bookRequest;

  private String jsonRequest;

  @Before
  public void setup() throws Exception {
    this.bookRequest = new BookRequest("book1","books",1,"yes");
    this.bookList = new ArrayList<>();
    jsonRequest = new ObjectMapper().writeValueAsString(bookRequest);
    Mockito.doNothing().when(bookService).updateBook("book1", bookRequest);
  }

  @Test
  public void testHappyPathforPutApi() throws Exception {
    mockMvc.perform(
        post("/book/book1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonRequest))
        .andExpect(status().isOk());
  }

  @Test
  public void testInvalidBody() throws Exception {
    mockMvc.perform(
        post("/book/book1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("jsonRequest"))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void testHappyPathforGet() throws Exception {
    Mockito.when(bookService.getAllBooks()).thenReturn(this.bookList);
    mockMvc.perform(get("/book").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void testInvalidURLForGetRequest() throws Exception {
    mockMvc.perform(get("/wrongUrl").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

}
