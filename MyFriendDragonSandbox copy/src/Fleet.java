import java.util.ArrayList;
import java.util.Iterator;

public class Fleet {
	private ArrayList<Invader> invaders;
	private ArrayList<SpaceInvaderBullet> bullets;
	private final static int startingSize = 9; 

	public Fleet() {
		invaders = new ArrayList<Invader>();
		bullets = new ArrayList<SpaceInvaderBullet>();
	}

	public ArrayList<Invader> getInvaders() {
		return invaders;
	}
	public ArrayList<SpaceInvaderBullet> getBullets() {
		return bullets;
	}

	public void setInvaders(ArrayList<Invader> invaders) {
		this.invaders = invaders;
	}
	
	public void spawnInvaders() {
		for (int i = 0; i < startingSize; ++i) {
			Invader toAdd = new Invader(40 + (i * 40), 350);
			this.invaders.add(toAdd);
		}
	}
	
	public void shootBullets() {
		int chosenShooterIndex = 4;
		//int chosenShooterIndex = (int)(Math.random()*this.invaders.size());
		System.out.println("Chosen shooter index: " + chosenShooterIndex);
		Invader chosenShooter = this.invaders.get(chosenShooterIndex);
		SpaceInvaderBullet bullet = new SpaceInvaderBullet(chosenShooter.getX(), chosenShooter.getY());
		bullets.add(bullet);
	}

	public void addRowOfInvaders() {
		Iterator<Invader> it = this.invaders.iterator();
		while (it.hasNext()) {
			Invader element = it.next();
			element.move();
		}
		spawnInvaders();
	
	}

	public Invader getInvader(int index) {
		return invaders.get(index);
	}


	public void update() {
		Iterator<Invader> it = invaders.iterator(); 
		while (it.hasNext()) {
			Invader element = it.next();
			if(element.isDead()) {
				it.remove();
			}
		}
		Iterator<SpaceInvaderBullet> it2 = bullets.iterator();
		while (it2.hasNext()) {
			SpaceInvaderBullet bullet = it2.next();
				System.out.println("bullet info" + bullet.xPos + " " + bullet.yPos);
				bullet.update();
				if (bullet.getOnScreen()==false) {
					it2.remove();
				}
			}
		}
	}



