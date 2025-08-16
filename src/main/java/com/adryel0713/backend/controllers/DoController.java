package com.adryel0713.backend.controllers;

import com.adryel0713.backend.exceptions.NotFoundException;
import com.adryel0713.backend.model.Do;
import com.adryel0713.backend.services.DoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/do")
public class DoController {

    private final DoService service;

    public DoController(DoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Do>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Do> findById(@PathVariable Long id){
        Do verify = service.findById(id).orElseThrow(() -> new NotFoundException("Este Id não existe: " + id));
        return ResponseEntity.ok(verify);
    }
    @PostMapping
    public ResponseEntity<Do> save(@RequestBody Do doDo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(doDo));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Do> edit(@PathVariable Long id,@RequestBody Do doDo){
        Do verify = service.findById(id).orElseThrow(() -> new NotFoundException("Este Id não existe: " + id));

        verify.setName(doDo.getName());
        verify.setDescription(doDo.getDescription());
        verify.setDone(doDo.isDone());

        return ResponseEntity.ok(service.edit(verify));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        var verify = service.findById(id).orElseThrow(() -> new NotFoundException("Este Id não existe: " + id));
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
