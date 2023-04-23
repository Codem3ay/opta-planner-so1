package com.example.vrp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningListVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;

/**
 * TODO: add your documentation
 *
 * @author Hamza HABCHI (contact: hh@beyond-believers.com)
 * <p>
 * Copyright (C) Beyond Believers, Inc - All Rights Reserved Unauthorized copying of this
 * file, via any medium is strictly prohibited Proprietary and confidential
 * <p>
 * Created 22 Apr 2023
 */
@Getter
@Setter
@ToString
@PlanningEntity
public class Vehicle {

    @PlanningId
    private Long id;

    private int weightCapacity;
    private int volumeCapacity;
    private double guaranteeCheck;

    @PlanningListVariable(valueRangeProviderRefs = "orderRange")
    private List<Order> orders;

    public Vehicle() {
    }

    public Vehicle(long id, int volume, int weight) {
        this.id = id;
        this.volumeCapacity=volume;
        this.weightCapacity=weight;
    }

    public int getTotalVolumeCapacity() {
        int totalDemand = 0;
        for (Order order : orders) {
            totalDemand += order.getVolume();
        }
        return totalDemand;
    }

    public int getTotalWeightCapacity(){
        int totalDemand = 0;
        for (Order order : orders) {
            totalDemand += order.getWeight();
        }
        return totalDemand;
    }
}
