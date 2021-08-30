package database.api.controllers;

import static database.constans.URL.CREATE;
import static database.constans.URL.DELETE;
import static database.constans.URL.GET;
import static database.constans.URL.GET_ALL;
import static database.constans.URL.UPDATE;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import database.api.services.CrudService;
import database.entities.AbstractIdentifiableObject;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Disabled
class CrudControllerTest<T extends AbstractIdentifiableObject, S extends CrudService<T>> {

  private MockMvc mvc;
  private List<T> list;

  @Mock
  private S service;
  @Mock
  private T object;

  @InjectMocks
  private CrudController<T, S> controller;

  @BeforeEach
  void init() {
    openMocks(this);
    list = of(object);
    mvc = MockMvcBuilders
        .standaloneSetup(controller)
        .build();
  }

  @Test
  void createTest() throws Exception {
    when(service.create(object)).thenReturn(object);

    String result = mvc.perform(get(CREATE)
        .param("object", anyString())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(anyString(), result);
  }

  @Test
  void readTest() throws Exception {
    when(service.read(anyLong())).thenReturn(object);

    String result = mvc.perform(get(GET)
        .requestAttr("id", anyLong())
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(anyString(), result);
  }

  @Test
  void readAllTest() throws Exception {
    when(service.readAll()).thenReturn(list);

    String result = mvc.perform(get(GET_ALL))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(anyString(), result);
  }

  @Test
  void updateTest() throws Exception {
    when(service.update(eq(object), anyLong())).thenReturn(true);

    String result = mvc.perform(get(UPDATE)
        .requestAttr("id", anyLong())
        .requestAttr("object", object)
        .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(anyString(), result);
  }

  @Test
  void deleteTest() throws Exception {
    when(service.delete(anyLong())).thenReturn(true);

    String result = mvc.perform(get(DELETE)
            .requestAttr("id", anyLong())
            .contentType(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

    assertEquals(anyString(), result);
  }
}
