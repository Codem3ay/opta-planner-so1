package com.example.vrp;

import com.example.vrp.domain.Order;
import com.example.vrp.domain.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

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
@Slf4j
@Component
public class DataLoaderService implements CommandLineRunner {


    @Autowired
    private SolverManager<VehicleRoutingSolution, UUID> solverManager;

    @Override
    public void run(String... args) throws Exception {
        List<Order> orders = createOrdersDataSet();
        List<Vehicle> vehicles = createVehicleDataSet();

        UUID problemId = UUID.randomUUID();
        VehicleRoutingSolution problem = new VehicleRoutingSolution(orders, vehicles);
        // Submit the problem to start solving
        SolverJob<VehicleRoutingSolution, UUID> solverJob = solverManager.solve(problemId, problem);
        VehicleRoutingSolution solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }

        log.info("Your best score is: {}", solution.getScore());

    }

    private static List<Order> createOrdersDataSet() {
        //        Create orders
        Order order1 = new Order(1L, 4, 7, new com.example.vrp.domain.Location(33.593119, -7.565356));


        Order order2 = new Order(2L, 2, 4, new com.example.vrp.domain.Location(33.592789, -7.576738));

        Order order3 = new Order(3L, 4,5, new com.example.vrp.domain.Location(33.585407, -7.564818));

        Order order4 = new Order(4L, 3, 5, new com.example.vrp.domain.Location(33.586326, -7.549472));

        Order order5 = new Order(5L, 5, 6, new com.example.vrp.domain.Location(33.590619, -7.553917));

        Order order6 = new Order(6L, 1, 3, new com.example.vrp.domain.Location(33.600171, -7.582712));

        Order order7 = new Order(7L, 6, 8, new com.example.vrp.domain.Location(33.590383, -7.584241));

        Order order8 = new Order(8L, 4, 7, new com.example.vrp.domain.Location(33.584369, -7.592311));

        Order order9 = new Order(9L, 2, 5, new com.example.vrp.domain.Location(33.570600, -7.582643));

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        orders.add(order8);
        orders.add(order9);
        return orders;
    }

    private static List<Vehicle> createVehicleDataSet() {
        Vehicle v1 = new Vehicle(1L, 20, 15);


        Vehicle v2 =new Vehicle(1L, 15, 10);

        return Stream.of(v1, v2)
                .toList();


    }
}
