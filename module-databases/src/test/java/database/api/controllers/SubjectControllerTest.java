package database.api.controllers;

import static database.constans.URL.GET_BY_NAME;
import static database.constans.URL.GET_SUBJECT_BY_TEACHER_ID;
import static database.constans.URL.SUBJECTS;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import database.api.services.SubjectService;
import database.entities.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class SubjectControllerTest {

  public static final String SUBJECT_JSON_STRING = "{"
      + "\"id\":null,"
      + "\"created\":null,"
      + "\"updated\":null,"
      + "\"name\":null,"
      + "\"teacher\":null"
      + "}";
  private MockMvc mvc;
  private Subject subject;

  @Mock
  private SubjectService service;

  @InjectMocks
  private SubjectController controller;

  @BeforeEach
  void init() {
    openMocks(this);
    subject = new Subject();
    mvc = MockMvcBuilders
        .standaloneSetup(controller)
        .build();
  }

  @Test
  void getSubjectByNameTest() throws Exception {
    when(service.getSubjectByName(anyString())).thenReturn(subject);

    String result = mvc.perform(get(SUBJECTS + GET_BY_NAME)
        .param("name", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(SUBJECT_JSON_STRING, result);
  }

  @Test
  void getSubjectByTeacherIdTest() throws Exception {
    when(service.getSubjectByTeacherId(anyLong())).thenReturn(subject);

    String result = mvc.perform(get(SUBJECTS + GET_SUBJECT_BY_TEACHER_ID)
        .param("teacherId", valueOf(anyLong()))
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(SUBJECT_JSON_STRING, result);
  }
}
