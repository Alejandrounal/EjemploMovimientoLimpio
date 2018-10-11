/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenario;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Alejandro
 */
public class Escenario extends Application{

    @Override
    public void start(Stage stage) throws Exception {
     Pane cuadro = new Pane();
     Canvas canvas = new Canvas(1024,512);
     cuadro.getChildren().add(canvas);
     Scene escena = new Scene(cuadro,1024,512,Color.BEIGE);
     
    GraphicsContext lapiz = canvas.getGraphicsContext2D();
    
    Movimiento mover = new Movimiento(lapiz);
    mover.start();
    
    stage.setScene(escena);
    stage.show();
    }
     
    public static void main(String[] args) {
        Application.launch(args);
    }
}
