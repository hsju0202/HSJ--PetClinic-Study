package kr.co.hsj.petclinic.service.service;

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

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VetService {

    private final VetRepository vetRepository;
    private final VetSearchRepository vetSearchRepository;
    private final VetMapper mapper;

    @Transactional
    public void create(VetRequestDTO.Create createDTO) {
        Vet vet = new Vet(createDTO);
        vetRepository.save(vet);
    }

    public List<VetResponseDTO.Read> find(VetRequestDTO.Condition conditionDTO) {
        List<Vet> vets = vetSearchRepository.find(conditionDTO);

        return vets.stream()
                .map(mapper::toReadDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void update(VetRequestDTO.Update updateDTO) {
        Vet vet = vetRepository.findById(updateDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Vet Not Found"));
        vet.update(updateDTO);
    }

    @Transactional
    public void delete(Long id) {
        vetRepository.deleteById(id);
    }

}
