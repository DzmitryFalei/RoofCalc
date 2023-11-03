package com.example.roofcalc.db.impl;

import com.example.roofcalc.model.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialDao implements com.example.roofcalc.db.Dao {

    private List<Material> materials = new ArrayList<>();

    public MaterialDao() {
        materials.add(new Material("Default", 600, 150));
    }

    public Optional<Material> get(int id) {
        return Optional.ofNullable(materials.get(id));
    }
}
