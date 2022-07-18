public class Planet{
	public static final double G = 6.67e-11;

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;


	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}

	public double calcDistance(Planet q){
		double dx = (this.xxPos - q.xxPos) * (this.xxPos - q.xxPos);
		double dy = (this.yyPos - q.yyPos) * (this.yyPos - q.yyPos);
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Planet q){
		return G * this.mass * q.mass / this.calcDistance(q) / this.calcDistance(q);
	}

	public double calcForceExertedByX(Planet q){
		double totalForce = this.calcForceExertedBy(q);
		return totalForce * (q.xxPos - this.xxPos) / this.calcDistance(q);
	}

	public double calcForceExertedByY(Planet q){
		double totalForce = this.calcForceExertedBy(q);
		return totalForce * (q.yyPos - this.yyPos) / this.calcDistance(q);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netForceExertedByX = 0.0;
		for (int i = 0; i < allPlanets.length; i++){
			if (this.equals(allPlanets[i]) == false){
				netForceExertedByX += this.calcForceExertedByX(allPlanets[i]);
			}
		}
		return netForceExertedByX;

	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double netForceExertedByY = 0.0;
		for (int i = 0; i < allPlanets.length; i++){
			if (this.equals(allPlanets[i]) == false){
				netForceExertedByY += this.calcForceExertedByY(allPlanets[i]);
			}
		}
		return netForceExertedByY;
	}

	public void update(double dt, double fX, double fY){
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel = this.xxVel + aX * dt;
		this.yyVel = this.yyVel + aY * dt;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
}
