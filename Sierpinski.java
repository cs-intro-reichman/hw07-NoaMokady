/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}

	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski(int n) {
		int margin = 30;
		int size = 500;
		double sideLength = size - 2 * margin;
		double height = (Math.sqrt(3) * sideLength) / 2;
		StdDraw.setCanvasSize(size, size);
		StdDraw.setXscale(0, size);
		StdDraw.setYscale(0, size);

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.005);

		double x1 = margin;
		double x2 = x1 + sideLength;
		double x3 = x1 + (sideLength / 2);
		double y1 = margin;
		double y2 = y1;
		double y3 = y1 + height;
		// Draws base triangle.
		drawTriangle(x1, x2, x3, y1, y2, y3);
		// Draws the inner triangles of depth n on the canvass.
		sierpinski(n, x1, x2, x3, y1, y2, y3);
		StdDraw.show();
	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
			double y1, double y2, double y3) {
		if (n == 0) {
			return;
		}
		double midX12 = (x1 + x2) / 2;
		double midX23 = (x2 + x3) / 2;
		double midX31 = (x3 + x1) / 2;
		double midY12 = (y1 + y2) / 2;
		double midY23 = (y2 + y3) / 2;
		double midY31 = (y3 + y1) / 2;
		drawTriangle(midX12, midX23, midX31, midY12, midY23, midY31);

		sierpinski(n - 1, midX31, midX23, x3, midY31, midY23, y3); // Upper triangle.
		sierpinski(n - 1, x1, midX12, midX31, y1, midY12, midY31); // Lower left triagnle.
		sierpinski(n - 1, midX12, x2, midX23, midY12, y2, midY23); // Lower right triagnle.
	}

	// Draws the lines of the given triangle's points on the canvas.
	public static void drawTriangle(double x1, double x2, double x3,
			double y1, double y2, double y3) {
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x1, y1, x3, y3);
		StdDraw.line(x3, y3, x2, y2);
	}

}