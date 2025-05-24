package com.example.bhakyaPack.Service;

import com.example.bhakyaPack.DTO.AddressBookDTO;
import com.example.bhakyaPack.Model.AddressBookmodel;
import com.example.bhakyaPack.Repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
@Service
public class AddressBookService implements AddressBookServiceInt {

    @Autowired
    private AddressBookRepo repository;
    @Override
    public AddressBookmodel addAddress(AddressBookDTO dto) {
        log.info("Adding new address: {}", dto);
        AddressBookmodel ab = new AddressBookmodel();
        ab.setName(dto.getName());
        ab.setAddress(dto.getAddress());
        return repository.save(ab);
    }

    @Override
    public List<AddressBookmodel> getAll() {
        log.info("Fetching all addresses");
        return repository.findAll();
    }

    @Override
    public AddressBookmodel getById(int id) {
        log.info("Fetching address with id: {}", id);
        return repository.findById(id).orElseThrow(() -> {
            log.error("Address not found for id: {}", id);
            return new RuntimeException("Address not found");
        });
    }

    @Override
    public AddressBookmodel update(int id, AddressBookDTO dto) {
        log.info("Updating address id: {} with data: {}", id, dto);
        AddressBookmodel ab = getById(id);
        ab.setName(dto.getName());
        ab.setAddress(dto.getAddress());
        return repository.save(ab);
    }

    @Override
    public void delete(int id) {
        log.info("Deleting address with id: {}", id);
        repository.deleteById(id);
    }
}