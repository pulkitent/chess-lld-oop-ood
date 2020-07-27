package models.entities;

import models.enums.PieceType;

import java.util.List;
import java.util.Map;

public class Players {
    private final Map<PieceType, List<Pieces>> army;

    public Players(Map<PieceType, List<Pieces>> army, ChessBoard board) {
        this.army = army;
    }

    void playNextMove(PieceType pieceType, Cell initialCell, Cell finalCell) {
        List<Pieces> piecesList = army.get(pieceType);

        for (Pieces soldier : piecesList) {
            if (!soldier.isAlive()) {
                continue;
            }

            if (soldier.isPresentAtGivenCell(initialCell)) {
                soldier.moveToGivenCell(finalCell);
                return;
            }
        }
    }
}