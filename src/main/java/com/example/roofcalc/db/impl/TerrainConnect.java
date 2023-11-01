package com.example.roofcalc.db.impl;

import com.example.roofcalc.model.Terrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TerrainConnect implements com.example.roofcalc.db.TerrainDao {

    private List<Terrain> terrains = new ArrayList<>();

    public TerrainConnect() {
        terrains.add(new Terrain(0.01));
        terrains.add(new Terrain(0.05));
        terrains.add(new Terrain(0.3));
        terrains.add(new Terrain(1.0));
    }
    @Override
    public Optional<Terrain> getTerrain(int terrainDataId) {
        return Optional.ofNullable(terrains.get(terrainDataId));
    }
}
