package com.example.roofcalc.db;

import java.util.Optional;

public interface MaterialDao<MaterialDao> {
    public Optional<MaterialDao> getMaterial(int materialDataId);

}
