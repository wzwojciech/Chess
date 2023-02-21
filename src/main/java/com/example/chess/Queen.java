package com.example.chess;

import com.example.chess.Figure;
import com.example.chess.FigureColor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Figure {

    public Queen(FigureColor color) {
        super(color);
    }

    public static ImageView getImage(FigureColor color) {
        if (color == FigureColor.WHITE) {
            Image whiteQueen = new Image("whiteQ.gif");
            ImageView whiteQ = new ImageView(whiteQueen);
            whiteQ.setFitHeight(80);
            whiteQ.setFitWidth(80);
            return whiteQ;
        } else {
            Image blackQueen = new Image("blackQ.gif");
            ImageView blackQ = new ImageView(blackQueen);
            blackQ.setFitHeight(80);
            blackQ.setFitWidth(80);
            return blackQ;
        }
    }
}
