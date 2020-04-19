


import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.introcs.StdDraw;

public class Player implements Sprite {

	// move with W, A, S, D
	
	// when implementing the player, we must continuously check
	// if StdDraw.hasNextKeyTyped() {
	// 		player.interpretKeyPressed(StdDraw.nextKeyTyped());
	// }
	// in the while(true) loop
	
	private double x;
	private double y;
	private int score;
	private int health;
	final double hitBoxWidth = 46;
	final double hitBoxHeight = 50;
	final double playerWidth = 46;
	final double playerHeight = 33;
	private HitBoxTile dragonHitBox;

	public Player() {
		this.x = 200;
		this.y = 20;
		this.score = 0;
		this.health = 100;
		this.dragonHitBox = new HitBoxTile(this.x, this.y, hitBoxHeight, hitBoxWidth);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public int getScore() {
		return this.score;
	}
	
	public int getHealth() {
		return this.health;
	}

	public void isHit(int collisionNumber) {
		this.health -= (10*collisionNumber);
	}

	public void didHitInvader() {
		this.score += 20;
	}
	public HitBoxTile getHitBox() {
		return this.dragonHitBox;
	}

	public void interpretKeyPressed(char keyPressed, dragonBulletCollection bullets) {
		
		if (keyPressed == 'w' || keyPressed == 's') {
			if (keyPressed == 'w') {
				this.movePlayer('y', 5);
			}
			else {
				this.movePlayer('y', -5);
			}
		}
		if (keyPressed == 'a' || keyPressed == 'd') {
			if (keyPressed == 'a') {
				this.movePlayer('x', -5);
			}
			else {
				this.movePlayer('x', 5);
			}

	}
		if (keyPressed == 'x') {
			System.out.println("Bullets in keypressed fxn" + bullets.toString());
			this.shootBullet(bullets);
			
		}
}
	
	private void movePlayer(char axis, int dist) {
		if (checkInBounds(axis, dist)) {
			if (axis == 'y') {
				this.y += dist;
			}
			else {
				this.x += dist;
			}
		}
		// redraw UI
	}

		// redraw UI
	
	
	private boolean checkInBounds(char axis, int difference) {
		if (axis == 'y') {
			return (this.y + difference) <= 400 && (this.y + difference) >= 0;
		}
		if (axis == 'x') {
			return (this.x + difference) <= 400 && (this.x + difference) >= 0;
		}
		return false;
	}
	
	private void shootBullet(dragonBulletCollection bullets) {
		DragonBullet dragonBullet = new DragonBullet(this.x, this.y);
		bullets.addBullet(dragonBullet);
		System.out.println("Bullets in shootbullet fxn" + bullets.toString());
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateHitBoxPos() {
		this.dragonHitBox= new HitBoxTile(x, y, hitBoxHeight, hitBoxWidth);
		
	}


	@Override
	public void hurt() {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<SpaceInvaderBullet> invaderBulletCollisionChecker(Fleet fleet) {
		Iterator<SpaceInvaderBullet> it = fleet.getBullets().iterator();
		ArrayList<SpaceInvaderBullet> returner = new ArrayList<SpaceInvaderBullet>();
        while (it.hasNext()) {
        	System.out.println("In player bullet collision check");
        	SpaceInvaderBullet element = it.next();
        HitBoxTile elementHitBox = element.getHitBox();
        	boolean collided = elementHitBox.isColliding(this.dragonHitBox);
        		if (collided) {
						System.out.print("Player hit!");
						element.setOnScreen();
						returner.add(element);
			}
        }
		return returner;
}
	
	public void updatePlayer(dragonBulletCollection bullets, Fleet fleet) {
		ArrayList<SpaceInvaderBullet> returner = this.invaderBulletCollisionChecker(fleet);
		this.isHit(returner.size());
		if (StdDraw.hasNextKeyTyped() ){
			this.interpretKeyPressed(StdDraw.nextKeyTyped(), bullets );
			this.updateHitBoxPos();
		
		}
	}
		

	@Override
	public double getHitBoxBottomLeftX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHitBoxBottomLeftY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHitBoxBottomRightX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHitBoxTopLeftY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
