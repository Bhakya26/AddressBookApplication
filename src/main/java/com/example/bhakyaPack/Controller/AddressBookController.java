package com.example.bhakyaPack.Controller;


import com.example.bhakyaPack.DTO.AddressBookDTO;
import com.example.bhakyaPack.Service.*;
import com.example.bhakyaPack.Model.AddressBookmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
    private AddressBookServiceInt service;

    @GetMapping
    public ResponseEntity<List<AddressBookmodel>> getAll() {
        return ResponseEntity.ok(service.getAllEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
    	AddressBookmodel entry = service.getEntryById(id);
        return (entry != null) ? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBookmodel> create(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.createEntry(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
    	AddressBookmodel updated = service.updateEntry(id, dto);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.deleteEntry(id);
        return ResponseEntity.ok("Deleted entry with ID: " + id);
    }
}