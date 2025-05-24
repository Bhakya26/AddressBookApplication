package com.example.bhakyaPack.Repository;

import com.example.bhakyaPack.Model.AddressBookmodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepo extends JpaRepository<AddressBookmodel, Integer> {
}
