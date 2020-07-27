package models.entities;

import java.util.List;

public class ChessBoard {
    private final List<Cell> cells;

    public ChessBoard(List<Cell> cells) {
        this.cells = cells;
    }
}