package kr.co.hsj.petclinic.service.service;

import kr.co.hsj.petclinic.persistence.repository.OwnerRepository;
import kr.co.hsj.petclinic.persistence.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

}
