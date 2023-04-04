package kr.co.hsj.petclinic.service.model.dto.mapper;

import kr.co.hsj.petclinic.persistence.entity.Owner;
import kr.co.hsj.petclinic.service.model.dto.response.OwnerResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerResponseDTO.Read toReadDTO(Owner owner);

}
