package spaceinvaders;

import java.awt.EventQueue;

import spriteframework.AbstractBoard;
import spriteframework.MainFrame;

public class SpaceInvadersGame extends MainFrame {
	private static final SpaceCommons config = new SpaceCommons();


	public SpaceInvadersGame () {
		super("Space Invaders", config);
	}
	
	protected  AbstractBoard createBoard() {
		//SpaceCommons config = new SpaceCommons();
		return new SpaceInvadersBoard(config);
	}


	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			new SpaceInvadersGame();
		});
	}

}

/** A SER REALIZADO
 *  1- mudar alien para monstros
 *  2- fazer mosntros andares em vários directions
 *  3- colocar woody
 *  4- congelar monstros, não só sumir
 *  5- mudar a img de fundo (p/ uma com nuvens brancas!)
 *
 */

/** TA FAZIDO !
 * 1- movimentação do bixinhos de forma bonita e seguindo padrões !
 * 2- arma atira pra to do canto
 * 3- entendendo como funciona ISSO <- talvez maior feito do dia
 * */

