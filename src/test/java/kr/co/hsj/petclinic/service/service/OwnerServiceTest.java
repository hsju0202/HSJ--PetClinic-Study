package kr.co.hsj.petclinic.service.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import kr.co.hsj.petclinic.infra.exception.AlreadyExistPhoneNumberException;
import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.persistence.repository.OwnerRepository;
import kr.co.hsj.petclinic.persistence.repository.search.OwnerSearchRepository;
import kr.co.hsj.petclinic.service.model.dto.mapper.OwnerMapper;
import kr.co.hsj.petclinic.service.model.dto.request.OwnerRequestDTO;
import kr.co.hsj.petclinic.service.model.dto.request.OwnerRequestDTO.Create;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    OwnerSearchRepository ownerSearchRepository;

    @Mock
    OwnerMapper mapper;

    OwnerService ownerService;

    @BeforeEach
    void setup() {
        ownerService = new OwnerService(ownerRepository, ownerSearchRepository, mapper);
    }

    @Test
    @DisplayName("주인 생성 성공")
    void createOwnerSuccess() {
        //given
        Create createDTO = Create.builder()
                                 .telephone("010-1234-5678")
                                 .build();

        doReturn(Boolean.FALSE).when(ownerRepository).existsByTelephone(anyString());

        //then
        ownerService.create(createDTO);
    }

    @Test
    @DisplayName("주인 생성 시 전화번호 중복 예외")
    void AlreadyExistPhoneNumber() {
        //given
        Create createDTO = Create.builder()
                                 .telephone("010-1234-5678")
                                 .build();

        doReturn(Boolean.TRUE).when(ownerRepository).existsByTelephone(anyString());

        //then
        assertThrows(AlreadyExistPhoneNumberException.class, () -> ownerService.create(createDTO));
    }

    @Test
    @DisplayName("주인 수정 시 ")
    void ownerNotFoundAtUpdate() {
        //given
        OwnerRequestDTO.Update updateDTO = OwnerRequestDTO.Update.builder()
                                                                 .build();

        doThrow(new EntityNotFoundException("Owner Not Found")).when(ownerRepository).findById(anyLong());

        //then
        assertThrows(EntityNotFoundException.class, () -> ownerService.update(1L, updateDTO));
    }

}