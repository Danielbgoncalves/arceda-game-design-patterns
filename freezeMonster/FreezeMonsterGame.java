package freezeMonster;

import java.awt.EventQueue;

import spriteframework.AbstractBoard;
import spriteframework.MainFrame;

public class FreezeMonsterGame extends MainFrame {
	private static final EngineCommons config = new EngineCommons();


	public FreezeMonsterGame() {
		super("Freeze Monster", config);
	}
	
	protected AbstractBoard createBoard() {
		return new FreezeMonsterBoard(config);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			new FreezeMonsterGame();
		});
	}
}
