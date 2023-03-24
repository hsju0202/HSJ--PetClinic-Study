package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.service.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

}
