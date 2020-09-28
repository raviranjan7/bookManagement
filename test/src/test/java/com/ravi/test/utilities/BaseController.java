package com.ravi.test.utilities;

import com.ravi.test.data.repository.BookRepository;
import com.ravi.test.data.repository.ReserveRepository;
import com.ravi.test.data.repository.UserRepository;
import org.springframework.boot.test.mock.mockito.MockBean;

@MockBean({BookRepository.class, UserRepository.class, ReserveRepository.class})
public class BaseController {

}
