package com.example.vrp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO: add your documentation
 *
 * @author Hamza HABCHI (contact: hh@beyond-believers.com)
 * <p>
 * Copyright (C) Beyond Believers, Inc - All Rights Reserved Unauthorized copying of this
 * file, via any medium is strictly prohibited Proprietary and confidential
 * <p>
 * Created 23 Apr 2023
 */
@Getter
@Setter
@ToString
public class Order {
    private Long id;
    private String reference;
    private double weight;
    private double volume;
//    private double amount;
    private Location location;

    public Order() {
    }

    public Order(long id, int volume, int weight, Location location) {
        this.id = id;
        this.reference = this.id.toString();
        this.volume = volume;
        this.weight = weight;
        this.location = location;
    }
}
