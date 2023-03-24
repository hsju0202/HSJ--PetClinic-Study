package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.service.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

}
