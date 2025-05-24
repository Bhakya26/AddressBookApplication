package com.example.bhakyaPack.Service;

import com.example.bhakyaPack.DTO.AddressBookDTO;
import com.example.bhakyaPack.Model.AddressBookmodel;
import com.example.bhakyaPack.Repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements AddressBookServiceInt {

    @Autowired
    private AddressBookRepo repository;

    @Override
    public AddressBookmodel addAddress(AddressBookDTO dto) {
        AddressBookmodel ab = new AddressBookmodel();
        ab.setName(dto.getName());
        ab.setAddress(dto.getAddress());
        return repository.save(ab);
    }

    @Override
    public List<AddressBookmodel> getAll() {
        return repository.findAll();
    }

    @Override
    public AddressBookmodel getById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public AddressBookmodel update(int id, AddressBookDTO dto) {
        AddressBookmodel ab = getById(id);
        ab.setName(dto.getName());
        ab.setAddress(dto.getAddress());
        return repository.save(ab);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}