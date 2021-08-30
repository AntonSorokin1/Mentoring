package database.api.controllers;

import static database.constans.URL.GET_BY_NAME;
import static database.constans.URL.GET_BY_SURNAME;
import static database.constans.URL.GET_STUDENT_BY_PHONE_NUMBER;
import static database.constans.URL.STUDENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import database.api.services.StudentService;
import database.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class StudentControllerTest {

  public static final String STUDENT_JSON_STRING = "{"
      + "\"id\":null,"
      + "\"created\":null,"
      + "\"updated\":null,"
      + "\"name\":null,"
      + "\"surname\":null,"
      + "\"phoneNumber\":null,"
      + "\"birthDate\":null"
      + "}";

  private MockMvc mvc;
  private Student student;

  @Mock
  private StudentService service;

  @InjectMocks
  private StudentController controller;

  @BeforeEach
  void init() {
    openMocks(this);
    student = new Student();
    mvc = MockMvcBuilders
        .standaloneSetup(controller)
        .build();
  }

  @Test
  void getStudentByNameTest() throws Exception {
    when(service.getStudentByName(anyString())).thenReturn(student);

    String result = mvc.perform(get(STUDENTS + GET_BY_NAME)
        .param("name", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(STUDENT_JSON_STRING, result);
  }

  @Test
  void getStudentBySurnameTest() throws Exception {
    when(service.getStudentBySurname(anyString())).thenReturn(student);

    String result = mvc.perform(get(STUDENTS + GET_BY_SURNAME)
        .param("surname", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(STUDENT_JSON_STRING, result);
  }

  @Test
  void getStudentByPhoneNumberTest() throws Exception {
    when(service.getStudentByPhoneNumber(anyString())).thenReturn(student);

    String result = mvc.perform(get(STUDENTS + GET_STUDENT_BY_PHONE_NUMBER)
        .param("phoneNumber", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(STUDENT_JSON_STRING, result);
  }
}
