package com.example.bhakyaPack.Service;



import com.example.bhakyaPack.Model.AddressBookmodel;
import com.example.bhakyaPack.DTO.AddressBookDTO;
import java.util.*;



public interface AddressBookServiceInt {
    AddressBookmodel createEntry(AddressBookDTO dto);
    AddressBookmodel getEntryById(int id);
    List<AddressBookmodel> getAllEntries();
    AddressBookmodel updateEntry(int id, AddressBookDTO dto);
    void deleteEntry(int id);
}