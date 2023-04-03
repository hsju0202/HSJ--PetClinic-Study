package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.service.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VetController {

    private final VetService vetService;

}
