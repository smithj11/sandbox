
//Work in progress
public class HitBoxTile {
	double bottomLeftX;
	double bottomLeftY;
	double bottomRightX;
	double topLeftY;

	public HitBoxTile(double xCoord, double yCoord, double height, double width) {
		bottomLeftX = xCoord - width / 2;
		bottomLeftY = yCoord - height / 2;
		bottomRightX = xCoord + width / 2;
		topLeftY = yCoord + height / 2;

	}

	public double getBottomLeftX() {
		return bottomLeftX;
	}

	public void setBottomLeftX(double bottomLeftX) {
		this.bottomLeftX = bottomLeftX;
	}

	public double getBottomLeftY() {
		return bottomLeftY;
	}

	public void setBottomLeftY(double bottomLeftY) {
		this.bottomLeftY = bottomLeftY;
	}

	public double getBottomRightX() {
		return bottomRightX;
	}

	public void setBottomRightX(double bottomRightX) {
		this.bottomRightX = bottomRightX;
	}

	public double getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(double topLeftY) {
		this.topLeftY = topLeftY;
	}

	public boolean isColliding(HitBoxTile comparator) {
		if ((this.getTopLeftY() >= comparator.getBottomLeftY())
				&& (this.getBottomLeftY() <= comparator.getTopLeftY())
				&& (this.getBottomLeftX() >= comparator.getBottomLeftX()) 
				&& (this.getBottomLeftX() <= comparator.getBottomRightX())
				) {
			System.out.println("collided");
			return true;
		}
		System.out.println("not collding");
		return false;
	}

}
