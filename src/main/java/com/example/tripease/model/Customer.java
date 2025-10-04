package com.example.tripease.model;

import com.example.tripease.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    private int customerId;
    private String name;
    private int age;
    private String emailId;
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer-id")
    private List<Booking> bookings = new ArrayList<>();
}
