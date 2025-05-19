package com.example.bhakyaPack.Service;




import com.example.bhakyaPack.DTO.AddressBookDTO;

public interface AddressBookServiceInt{
    String createEntry(AddressBookDTO dto);
    String getEntryById(int id);
    String getAllEntries();
    String updateEntry(int id, AddressBookDTO dto);
    String deleteEntry(int id);
}
