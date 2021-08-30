package database.api.controllers;

import static database.constans.URL.GET_BY_NAME;
import static database.constans.URL.GET_BY_SURNAME;
import static database.constans.URL.GET_TEACHERS_BY_TITLE;
import static database.constans.URL.TEACHERS;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import database.api.services.TeacherService;
import database.entities.Teacher;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class TeacherControllerTest {

  public static final String TEACHER_JSON_STRING = "{"
      + "\"id\":null,"
      + "\"created\":null,"
      + "\"updated\":null,"
      + "\"name\":null,"
      + "\"surname\":null,"
      + "\"title\":null,"
      + "\"birthDate\":null,"
      + "\"subject\":null"
      + "}";

  private MockMvc mvc;
  private Teacher teacher;
  private List<Teacher> list;

  @Mock
  private TeacherService service;

  @InjectMocks
  private TeacherController controller;

  @BeforeEach
  void init() {
    openMocks(this);
    teacher = new Teacher();
    list = of(teacher);
    mvc = MockMvcBuilders
        .standaloneSetup(controller)
        .build();
  }

  @Test
  void getTeacherByNameTest() throws Exception {
    when(service.getTeacherByName(anyString())).thenReturn(teacher);

    String result = mvc.perform(get(TEACHERS + GET_BY_NAME)
        .param("name", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(TEACHER_JSON_STRING, result);
  }

  @Test
  void getTeacherBySurnameTest() throws Exception {
    when(service.getTeacherBySurname(anyString())).thenReturn(teacher);

    String result = mvc.perform(get(TEACHERS + GET_BY_SURNAME)
        .param("surname", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(TEACHER_JSON_STRING, result);
  }

  @Test
  void getTeachersByTitleTest() throws Exception {
    when(service.getTeachersByTitle(anyString())).thenReturn(list);

    String result = mvc.perform(get(TEACHERS + GET_TEACHERS_BY_TITLE)
        .param("teacherTitle", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals("[" + TEACHER_JSON_STRING + "]", result);
  }
}
