package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.infra.exception.AlreadyExistPhoneNumberException;
import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.service.model.dto.request.OwnerRequestDTO;
import kr.co.hsj.petclinic.service.service.OwnerService;
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
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("/owners")
    public ResponseEntity<?> findOwners(OwnerRequestDTO.Condition conditionDTO) {
        try {
            return ResponseEntity.ok(ownerService.find(conditionDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/owners")
    public ResponseEntity<?> createOwner(@RequestBody OwnerRequestDTO.Create createDTO) {
        try {
            ownerService.create(createDTO);
            return ResponseEntity.ok().build();
        } catch (AlreadyExistPhoneNumberException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/owners/{ownerId}")
    public ResponseEntity<?> updateOwner(@PathVariable Long ownerId, @RequestBody OwnerRequestDTO.Update updateDTO) {
        try {
            ownerService.update(ownerId, updateDTO);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/owners/{ownerId}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long ownerId) {
        try {
            ownerService.delete(ownerId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
