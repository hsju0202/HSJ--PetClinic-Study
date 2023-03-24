package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.service.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class VetController {

    private final VetService vetService;

}
