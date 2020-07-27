package models.moves;

import models.entities.Cell;
import models.enums.MoveType;

public abstract class Move {
    private final MoveType moveType;

    public Move(MoveType moveType) {
        this.moveType = moveType;
    }

    public abstract Boolean isAValidMove(Cell initialCell, Cell finalCell);

}