/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package percabanganjfx3.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import percabanganjfx3.Models.PercabanganJFX3Model;

/**
 *
 * @author Muhamad Ariq Rasyid
 */
public class PercabanganJFX3Controller implements Initializable {

    private final PercabanganJFX3Model dt = new PercabanganJFX3Model();

    @FXML
    private TextField txtlama;
    @FXML
    private TextField txttotal;
    @FXML
    private Button btnhitung;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    @FXML
    private ComboBox<String> cmbdepartemen;
    @FXML
    private ComboBox<String> chbjabatan;
    @FXML
    private ListView<String> lstgolongan;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbdepartemen.setItems(FXCollections.observableArrayList(
                "Gudang", "Penjualan", "Keuangan"));
        chbjabatan.setItems(FXCollections.observableArrayList(
                "kayawan", "supervisor", "manajer"));
        lstgolongan.setItems(FXCollections.observableArrayList(
                "III-A", "III-Cr", "IV-A"));
    }

    @FXML
    private void hitungklik(ActionEvent event) {
        dt.setLama(Integer.parseInt(txtlama.getText()));
        dt.setPilihdpt(cmbdepartemen.getSelectionModel().selectedIndexProperty().intValue());
        dt.setPilihjbt(chbjabatan.getSelectionModel().selectedIndexProperty().intValue());
        dt.setPilihgol(lstgolongan.getSelectionModel().selectedIndexProperty().intValue());
        int biaya;
        switch (dt.getPilihdpt()) {
            case 0:
                biaya = 500000;
                break;
            case 1:
                biaya = 1000000;
                break;
            case 2:
                biaya = 700000;
                break;
            default:
                biaya = 0;
        }
        int gapok;
        switch (dt.getPilihjbt()) {
            case 0:
                gapok = 2000000;
                break;
            case 1:
                gapok = 3000000;
                break;
            case 2:
                gapok = 5000000;
                break;
            default:
                gapok = 0;
        }
        int tunj;
        switch (dt.getPilihgol()) {
            case 0:
                tunj = 500000;
                break;
            case 1:
                tunj = 1000000;
                break;
            case 2:
                tunj = 2000000;
                break;
            default:
                tunj = 0;
        }
        int total = gapok + biaya + tunj * dt.getLama();
        txttotal.setText(String.valueOf(total));
    }

    @FXML
    private void hapusklik(ActionEvent event) {
        {
            cmbdepartemen.setValue("");
            chbjabatan.valueProperty().set(null);
            lstgolongan.getSelectionModel().clearSelection();
            txtlama.setText("");
            txttotal.setText("");
            txtlama.requestFocus();

        }
    }

    @FXML
    private void keluarklik(ActionEvent event
    ) {
        System.exit(0);
    }

}
