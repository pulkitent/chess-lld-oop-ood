package models.entities;

import models.enums.ArmyType;

import java.util.Objects;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;
    private final Pieces chessPiece;

    public Cell(int xCoordinate, int yCoordinate, Pieces chessPiece) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.chessPiece = chessPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return xCoordinate == cell.xCoordinate &&
                yCoordinate == cell.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }

    Boolean isEmpty() {
        return chessPiece == null;
    }

    Boolean isCurrentCellOccupiedByEnemy(ArmyType pieceType) {
        return !pieceType.equals(this.chessPiece);
    }

    void killPiece() {
        this.chessPiece.die();
    }
}