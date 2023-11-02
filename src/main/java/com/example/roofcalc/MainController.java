package com.example.roofcalc;

import com.example.roofcalc.calc.FasteningPitchCalc;
import com.example.roofcalc.calc.NumberOfAnchorsCalc;
import com.example.roofcalc.calc.WindCalc;
import com.example.roofcalc.db.MaterialDao;
import com.example.roofcalc.db.RoofDao;
import com.example.roofcalc.db.TerrainDao;
import com.example.roofcalc.db.impl.MaterialConnect;
import com.example.roofcalc.db.impl.RoofConnect;
import com.example.roofcalc.db.impl.TerrainConnect;
import com.example.roofcalc.model.Material;
import com.example.roofcalc.model.Roof;
import com.example.roofcalc.model.Terrain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

    private int cbTerritoryValue;
    private String cbRoofValue;
    private int roofId;
    private double tfHeightValue;
    private double windSpeedValue = 23;
    private final static int MAX_HEIGHT_VALUE = 200;
    private final static int MIN_HEIGHT_VALUE = 1;

    @FXML
    private Button btnStart;
    @FXML
    private TextField tfHeight;
    @FXML
    private ChoiceBox<String> cbTerritory;
    @FXML
    private ChoiceBox<String> cbRoof;
    @FXML
    private TextField tfFCpePerMeter;
    @FXML
    private TextField tfGCpePerMeter;
    @FXML
    private TextField tfHCpePerMeter;
    @FXML
    private TextField tfICpePerMeter;
    @FXML
    private TextField tfFCpeStep;
    @FXML
    private TextField tfGCpeStep;
    @FXML
    private TextField tfHCpeStep;
    @FXML
    private TextField tfICpeStep;
    @FXML
    private Label lbError;


    private TerrainDao<Terrain> terrainDao;
    private MaterialDao<Material> materialDao;
    private RoofDao<Roof> roofDao;

    @FXML
    public void initialize(){
        tfHeight.setText("5");
        lbError.setText("");

        btnStart.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            if (tfHeight.getText().matches("\\d+")) {
                tfHeightValue = Double.parseDouble(tfHeight.getText());
                if (tfHeightValue < MIN_HEIGHT_VALUE || tfHeightValue > MAX_HEIGHT_VALUE) {
                    lbError.setText("Ошибка!");
                    return;
                }
                lbError.setText(" ");
            } else {
                lbError.setText("Ошибка!");
                return;
            }

            cbTerritoryValue = Integer.parseInt(cbTerritory.getValue());
            terrainDao = new TerrainConnect();
            Terrain terrain = terrainDao.getTerrain(cbTerritoryValue - 1).get();

            WindCalc windCalc = new WindCalc(terrain.getRoughnessZo(), tfHeightValue, windSpeedValue);
            double pressureQpZ = windCalc.getPressureQpZ();

            materialDao = new MaterialConnect();
            Material material = materialDao.getMaterial(0).get();
            int tearResistance = material.getTearResistance();
            int tensileStrength = material.getTensileStrength();

            cbRoofValue = cbRoof.getValue();
            switch (cbRoofValue) {
                case "плоская" -> roofId = 0;
                case "скатная" -> roofId = 1;
                case "мансарда" -> roofId = 2;
            }

            roofDao = new RoofConnect();
            Roof roof = roofDao.getRoof(roofId).get();
            double fCpe1 = roof.getCoefficientFCpe1();
            double gCpe1 = roof.getCoefficientGCpe1();
            double hCpe1 = roof.getCoefficientHCpe1();
            double iCpe1 = roof.getCoefficientICpe1();

            NumberOfAnchorsCalc anchorsCalc = new NumberOfAnchorsCalc(pressureQpZ, tearResistance);
            tfFCpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(fCpe1)));
            tfGCpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(gCpe1)));
            tfHCpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(hCpe1)));
            tfICpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(iCpe1)));

            FasteningPitchCalc fasteningPitchCalc = new FasteningPitchCalc(pressureQpZ, tensileStrength, tearResistance);
            tfFCpeStep.setText(String.valueOf(fasteningPitchCalc.getFasteningPitch(fCpe1)));
            tfGCpeStep.setText(String.valueOf(fasteningPitchCalc.getFasteningPitch(gCpe1)));
            tfHCpeStep.setText(String.valueOf(fasteningPitchCalc.getFasteningPitch(hCpe1)));
            tfICpeStep.setText(String.valueOf(fasteningPitchCalc.getFasteningPitch(iCpe1)));
        });

    }

}