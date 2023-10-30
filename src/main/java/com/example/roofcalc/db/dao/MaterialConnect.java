package com.example.roofcalc.db.dao;

import com.example.roofcalc.model.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialConnect implements com.example.roofcalc.db.MaterialDao {

    private List<Material> materials = new ArrayList<>();

    public MaterialConnect() {
        materials.add(new Material("Default", 600, 150));
    }

    @Override
    public Optional<Material> getMaterial(int materialDataId) {
        return Optional.ofNullable(materials.get(materialDataId));
    }
}
