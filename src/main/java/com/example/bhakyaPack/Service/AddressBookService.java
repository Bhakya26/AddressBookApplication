package com.example.bhakyaPack.Service;



import com.example.bhakyaPack.DTO.AddressBookDTO;
import com.example.bhakyaPack.Model.AddressBookmodel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class AddressBookService implements AddressBookServiceInt {

    private final List<AddressBookmodel> addressList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public AddressBookmodel createEntry(AddressBookDTO dto) {
        AddressBookmodel entry = new AddressBookmodel(idCounter++, dto.getName(), dto.getAddress(), dto.getPhone());
        addressList.add(entry);
        return entry;
    }

    @Override
    public AddressBookmodel getEntryById(int id) {
        return addressList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AddressBookmodel> getAllEntries() {
        return addressList;
    }

    @Override
    public AddressBookmodel updateEntry(int id, AddressBookDTO dto) {
        AddressBookmodel existing = getEntryById(id);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
            existing.setPhone(dto.getPhone());
        }
        return existing;
    }

    @Override
    public void deleteEntry(int id) {
        addressList.removeIf(e -> e.getId() == id);
    }
}