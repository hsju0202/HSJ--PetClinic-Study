package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.service.model.dto.request.VetRequestDTO;
import kr.co.hsj.petclinic.service.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VetController {

    private final VetService vetService;

    @GetMapping("/vets")
    public ResponseEntity<?> findVets(VetRequestDTO.Condition conditionDTO) {
        try {
            return ResponseEntity.ok(vetService.find(conditionDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/vets")
    public ResponseEntity<?> createVet(@RequestBody VetRequestDTO.Create createDTO) {
        try {
            vetService.create(createDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/vets/{vetId}")
    public ResponseEntity<?> updateVet(@PathVariable Long vetId, @RequestBody VetRequestDTO.Update updateDTO) {
        try {
            vetService.update(vetId, updateDTO);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/vets/{vetId}")
    public ResponseEntity<?> deleteVet(@PathVariable Long vetId) {
        try {
            vetService.delete(vetId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
