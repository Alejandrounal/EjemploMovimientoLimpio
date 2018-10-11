/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenario;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;

/**
 *
 * @author Alejandro
 */
 

public class Movimiento extends AnimationTimer {
private GraphicsContext lapiz;
private Image fondo;
private Image fondo2;
private int varFondo = 1024;
private Image gato;
private int movgato = 0;
private int lento = 0;
private int movimiento = 0;
private String puntaje;
private Image mun;
private Image mun2;
private int numero=0;
private int lejos = 400;
private int lejos2 = 400;


    public Movimiento(GraphicsContext lapiz) {
        this.lapiz = lapiz;
        this.fondo = new Image("Ima/image/fondo.png");
        this.fondo2 = new Image("Ima/image/fondo.png");
        this.gato = new Image("Ima/image/cats.gif");
        this.mun = new Image("Ima/image/down0.png");
        this.mun2  = new Image("Ima/image/down1.png");
        
        
    }

    @Override
    public void handle(long l) {
      lapiz.clearRect(0, 0, 1024,512);
      lapiz.drawImage(fondo, varFondo-1024, 0);
      lapiz.drawImage(fondo2, varFondo, 0);
      if (varFondo < 0)
          varFondo = 1024;
      else varFondo -=10;
      lapiz.drawImage(this.gato, movgato*132, 0, 132, 80, movimiento, 400, 132, 80);
      lapiz.drawImage(mun,300 , lejos);
     lapiz.drawImage(mun2, 700, lejos2);
     lento++;
     if(lento%5==0) 
      if (movgato == 5)
          movgato= 0;
      else
          movgato++;
     if (movimiento < 1024)
        movimiento++;     
     else
         movimiento = 0;
     lapiz.strokeText("Veces", 800, 100);
     lapiz.strokeText(Integer.toString(numero), 850, 100);
     
     
     Shape mun0 = new Rectangle(300,lejos,30,39);
     Shape mun1 = new Rectangle(700,lejos2,30,39);
     Shape gato = new Rectangle(movimiento,400,132,80);
     Shape interseccion = SVGPath.intersect(gato,mun0);
     Shape interseccion2 = SVGPath.intersect(gato, mun1);
     if(interseccion.getBoundsInLocal().getWidth() > 1){
         numero++;
          lejos = 5000;
         
        
     }
     if(interseccion2.getBoundsInLocal().getWidth()>1){
         numero++;
         lejos2 = 5000;
           
     }
     
     if (movimiento == 1024){
         lejos = 400;
         lejos2 = 400;
         
     }
     
    }
    
    
    
}
