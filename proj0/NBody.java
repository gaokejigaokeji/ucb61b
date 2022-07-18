import java.util.Arrays;

public class NBody{
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double univseRadius = readRadius(filename);
		Planet[] planetInFile = readPlanets(filename);

		StdDraw.setScale(-univseRadius, univseRadius);
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for (int i = 0; i < planetInFile.length; i++){
			planetInFile[i].draw();
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