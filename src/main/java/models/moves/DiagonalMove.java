package models.moves;

import models.entities.Cell;
import models.enums.MoveType;

public class DiagonalMove extends Move {

    public DiagonalMove(MoveType moveType) {
        super(moveType);
    }

    @Override
    public Boolean isAValidMove(Cell initialCell, Cell finalCell) {
        //TODO: To be implemented
        return null;
    }
}
