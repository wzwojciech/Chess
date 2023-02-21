package com.example.chess;

import javafx.scene.layout.StackPane;

public class Figure extends StackPane {
    private FigureColor color;

    public Figure(FigureColor color){
        this.color = color;
    }

    public FigureColor getColor(){
        return color;
    }
}