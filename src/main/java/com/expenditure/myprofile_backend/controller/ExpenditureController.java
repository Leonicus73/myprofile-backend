package com.expenditure.myprofile_backend.controller;

import com.expenditure.myprofile_backend.entity.Expenditure;
import com.expenditure.myprofile_backend.repository.ExpenditureRepository;
import com.expenditure.myprofile_backend.service.MigrationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/expenditures")
public class ExpenditureController {

    private final ExpenditureRepository repository;
    private final MigrationService migrationService;

    public ExpenditureController(ExpenditureRepository repository, MigrationService migrationService) {
        this.repository = repository;
        this.migrationService = migrationService;
    }

    @GetMapping
    public List<Expenditure> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Expenditure create(@RequestBody Expenditure expenditure) {
        return repository.save(expenditure);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(@RequestParam String confirm) {
        if (!"yes".equalsIgnoreCase(confirm)) {
            return ResponseEntity.badRequest().body("Confirmation required");
        }
        repository.deleteAll();
        return ResponseEntity.ok("All expenditures deleted");
    }

    @PostMapping("/migrate")
    public ResponseEntity<String> migrateFromMongo() {
        migrationService.migrateFromMongo();
        return ResponseEntity.ok("Migration from MongoDB complete");
    }
}
