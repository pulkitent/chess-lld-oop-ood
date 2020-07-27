package models.moves;

import models.entities.Cell;
import models.enums.MoveType;

public class CardinalMove extends Move {

    public CardinalMove(MoveType moveType) {
        super(moveType);
    }

    @Override
    public Boolean isAValidMove(Cell initialCell, Cell finalCell) {
        //TODO: To be implemented
        return null;
    }
}