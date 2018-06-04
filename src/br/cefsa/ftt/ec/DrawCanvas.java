package br.cefsa.ftt.ec;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @web http://java-buddy.blogspot.com/
 * 
 * Fonte: https://stackoverflow.com/questions/43429251/how-to-draw-a-continuous-line-with-mouse-on-javafx-canvas
 *
 * TODO: Refactoring...
 * TODO: Criar botão e abrir diálogo para mudar a cor da caneta
 * TODO: Criar desenho com base em linhas e clicks do mouse
 * TODO: Criar botão para salvar a imagem
 * 
 * Referência: Java Como Programar, Deitel - Cap 13 Java FX GUI: Part 2
 * Referência: https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm
 * Referência: https://docs.oracle.com/javafx/2/text/jfxpub-text.htm
 * 
 */

public class DrawCanvas extends Application {

    @Override
    public void start(Stage primaryStage) {

        Canvas canvas = new Canvas(800, 600);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        initDraw(graphicsContext);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, 
                new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                graphicsContext.beginPath();
                graphicsContext.moveTo(event.getX(), event.getY());
                graphicsContext.stroke();
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
                new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                graphicsContext.lineTo(event.getX(), event.getY());
                graphicsContext.stroke();
            }
        });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, 
                new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {

            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    } //start

    public static void main(String[] args) {
        launch(args);
    } //main

    private void initDraw(GraphicsContext gc){
    	
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        gc.setFill(Color.LIGHTGRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);

        gc.fill();
        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvasWidth,    //width of the rectangle
                canvasHeight);  //height of the rectangle

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);

    } //initDraw

} //DrawCanvas