

import edu.princeton.cs.introcs.StdDraw;

public class SpaceInvaderBullet implements Sprite {
	final double bulletWidth = 26;
	final double bulletHeight = 22;
	double xPos;
	double yPos;
	HitBoxTile invaderBulletHitBox;
	boolean onScreen;
	
	public SpaceInvaderBullet(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		invaderBulletHitBox = new HitBoxTile(xPos, yPos, bulletHeight, bulletWidth);
		this.onScreen=true;
	}
	
	public void update() {
		if (this.yPos < 0) {
			this.setOnScreen();
		}
		this.move();
		this.updateHitBoxPos();
		StdDraw.rectangle(xPos, yPos, bulletHeight, bulletWidth);
			
	}
		
	@Override	
	public void move() {
		this.yPos-=25;
	}

	public boolean getOnScreen() {
		return this.onScreen;
	}
	public void setOnScreen() {
		this.onScreen = false;
	}
	
	
	@Override
	public double getX() {
		return this.xPos;
	}

	@Override
	public double getY() {
		return this.yPos;
	}

	@Override
	public void updateHitBoxPos() {
		invaderBulletHitBox = new HitBoxTile(xPos, yPos, bulletWidth, bulletHeight);
		
	}

	@Override
	public void hurt() {
		//don't need for space invader bullet
		
	}


	@Override
	public double getHitBoxBottomLeftX() {
		// TODO Auto-generated method stub
		return this.invaderBulletHitBox.getBottomLeftX();
	}


	@Override
	public double getHitBoxBottomLeftY() {
		return this.invaderBulletHitBox.getBottomLeftY();
	}


	@Override
	public double getHitBoxBottomRightX() {
		return this.invaderBulletHitBox.getBottomRightX();
	}


	@Override
	public double getHitBoxTopLeftY() {
		return this.invaderBulletHitBox.getTopLeftY();
	}
	
	public HitBoxTile getHitBox() {
		return this.invaderBulletHitBox;
	}
	

}
