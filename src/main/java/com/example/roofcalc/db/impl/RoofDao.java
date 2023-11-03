package com.example.roofcalc.db.impl;

import com.example.roofcalc.model.Roof;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoofDao implements com.example.roofcalc.db.Dao {

    public static final String DB_PATH = "src//main//resources//RoofDB.txt";
    private List<Roof> roofs = new ArrayList<>();

    public RoofDao() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String dbDataJson;

        try {
            dbDataJson = new String(Files.readAllBytes(Paths.get(DB_PATH)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        roofs = gson.fromJson(dbDataJson, new TypeToken<List<Roof>>() {
        }.getType());
    }

    @Override
    public Optional<Roof> get(int roofDataId) {
        return Optional.ofNullable(roofs.get(roofDataId));
    }
}
