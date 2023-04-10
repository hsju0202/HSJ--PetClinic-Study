package kr.co.hsj.petclinic.service.service;

import java.util.List;
import java.util.stream.Collectors;
import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.persistence.entity.Vet;
import kr.co.hsj.petclinic.persistence.repository.VetRepository;
import kr.co.hsj.petclinic.persistence.repository.search.VetSearchRepository;
import kr.co.hsj.petclinic.service.model.dto.mapper.VetMapper;
import kr.co.hsj.petclinic.service.model.dto.request.VetRequestDTO;
import kr.co.hsj.petclinic.service.model.dto.response.VetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VetService {

    private final VetRepository vetRepository;
    private final VetSearchRepository vetSearchRepository;
    private final VetMapper mapper;

    @Transactional
    public void create(VetRequestDTO.Create createDTO) {
        Vet vet = Vet.builder()
                     .firstName(createDTO.getFirstName())
                     .lastName(createDTO.getLastName())
                     .specialties(createDTO.getSpecialties())
                     .build();

        vetRepository.save(vet);
    }

    public List<VetResponseDTO.Read> find(VetRequestDTO.Condition conditionDTO) {
        List<Vet> vets = vetSearchRepository.find(conditionDTO);

        return vets.stream()
                   .map(mapper::toReadDTO)
                   .collect(Collectors.toList());
    }

    @Transactional
    public void update(Long id, VetRequestDTO.Update updateDTO) {
        Vet vet = vetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vet Not Found"));
        vet.update(updateDTO);
    }

    @Transactional
    public void delete(Long id) {
        vetRepository.deleteById(id);
    }

}
