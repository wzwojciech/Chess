package com.example.chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Figure {

    public Pawn(FigureColor color) {
        super(color);
    }

    public static ImageView getImage(FigureColor color) {
        if (color == FigureColor.WHITE) {
            Image whitePawn = new Image("white.gif");
            ImageView whiteP = new ImageView(whitePawn);
            whiteP.setFitWidth(80);
            whiteP.setFitHeight(80);
            return whiteP;
        } else {
            Image blackPawn = new Image("black.gif");
            ImageView blackP = new ImageView(blackPawn);
            blackP.setFitHeight(80);
            blackP.setFitWidth(80);
            return blackP;
        }
    }
}
