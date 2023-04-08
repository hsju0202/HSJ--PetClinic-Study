package kr.co.hsj.petclinic.service.service;

import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.persistence.entity.Owner;
import kr.co.hsj.petclinic.persistence.entity.Pet;
import kr.co.hsj.petclinic.persistence.repository.OwnerRepository;
import kr.co.hsj.petclinic.persistence.repository.PetRepository;
import kr.co.hsj.petclinic.persistence.repository.search.PetSearchRepository;
import kr.co.hsj.petclinic.service.model.dto.mapper.PetMapper;
import kr.co.hsj.petclinic.service.model.dto.request.PetRequestDTO;
import kr.co.hsj.petclinic.service.model.dto.response.PetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final PetSearchRepository petSearchRepository;
    private final PetMapper mapper;

    @Transactional
    public void create(PetRequestDTO.Create createDTO) {
        Owner owner = ownerRepository.findById(createDTO.getOwnerId())
                                     .orElseThrow(() -> new EntityNotFoundException("Owner Not Found"));

        Pet pet = Pet.builder()
                     .owner(owner)
                     .birthDate(createDTO.getBirthDate())
                     .name(createDTO.getName())
                     .petType(createDTO.getPetType())
                     .build();

        petRepository.save(pet);
    }

    public List<PetResponseDTO.Read> find(PetRequestDTO.Condition conditionDTO) {
        List<Pet> pets = petSearchRepository.find(conditionDTO);

        return pets.stream()
                   .map(mapper::toReadDTO)
                   .collect(Collectors.toList());
    }

    @Transactional
    public void update(PetRequestDTO.Update updateDTO) {
        Pet pet = petRepository.findById(updateDTO.getId())
                               .orElseThrow(() -> new EntityNotFoundException("Pet Not Found"));
        pet.update(updateDTO);
    }

    @Transactional
    public void delete(Long id) {
        petRepository.deleteById(id);
    }
}
