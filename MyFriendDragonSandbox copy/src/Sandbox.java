import edu.princeton.cs.introcs.StdDraw;
public class Sandbox {
	double bottomLeftX;
	double bottomLeftY;
	double bottomRightX;
	double topLeftY;
	public Sandbox(double xCoord, double yCoord, double height, double width) {
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
	public boolean isColliding(Sandbox sandbox2) {
		if ((this.getTopLeftY() >= sandbox2.getBottomLeftY())
				&& (this.getBottomLeftY() <= sandbox2.getTopLeftY())
				&& (this.getBottomLeftX() >= sandbox2.getBottomLeftX()) 
				&& (this.getBottomLeftX() <= sandbox2.getBottomRightX())
				) {
			System.out.println("collided");
			return true;
		}
		System.out.println("not collding");
		return false;
	}

	
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(400,400);
		StdDraw.setXscale(0,400);
		StdDraw.setYscale(0,400);
		Sandbox sandbox = new Sandbox(200,200,20,20);
		Sandbox sandbox2 = new Sandbox(207,207,20,20);
		System.out.println("Bottom left x" + sandbox.bottomLeftX);
		System.out.println("Bottom left y" + sandbox.bottomLeftY);
		System.out.println("Bottom right x" + sandbox.bottomRightX);
		System.out.println("Top left y" + sandbox.getTopLeftY());
		System.out.println(sandbox2.isColliding(sandbox));
		StdDraw.rectangle(200, 200, 10, 10);
		
	}
}
