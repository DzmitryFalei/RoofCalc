package com.example.roofcalc.db.dao;

import com.example.roofcalc.model.Roof;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoofConnect implements com.example.roofcalc.db.RoofDao {

    private List<Roof> roofs = new ArrayList<>();

    public RoofConnect() {
        roofs.add(new Roof(-2.5, -2.0, -1.2, -0.2));
    }

    @Override
    public Optional<Roof> getRoof(int roofDataId) {
        return Optional.ofNullable(roofs.get(roofDataId));
    }
}
