package com.example.tripease.model;

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
@Table(name="driver_info")
public class Driver {
    @Id
    private int driverId;
    private String name;
    private int age;
    private String emailId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="driver_id")
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cab-id")
    Cab cab;
}
