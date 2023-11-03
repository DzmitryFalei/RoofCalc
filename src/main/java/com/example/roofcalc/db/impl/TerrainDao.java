package com.example.roofcalc.db.impl;

import com.example.roofcalc.model.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TerrainDao implements com.example.roofcalc.db.Dao {

    private List<Terrain> terrains = new ArrayList<>();

    public TerrainDao() {
        terrains.add(new Terrain(0.01));
        terrains.add(new Terrain(0.05));
        terrains.add(new Terrain(0.3));
        terrains.add(new Terrain(1.0));
    }
    @Override
    public Optional<Terrain> get(int terrainDataId) {
        return Optional.ofNullable(terrains.get(terrainDataId));
    }
}
