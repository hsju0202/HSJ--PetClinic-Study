package kr.co.hsj.petclinic.service.model.dto.mapper;

import kr.co.hsj.petclinic.persistence.entity.Visit;
import kr.co.hsj.petclinic.service.model.dto.response.VisitResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    @Mapping(target = "petName", source = "pet.name")
    VisitResponseDTO.Read toReadDTO(Visit visit);

}
