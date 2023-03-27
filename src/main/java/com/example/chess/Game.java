package com.example.chess;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.example.chess.FigureColor.WHITE;
import static javafx.scene.paint.Color.GRAY;
import static javafx.scene.paint.Color.YELLOW;

public class Game {
    private Board board;
    private GridPane gridPane;
    private int oldX = -1;
    private int oldY = -1;
    private FigureColor whichMove = WHITE;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }
        public void showBoard() {
            gridPane.getChildren().clear();
            Color[] squareColors = new Color[]{Color.GREEN, GRAY, YELLOW};
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    Color squareColor = squareColors[(row + col) % 2];
                    if (col == oldX && row == oldY)
                        squareColor = squareColors[2];
                    gridPane.add(new Rectangle(80, 80, squareColor), col, row);
                }
            }
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    if (board.getFigure(x, y) instanceof Pawn) {
                        if (board.getFigure(x, y).getColor().equals(FigureColor.BLACK)) {
                            gridPane.add(Pawn.getImage(board.getFigure(x, y).getColor()), x, y);
                        } else {
                            gridPane.add(Pawn.getImage(board.getFigure(x, y).getColor()), x, y);
                        }
                    } else if (board.getFigure(x, y) instanceof Queen) {
                        if (board.getFigure(x, y).getColor().equals(FigureColor.BLACK)) {
                            gridPane.add(Queen.getImage(board.getFigure(x, y).getColor()), x, y);
                        } else {
                            gridPane.add(Queen.getImage(board.getFigure(x, y).getColor()), x, y);
                        }
                    }
                }
            }
        }

    public void doClick(int x, int y) {
        if (oldX == -1) {
            if (!(board.getFigure(x, y) instanceof None) && (board.getFigure(x, y).getColor() == whichMove)) {
                oldX = x;
                oldY = y;
            }
        } else {
            if (oldX != x || oldY != y) {
                if (board.move(oldX, oldY, x, y)) {
                    whichMove = getOposite(whichMove);
                }
                oldX = -1;
                oldY = -1;
            }
        }
        showBoard();
    }
        private FigureColor getOposite(FigureColor color) {
                    if (color == WHITE)
                        return FigureColor.BLACK;
                    return WHITE;
                }
    }




