package com.example.bhakyaPack.Service;

import com.example.bhakyaPack.DTO.*;
import com.example.bhakyaPack.Model.AddressBookmodel;

import java.util.List;

public interface AddressBookServiceInt {
    AddressBookmodel addAddress(AddressBookDTO dto);
    List<AddressBookmodel> getAll();
    AddressBookmodel getById(int id);
   AddressBookmodel update(int id, AddressBookDTO dto);
    void delete(int id);
}