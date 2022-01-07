package com.gj.example.backendCrud.controller;

import com.gj.example.backendCrud.model.FamilyNode;
import com.gj.example.backendCrud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("nodes")
public class CrudController {

    @Autowired
    CrudService service;

    @PostMapping("familyNodes")
    public ResponseEntity saveFamilyNode(@RequestBody FamilyNode request) {
        try {
            FamilyNode response = service.invokeSaveOperation(request);
            return ResponseEntity.created(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(response.getId())
                    .toUri()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("familyNodes/{id}")
    public ResponseEntity getFamilyNode(@PathVariable("id") Long id) {
        try {
            FamilyNode response = service.getFamilyData(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("familyNodes")
    public ResponseEntity getFamilyNodes() {
        try {
            List<FamilyNode> response = service.getFamilyDataList();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
