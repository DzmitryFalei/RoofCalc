package com.example.roofcalc.db;

import java.util.Optional;

public interface Dao <T>{
    public Optional<T> get(int id);
}
