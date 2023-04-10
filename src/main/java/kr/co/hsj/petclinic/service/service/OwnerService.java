package kr.co.hsj.petclinic.service.service;

import kr.co.hsj.petclinic.infra.exception.AlreadyExistPhoneNumberException;
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
    public void create(OwnerRequestDTO.Create createDTO) throws AlreadyExistPhoneNumberException {
        Boolean alreadyExistNumber = ownerRepository.existsByTelephone(createDTO.getTelephone());

        if (alreadyExistNumber) {
            throw new AlreadyExistPhoneNumberException("이미 가입된 휴대폰 번호입니다.");
        }

        Owner owner = Owner.builder()
                           .firstName(createDTO.getFirstName())
                           .lastName(createDTO.getLastName())
                           .telephone(createDTO.getTelephone())
                           .address(createDTO.getAddress())
                           .city(createDTO.getCity())
                           .build();

        ownerRepository.save(owner);
    }

    public List<OwnerResponseDTO.Read> find(OwnerRequestDTO.Condition conditionDTO) {
        List<Owner> owners = ownerSearchRepository.find(conditionDTO);

        return owners.stream()
                     .map(mapper::toReadDTO)
                     .collect(Collectors.toList());
    }

    @Transactional
    public void update(Long id, OwnerRequestDTO.Update updateDTO) throws EntityNotFoundException {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner Not Found"));
        owner.update(updateDTO);
    }

    @Transactional
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }

}
