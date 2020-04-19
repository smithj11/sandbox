import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.introcs.StdDraw;

public class GameBoard {
	int frameCounter;
	Player player;
	Fleet fleet;
	dragonBulletCollection dragonBullets;
	
	public static void main(String[] args) {
		GameBoard game = new GameBoard();
		game.setUpGame();
		game.playGame();
	}
	
	public void setUpGame() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		frameCounter = 0;
		this.initPlayer();
		this.initAliens();
	}


	public void playGame() {
		while (true){
			if (frameCounter % 30 == 0) {
				fleet.shootBullets();	
			}
			if (frameCounter == 300) {
				fleet.addRowOfInvaders();
				frameCounter = 0;
			}
			frameCounter++;
			System.out.println(frameCounter);
			this.fieldUpdates();
			StdDraw.clear();
			this.drawSprites();
			StdDraw.show();
			StdDraw.pause(66);
	}
			
}
	private void fieldUpdates() {
		player.updatePlayer(dragonBullets, fleet);
		dragonBullets.update();
		fleet.update();
	}
	
	  private void drawPlayer() {
	      StdDraw.picture(player.getX(), player.getY(), "src/flying_dragon-red-RGB.png", 46, 33);
	      StdDraw.rectangle(player.getX(), player.getY(), player.hitBoxWidth/2, player.hitBoxHeight/2);

	    }
	  
	  private void drawFleet() {
		  Iterator<Invader> it = fleet.getInvaders().iterator(); 
	        while (it.hasNext()) {
	        	Invader element = it.next();
	        	StdDraw.picture(element.getX(), element.getY(), "src/space_invader_ship.png",  element.invaderWidth, element.invaderHeight);
	        }
	  }
	  
	private void drawDragonBullets() {
	    Iterator<DragonBullet> it = dragonBullets.getBullets().iterator(); 
        while (it.hasNext()) {
        		DragonBullet element = it.next();
            StdDraw.picture(element.getX(), element.getY(), "src/dragon_shot.png",  element.bulletWidth, element.bulletHeight);
            StdDraw.rectangle(element.getX(), element.getY(), element.bulletWidth/2, element.bulletHeight/2);
		}
	}
	
	private void drawSpaceInvaderBullets() {
		Iterator<SpaceInvaderBullet> it = fleet.getBullets().iterator();
		while(it.hasNext()) {
			SpaceInvaderBullet element = it.next();
			StdDraw.picture(element.getX(), element.getY(), "src/invader_shot.png", element.bulletWidth, element.bulletHeight);
			
		}
	}
	
	
	public void initPlayer() {
		player = new Player();
		dragonBullets = new dragonBulletCollection();
	}
	
	public void initAliens() {
		fleet = new Fleet();
		fleet.addRowOfInvaders();
	}

	
	public void drawSprites() {
		this.drawPlayer();
		this.drawFleet();
		this.drawDragonBullets();
		this.drawSpaceInvaderBullets();
		
	}
	public void redrawUI() {
		
		
	}


}
