package models.entities;

import models.enums.ArmyType;
import models.enums.PieceType;
import models.enums.StatusType;
import models.moves.Move;

import java.util.List;
import java.util.Objects;

public class Pieces {
    private final PieceType pieceType;
    private final List<Move> moves;
    private final ArmyType armyType;
    private StatusType statusType;
    private final boolean isFirstMoveDone;
    private Cell cell;

    public Pieces(PieceType pieceType, List<Move> moves, ArmyType armyType, StatusType statusType,
                  boolean isFirstMoveDone, Cell cell) {
        this.pieceType = pieceType;
        this.moves = moves;
        this.armyType = armyType;
        this.statusType = statusType;
        this.isFirstMoveDone = isFirstMoveDone;
        this.cell = cell;
    }

    public ArmyType getArmyType() {
        return armyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pieces)) return false;
        Pieces pieces = (Pieces) o;
        return pieceType == pieces.pieceType &&
                armyType == pieces.armyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType, armyType);
    }

    void die() {
        this.statusType = StatusType.DEAD;
    }

    void moveToGivenCell(Cell destinationCell) {
        for (Move move : moves) {
            if (move.isAValidMove(this.cell, destinationCell)) {
                if (isDestinationCellAlreadyOccupiedByUs(this.cell)) {
                    System.out.println("models.entities.Cell already occupied by our army");
                    continue;
                }

                if (isDestinationCellOccupiedByEnemy(destinationCell)) {
                    killTheEnemy(destinationCell);
                }
                this.cell = destinationCell;
                return;
            }
        }
    }

    Boolean isPresentAtGivenCell(Cell cell) {
        return this.cell.equals(cell);
    }

    Boolean isAlive() {
        return this.statusType.equals(StatusType.ALIVE);
    }

    private void killTheEnemy(Cell destinationCell) {
        destinationCell.killPiece();
    }

    private Boolean isDestinationCellAlreadyOccupiedByUs(Cell cell) {
        return !cell.isEmpty();
    }

    private Boolean isDestinationCellOccupiedByEnemy(Cell cell) {
        return cell.isCurrentCellOccupiedByEnemy(this.armyType);
    }
}