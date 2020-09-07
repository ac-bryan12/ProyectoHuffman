/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohuffman;


import TDAS.ArbolHuffman;
import TDAS.Util;
import java.io.File;
import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Bryan
 */
public final class VentanaMenu {
    final FileChooser fileChooser = new FileChooser();
    public static BorderPane root = new BorderPane();
    public static HBox top = new HBox();

    public VentanaMenu() {
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #ffffff;");
        crearPanelTop();
        center();
        
    }

    
    public void center() {
        VBox parteExterna = new VBox();
        HBox mensaje = new HBox();
        Label msg1 = new Label("Seleccione la opcion que desea");
        mensaje.getChildren().addAll(msg1);
        mensaje.setAlignment(Pos.CENTER);

        Button btnComprimir = new Button("COMPRIMIR");
        Button btnDescomprimir = new Button("DESCOMPRIMIR");
        
        HBox parteBoton = new HBox(btnComprimir,btnDescomprimir);
        parteBoton.setAlignment(Pos.CENTER);
        parteBoton.setSpacing(10);
        parteExterna.getChildren().addAll(mensaje, parteBoton);

        parteExterna.setAlignment(Pos.CENTER);
        parteExterna.setSpacing(15);
        root.setCenter(parteExterna);
        
        btnComprimir.setOnMouseClicked((event) -> {
             VBox parteExterna2 = new VBox(); 
             Label archvit = new Label("Nombre del Archivo: ");
             TextField txtArchivo = new TextField();
             HBox partArchivo = new HBox(archvit,txtArchivo);
             partArchivo.setAlignment(Pos.CENTER);
             partArchivo.setSpacing(10);
             Button btnConfirmar = new Button("CONFIRMAR");
             Button btn2 = new Button("Siguiente");
             HBox parteBoton2 = new HBox(btnConfirmar);
             HBox parteBoton3 = new HBox(btn2);
             parteBoton2.setAlignment(Pos.CENTER);
             parteExterna2.getChildren().addAll(partArchivo, parteBoton2);
             parteExterna2.setSpacing(10);
             parteExterna2.setAlignment(Pos.CENTER);
             root.setCenter(parteExterna2);
            
            btnConfirmar.setOnMouseClicked((e) -> {
                FileChooser fc = new FileChooser();
                fc.setTitle("Seleccionar un archivo");
                Window Stage = null;
                File selectedFile = fc.showOpenDialog(Stage);
//                File fc.getSelectedExtensionFilter();
//                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT FILES"));
                if(selectedFile != null){
                    txtArchivo.setText(selectedFile.getPath());
                    String  texto = Util.leerTexto(selectedFile.getPath());
                    System.out.println(texto);
                    HashMap<String,Integer> mapa =Util.calcularFrecuencias(texto);
                    ArbolHuffman<String> arbol = new ArbolHuffman();
                    System.out.println(arbol);
                    arbol.calcularArbol(mapa);
                    arbol.calcularCodigos();
                    System.out.println(mapa);
                    
                    
                }
                else{
                    txtArchivo.setText("File selection cancelled");
                }
                        
            });
            btn2.setOnMouseClicked((e) -> {
                
                
                
                
            });
            
        });
        
        
        
        
        
        btnDescomprimir.setOnMouseClicked((event) -> {
             VBox parteExterna2 = new VBox(); 
             Label archvit = new Label("Nombre del Archivo: ");
             TextField txtArchivo = new TextField();
             HBox partArchivo = new HBox(archvit,txtArchivo);
             partArchivo.setAlignment(Pos.CENTER);
             partArchivo.setSpacing(10);
             Button btnConfirmar = new Button("CONFIRMAR");
             Button btn2 = new Button("Siguiente");
             HBox parteBoton2 = new HBox(btnConfirmar);
             HBox parteBoton3 = new HBox(btn2);
             parteBoton2.setAlignment(Pos.CENTER);
             parteExterna2.getChildren().addAll(partArchivo, parteBoton2);
             parteExterna2.setSpacing(10);
             parteExterna2.setAlignment(Pos.CENTER);
             root.setCenter(parteExterna2);
            
            btnConfirmar.setOnMouseClicked((e) -> {
                FileChooser fc = new FileChooser();
                fc.setTitle("Seleccionar un archivo");
                Window Stage = null;
                File selectedFile = fc.showOpenDialog(Stage);
//                File fc.getSelectedExtensionFilter();
//                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT FILES"));
                if(selectedFile != null){
                    txtArchivo.setText(selectedFile.getPath());
                    
                }
                else{
                    txtArchivo.setText("File selection cancelled");
                }        
            });
            btn2.setOnMouseClicked((e) -> {
                
                
                
                
            });
            
        });
    }
    

    
     public void crearPanelTop() {
        Label icono = new Label("MENÚ DE OPCIONES");
        icono.setTextFill(Color.WHITE);
        VBox iconoBox = new VBox(icono);
        top.getChildren().add(iconoBox);
        top.setStyle("-fx-background-color: #5ce0d3;");
        top.setAlignment(Pos.CENTER);
        root.setTop(top);
     }
     
    
 
        
    public static BorderPane getRoot() {
        return root;
    }
    
}
