import java.util.Arrays;

public class NBody{
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double univseRadius = readRadius(filename);
		Planet[] planetInFile = readPlanets(filename);

		StdDraw.enableDoubleBuffering();

		double time = 0;

		while (time < T){
			double[] xForces = new double[planetInFile.length];
			double[] yForces = new double[planetInFile.length];

			for (int i = 0; i < planetInFile.length; i++){
				xForces[i] = planetInFile[i].calcNetForceExertedByX(planetInFile);
				yForces[i] = planetInFile[i].calcNetForceExertedByY(planetInFile);

			}

			for (int i = 0; i < planetInFile.length; i++){
				planetInFile[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.setScale(-univseRadius, univseRadius);
			StdDraw.clear();
			StdDraw.picture(0, 0, "images/starfield.jpg");

			for (int i = 0; i < planetInFile.length; i++){
				planetInFile[i].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}

		
		StdOut.printf("%d\n", planetInFile.length);
		StdOut.printf("%.2e\n", univseRadius);
		for (int i = 0; i < planetInFile.length; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  		planetInFile[i].xxPos, planetInFile[i].yyPos, planetInFile[i].xxVel,
                  		planetInFile[i].yyVel, planetInFile[i].mass, planetInFile[i].imgFileName);   
		}
		
	}

	public static double readRadius(String filename){
		In in = new In(filename);

		int numPlanet = in.readInt();
		double univseRadius = in.readDouble();

		return univseRadius;
	}

	public static Planet[] readPlanets(String filename){
		In in = new In(filename);

		int numPlanet = in.readInt();
		double univseRadius = in.readDouble();

		Planet[] planetInFile = new Planet[numPlanet];

		for (int i = 0; i < numPlanet; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planetInFile[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planetInFile;
	}
}