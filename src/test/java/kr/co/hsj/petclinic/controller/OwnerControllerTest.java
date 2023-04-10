package kr.co.hsj.petclinic.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.hsj.petclinic.infra.exception.AlreadyExistPhoneNumberException;
import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.service.model.dto.request.OwnerRequestDTO;
import kr.co.hsj.petclinic.service.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OwnerController.class)
class OwnerControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    OwnerService ownerService;

    ObjectMapper jsonConvertor = new ObjectMapper();

    @Test
    @DisplayName("주인 생성 성공")
    void createOwnerSuccess() throws Exception {
        //given
        OwnerRequestDTO.Create createDTO = OwnerRequestDTO.Create.builder()
                                                                 .build();

        //then
        mvc.perform(
               post("/owners")
                   .content(jsonConvertor.writeValueAsString(createDTO))
                   .contentType(MediaType.APPLICATION_JSON)
           )
           .andExpect(status().isOk());
    }

    @Test
    @DisplayName("주인 생성 시 휴대번호 중복으로 생성 실패")
    void alreadyExistPhoneNumberExceptionAtCreate() throws Exception {
        //given
        OwnerRequestDTO.Create createDTO = OwnerRequestDTO.Create.builder()
                                                                 .build();

        doThrow(new AlreadyExistPhoneNumberException("이미 중복된 휴대번호입니다."))
            .when(ownerService)
            .create(any(OwnerRequestDTO.Create.class));

        //then
        mvc.perform(
               post("/owners")
                   .content(jsonConvertor.writeValueAsString(createDTO))
                   .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isBadRequest())
           .andExpect(content().string("이미 중복된 휴대번호입니다."));
    }

    @Test
    @DisplayName("주인 수정 성공")
    void updateOwnerSuccess() throws Exception {
        //given
        OwnerRequestDTO.Update updateDTO = OwnerRequestDTO.Update.builder()
                                                                 .build();

        //then
        mvc.perform(
               put("/owners/1")
                   .content(jsonConvertor.writeValueAsString(updateDTO))
                   .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk());
    }

    @Test
    @DisplayName("주인 수정 시 EntityNotFoundException 발생")
    void entityNotFoundExceptionAtUpdate() throws Exception {
        //given
        OwnerRequestDTO.Update updateDTO = OwnerRequestDTO.Update.builder()
                                                                 .build();

        doThrow(new EntityNotFoundException("Owner Not Found")).when(ownerService).update(anyLong(), any(OwnerRequestDTO.Update.class));

        //then
        mvc.perform(
               put("/owners/1")
                   .content(jsonConvertor.writeValueAsString(updateDTO))
                   .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isBadRequest())
           .andExpect(content().string("Owner Not Found"));
    }
}