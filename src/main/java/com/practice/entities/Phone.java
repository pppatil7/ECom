package com.practice.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("PHONE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phone extends Product {

    private String phoneModelNumber;
    private Integer phoneRamSize;
    private Integer phoneStorageCapacity;
    private Integer phoneBatteryCapacity;

}
