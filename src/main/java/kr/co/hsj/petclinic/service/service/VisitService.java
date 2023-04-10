package kr.co.hsj.petclinic.service.service;

import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.persistence.entity.Pet;
import kr.co.hsj.petclinic.persistence.entity.Visit;
import kr.co.hsj.petclinic.persistence.repository.PetRepository;
import kr.co.hsj.petclinic.persistence.repository.VisitRepository;
import kr.co.hsj.petclinic.persistence.repository.search.VisitSearchRepository;
import kr.co.hsj.petclinic.service.model.dto.mapper.VisitMapper;
import kr.co.hsj.petclinic.service.model.dto.request.VisitRequestDTO;
import kr.co.hsj.petclinic.service.model.dto.response.VisitResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final VisitSearchRepository visitSearchRepository;
    private final PetRepository petRepository;
    private final VisitMapper mapper;

    @Transactional
    public void create(VisitRequestDTO.Create createDTO) throws EntityNotFoundException {
        Pet pet = petRepository.findById(createDTO.getPetId()).orElseThrow(() -> new EntityNotFoundException("Pet Not Found"));

        Visit visit = Visit.builder()
                           .description(createDTO.getDescription())
                           .pet(pet)
                           .build();

        visitRepository.save(visit);
    }

    public List<VisitResponseDTO.Read> find(VisitRequestDTO.Condition conditionDTO) {
        List<Visit> visits = visitSearchRepository.find(conditionDTO);

        return visits.stream()
                     .map(mapper::toReadDTO)
                     .collect(Collectors.toList());
    }

    @Transactional
    public void update(Long id, VisitRequestDTO.Update updateDTO) {
        Visit visit = visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit Not Found"));
        visit.update(updateDTO);
    }

    @Transactional
    public void delete(Long id) {
        visitRepository.deleteById(id);
    }

}
