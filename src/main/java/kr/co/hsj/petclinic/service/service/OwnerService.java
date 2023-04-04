package kr.co.hsj.petclinic.service.service;

import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.persistence.entity.Owner;
import kr.co.hsj.petclinic.persistence.repository.OwnerRepository;
import kr.co.hsj.petclinic.persistence.repository.search.OwnerSearchRepository;
import kr.co.hsj.petclinic.service.model.dto.mapper.OwnerMapper;
import kr.co.hsj.petclinic.service.model.dto.request.OwnerRequestDTO;
import kr.co.hsj.petclinic.service.model.dto.response.OwnerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerSearchRepository ownerSearchRepository;
    private final OwnerMapper mapper;

    @Transactional
    public void create(OwnerRequestDTO.Create createDTO) {
        Owner owner = new Owner(createDTO);
        ownerRepository.save(owner);
    }

    public List<OwnerResponseDTO.Read> find(OwnerRequestDTO.Condition conditionDTO) {
        List<Owner> owners = ownerSearchRepository.find(conditionDTO);

        return owners.stream()
                     .map(mapper::toReadDTO)
                     .collect(Collectors.toList());
    }

    @Transactional
    public void update(OwnerRequestDTO.Update updateDTO) {
        Owner owner = ownerRepository.findById(updateDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Owner Not Found"));
        owner.update(updateDTO);
    }

    @Transactional
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }

}
