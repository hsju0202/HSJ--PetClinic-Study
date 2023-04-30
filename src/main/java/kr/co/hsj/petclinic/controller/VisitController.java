package kr.co.hsj.petclinic.controller;

import kr.co.hsj.petclinic.infra.exception.EntityNotFoundException;
import kr.co.hsj.petclinic.service.model.dto.request.VisitRequestDTO;
import kr.co.hsj.petclinic.service.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

//    @GetMapping("/visits")
//    public ResponseEntity<?> find(VisitRequestDTO.Condition conditionDTO) {
//        try {
//            return ResponseEntity.ok(visitService.find(conditionDTO));
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }

    @GetMapping("/visits")
    public ResponseEntity<?> findByOwnerId(@RequestParam Long ownerId) {
        try {
            return ResponseEntity.ok(visitService.findByOwnerId(ownerId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/visits")
    public ResponseEntity<?> createVisit(@RequestBody VisitRequestDTO.Create createDTO) {
        try {
            visitService.create(createDTO);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/visits/{visitId}")
    public ResponseEntity<?> updateVisit(@PathVariable Long visitId, @RequestBody VisitRequestDTO.Update updateDTO) {
        try {
            visitService.update(visitId, updateDTO);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/visits/{visitId}")
    public ResponseEntity<?> deleteVisit(@PathVariable Long visitId) {
        try {
            visitService.delete(visitId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
