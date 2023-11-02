package com.example.roofcalc.invisible;

import com.example.roofcalc.model.Roof;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class dbInit {
    public static final String DB_PATH = "src//main//resources//RoofDB.txt";

//    public static void main(String[] args) {
//
//        List<Roof> roofs = new ArrayList<>();
//        roofs.add(new Roof(-2.5, -2.0, -1.2, -0.2));
//        roofs.add(new Roof(-2.0, -1.6, -1.2, -0.2));
//        roofs.add(new Roof(-1.8, -1.9, -0.4, -0.2));
//
//        Gson gson = new Gson();
//        String myJsonRoofs = gson.toJson(roofs);
//
//        try {
//            PrintWriter writer = new PrintWriter(DB_PATH);
//            writer.println(myJsonRoofs);
//            writer.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return;
//        }
//    }
}
