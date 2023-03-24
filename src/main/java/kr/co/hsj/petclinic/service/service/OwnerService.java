package kr.co.hsj.petclinic.service.service;

import kr.co.hsj.petclinic.persistence.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

}
