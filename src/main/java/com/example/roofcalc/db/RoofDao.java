package com.example.roofcalc.db;

import java.util.Optional;

public interface RoofDao<Roof> {
    public Optional<Roof> getRoof(int roofDataId);
}
