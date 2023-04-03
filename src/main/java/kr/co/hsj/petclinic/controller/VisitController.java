package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.service.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

}
