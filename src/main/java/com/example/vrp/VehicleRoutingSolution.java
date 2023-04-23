package com.example.vrp;

import com.example.vrp.domain.Order;
import com.example.vrp.domain.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore;

import java.util.List;

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
@NoArgsConstructor
@AllArgsConstructor
@PlanningSolution
@Getter
@Setter
public class VehicleRoutingSolution {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "orderRange")
    private List<Order> orders;

    @ValueRangeProvider
    @PlanningEntityCollectionProperty
    private List<Vehicle> vehicles;

    @PlanningScore
    private HardSoftLongScore score;

    public VehicleRoutingSolution(List<Order> orders, List<Vehicle> vehicles) {
        this.orders = orders;
        this.vehicles = vehicles;
    }
}
