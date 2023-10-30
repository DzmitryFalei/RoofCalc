package com.example.roofcalc;

import com.example.roofcalc.db.MaterialDao;
import com.example.roofcalc.db.RoofDao;
import com.example.roofcalc.db.TerrainDao;
import com.example.roofcalc.db.dao.MaterialConnect;
import com.example.roofcalc.db.dao.RoofConnect;
import com.example.roofcalc.db.dao.TerrainConnect;
import com.example.roofcalc.model.Material;
import com.example.roofcalc.model.Roof;
import com.example.roofcalc.model.Terrain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

    private int cbTerritoryValue;
    double tfHeightValue;
    double windSpeedValue = 23;
    @FXML
    private Button btnStart;
    @FXML
    private TextField tfHeight;
    @FXML
    private ChoiceBox<String> cbTerritory;
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

    private TerrainDao<Terrain> terrainDao;
    private MaterialDao<Material> materialDao;
    private RoofDao<Roof> roofDao;

    @FXML
    public void initialize(){
        tfHeight.setText("5");
        btnStart.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            cbTerritoryValue = Integer.parseInt(cbTerritory.getValue());
            terrainDao = new TerrainConnect();
            Terrain terrain = terrainDao.getTerrain(cbTerritoryValue - 1).get();

            tfHeightValue = Double.parseDouble(tfHeight.getText());

            WindCalc windCalc = new WindCalc(terrain.getRoughnessZo(), tfHeightValue, windSpeedValue);
            double pressureQpZ = windCalc.getPressureQpZ();

            materialDao = new MaterialConnect();
            Material material = materialDao.getMaterial(0).get();
            int tearResistance = material.getTearResistance();
            int tensileStrength = material.getTensileStrength();

            roofDao = new RoofConnect();
            Roof roof = roofDao.getRoof(0).get();
            double fCpe1 = roof.getCoefficientFCpe1();
            double gCpe1 = roof.getCoefficientGCpe1();
            double hCpe1 = roof.getCoefficientHCpe1();
            double iCpe1 = roof.getCoefficientICpe1();

            NumberOfAnchorsCalc anchorsCalc = new NumberOfAnchorsCalc(pressureQpZ, tearResistance);
            tfFCpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(fCpe1)));
            tfGCpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(gCpe1)));
            tfHCpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(hCpe1)));
            tfICpePerMeter.setText(String.valueOf(anchorsCalc.getNumberOfAnchors(iCpe1)));

            FasteningPitch fasteningPitch = new FasteningPitch(pressureQpZ, tensileStrength, tearResistance);
            tfFCpeStep.setText(String.valueOf(fasteningPitch.getFasteningPitch(fCpe1)));
            tfGCpeStep.setText(String.valueOf(fasteningPitch.getFasteningPitch(gCpe1)));
            tfHCpeStep.setText(String.valueOf(fasteningPitch.getFasteningPitch(hCpe1)));
            tfICpeStep.setText(String.valueOf(fasteningPitch.getFasteningPitch(iCpe1)));

            System.out.println(anchorsCalc.getNumberOfAnchors(fCpe1));
            System.out.println(anchorsCalc.getNumberOfAnchors(gCpe1));
            System.out.println(anchorsCalc.getNumberOfAnchors(hCpe1));
            System.out.println(anchorsCalc.getNumberOfAnchors(iCpe1));
        });
    }

}