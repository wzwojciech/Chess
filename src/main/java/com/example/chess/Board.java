package com.example.chess;


public class Board {
    private static Figure[][] board = new Figure[8][8];

    public Board() {
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++)
                board[x][y] = new None();
    }

    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    public void setFigure(Figure figure, int x, int y) {
        board[x][y] = figure;
    }

    public void initBoard() {
        int x, y;
        for (y = 0; y < 8; y++) {
            for (x = 0; x < 8; x++)
                setFigure(new None(), x, y);
        }
        for (x = 1; x<8; x+=2){
            setFigure(new Pawn(FigureColor.BLACK), x, 1);
            setFigure(new Pawn(FigureColor.WHITE), x, 5);
            setFigure(new Pawn(FigureColor.WHITE), x, 7);

        }
        for (x = 0; x<8; x+=2){
            setFigure(new Pawn(FigureColor.BLACK), x, 0);
            setFigure(new Pawn(FigureColor.WHITE), x, 2);
            setFigure(new Pawn(FigureColor.WHITE), x, 6);

        }
    }
}
