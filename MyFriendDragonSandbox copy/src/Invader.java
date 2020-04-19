

public class Invader implements Sprite {
	double xPos;
	double yPos;
	int health;
	HitBoxTile SpaceInvaderTile;
	final int startingHealth = 2;
	final double invaderWidth = 50;
	final double invaderHeight = 41;
	final double invaderHitBoxWidth = 64;
	final double invaderHitBoxHeight = 46;
	
	public Invader(double x, double y) {
		this.xPos = x;
		this.yPos = y;
		this.health = startingHealth;
		this.health = 1;
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHitBoxHeight , invaderHitBoxWidth);
		

	}
	public void hurt() {
		health = health - 1;
		if(health < 0) {
			health = 0;
		}
	}
	
	public boolean isDead() {
		if (health == 0) {
			return true;
		}
		else {
			return false;
		}
	} 
	
	public int getHealth() {
		return health;
	}

	@Override
	public void move() {
		this.yPos=this.yPos-45;
		
	}

	@Override
	public void updateHitBoxPos() {
		this.SpaceInvaderTile = new HitBoxTile(this.xPos, this.yPos, invaderHitBoxHeight , invaderHitBoxWidth);
	}


	@Override
	public double getX() {
		return xPos;
	}

	@Override
	public double getY() {
		return yPos;
	}

	@Override
	public double getHitBoxBottomLeftX() {
		return this.SpaceInvaderTile.getBottomLeftX();
	}

	@Override
	public double getHitBoxBottomLeftY() {
		return this.SpaceInvaderTile.getBottomLeftY();
	}

	@Override
	public double getHitBoxBottomRightX() {
		return this.SpaceInvaderTile.getBottomRightX();
	}

	@Override
	public double getHitBoxTopLeftY() {
		return this.SpaceInvaderTile.getTopLeftY();
	}
	
	public HitBoxTile getHitBox() {
		return this.SpaceInvaderTile;
	}
	
	public void checkCollision(dragonBulletCollection dragonBullets) {
		it
		boolean collided = this.SpaceInvaderTile.isColliding(player.getHitBox());
		
	}



	
	
}
