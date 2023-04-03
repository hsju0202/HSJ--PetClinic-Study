package kr.co.hsj.petclinic.service.service;

import kr.co.hsj.petclinic.persistence.repository.OwnerRepository;
import kr.co.hsj.petclinic.persistence.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetService {

    private final VetRepository vetRepository;

}
