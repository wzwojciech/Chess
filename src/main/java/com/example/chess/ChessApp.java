package com.example.chess;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.GRAY;

public class ChessApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Board board = new Board();

        board.initBoard();
        GridPane gridPane = new GridPane();

        gridPane.setPrefSize(80, 80);
        gridPane.setGridLinesVisible(true);

        int numCols = 8, numRows = 8;
        int SQUARE_SIZE = 8;

        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setMinWidth(SQUARE_SIZE);
            colConstraints.setMaxWidth(SQUARE_SIZE);
            colConstraints.setPrefWidth(SQUARE_SIZE);
            colConstraints.setHalignment(HPos.CENTER);
            colConstraints.setPercentWidth(100.0 / numCols);
            gridPane.getColumnConstraints().add(colConstraints);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setMinHeight(SQUARE_SIZE);
            rowConstraints.setPrefHeight(SQUARE_SIZE);
            rowConstraints.setMaxHeight(SQUARE_SIZE);
            rowConstraints.setValignment(VPos.CENTER);
            rowConstraints.setPercentHeight(100.0 / numRows);
            gridPane.getRowConstraints().add(rowConstraints);
        }

        Color[] squareColors = new Color[]{Color.GREEN, GRAY};
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                gridPane.add(new Rectangle(80, 80, squareColors[(row + col) % 2]), col, row);
            }
        }

        Scene scene = new Scene(gridPane, 700, 700);

        Game game = new Game(board, gridPane);
        gridPane.setOnMouseClicked(e -> {
            int x = (int) (e.getX() / 87);
            int y = (int) (e.getY() / 87);
            System.out.println(e.getX() + " " + e.getY());
            System.out.println(x + " " + y);
            game.doClick(x, y);
        });
        game.showBoard();
        primaryStage.setTitle("CheckersApp");
        primaryStage.setScene(scene);
        primaryStage.show();
   }

}

