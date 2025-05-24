package com.example.bhakyaPack.Controller;

import com.example.bhakyaPack.DTO.*;
import com.example.bhakyaPack.Model.AddressBookmodel;

import com.example.bhakyaPack.Service.AddressBookServiceInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookServiceInt service;

    @PostMapping
    public ResponseEntity<AddressBookmodel> add(@RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.addAddress(dto));
    }

    @GetMapping
    public ResponseEntity<List<AddressBookmodel>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookmodel> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookmodel> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted ID: " + id);
    }
}