package models.moves;

import models.entities.Cell;
import models.enums.MoveType;

public class PawnMove extends Move {

    public PawnMove(MoveType moveType) {
        super(moveType);
    }

    @Override
    public Boolean isAValidMove(Cell initialCell, Cell finalCell) {
        //TODO: To be implemented
        return null;
    }
}