package com.example.bhakyaPack.Service;


import com.example.bhakyaPack.DTO.AddressBookDTO;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService implements AddressBookServiceInt {

    @Override
    public String createEntry(AddressBookDTO dto) {
        return "Service: Created entry for " + dto.getName() + ", " + dto.getAddress() + ", " + dto.getPhone();
    }

    @Override
    public String getEntryById(int id) {
        return "Service: Retrieved entry with ID = " + id;
    }

    @Override
    public String getAllEntries() {
        return "Service: Returned all address book entries.";
    }

    @Override
    public String updateEntry(int id, AddressBookDTO dto) {
        return "Service: Updated entry ID = " + id + " to Name = " + dto.getName() +
                ", Address = " + dto.getAddress() + ", Phone = " + dto.getPhone();
    }

    @Override
    public String deleteEntry(int id) {
        return "Service: Deleted entry with ID = " + id;
    }
}
