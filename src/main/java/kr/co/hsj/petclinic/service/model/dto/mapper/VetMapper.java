package kr.co.hsj.petclinic.service.model.dto.mapper;

import kr.co.hsj.petclinic.persistence.entity.Vet;
import kr.co.hsj.petclinic.service.model.dto.response.VetResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VetMapper {

    VetResponseDTO.Read toReadDTO(Vet vet);

}
