package com.example.vrp;

import com.example.vrp.domain.Vehicle;
import org.optaplanner.core.api.score.buildin.hardsoftlong.HardSoftLongScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

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
public class VehicleRoutingConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                // Hard constraints
                vehicleCapacity(constraintFactory),
                // Soft constraints
        };
    }



    protected Constraint vehicleCapacity(ConstraintFactory factory) {
        return factory.forEach(Vehicle.class)
                .filter(vehicle -> vehicle.getTotalVolumeCapacity() > vehicle.getVolumeCapacity())
                .penalizeLong(HardSoftLongScore.ONE_HARD,
                              vehicle -> vehicle.getTotalVolumeCapacity() - vehicle.getVolumeCapacity())
                .asConstraint("vehicleCapacity");
    }
}
