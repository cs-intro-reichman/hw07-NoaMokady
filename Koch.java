/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function. Uncomment the
		/// second code block to test the snowflake function. Uncomment only one block in
		/// each test, and remember to compile the class whenever you change the test.

		/*
		 * // Tests the curve function:
		 * // Gets n, x1, y1, x2, y2,
		 * // and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		 * curve(Integer.parseInt(args[0]),
		 * Double.parseDouble(args[1]), Double.parseDouble(args[2]),
		 * Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		 */

		// StdDraw.setYscale(0, 10);
		// StdDraw.setXscale(0, 10);
		// curve(5, 1, 5, 9, 5);

		/*
		 * // Tests the snowflake function:
		 * // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		 * snowFlake(Integer.parseInt(args[0]));
		 */

		snowFlake(5);
	}

	/**
	 * Gets n, x1, y1, x2, y2,
	 * and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
	 */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		//// Write the rest of your code below.
		if (n == 0) {
			return;
		}
		double x3 = (Math.sqrt(3) / 6) * (y1 - y2) + 0.5 * (x1 + x2);
		double y3 = (Math.sqrt(3) / 6) * (x2 - x1) + 0.5 * (y1 + y2);
		double midX1 = (2 * x1 + x2) / 3;
		double midY1 = (2 * y1 + y2) / 3;
		double midX2 = (x1 + 2 * x2) / 3;
		double midY2 = (y1 + 2 * y2) / 3;

		StdDraw.line(midX1, midY1, x3, y3);
		StdDraw.line(x3, y3, midX2, midY2);
		removeLine(midX1, midY1, midX2, midY2);

		curve(n - 1, x1, y1, midX1, midY1); // First line.
		curve(n - 1, midX1, midY1, x3, y3); // Second line.
		curve(n - 1, x3, y3, midX2, midY2); // Third line.
		curve(n - 1, midX2, midY2, x2, y2); // Forth line.
		StdDraw.show();
	}

	// Removes a line by drawing over it with the canvas background color.
	public static void removeLine(double x1, double y1, double x2, double y2) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(0.01);
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.005);
	}

	/** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
		
		double x1 = 0.1;
		double y1 = 0.3;
		double x2 = 1;
		double y2 = y1;
		double x3 = (x1+x2)/2;
		double y3 = y1 + ((Math.sqrt(3) * (x2-x1)) / 2);

		curve(5, x2, y2, x1, y1);
		curve(5, x3, y3, x2, y2);
		curve(5, x1, y1, x3, y3);
	}
}
