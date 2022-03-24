package test_Project;

import java.awt.Point;
import java.util.ArrayList;
import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.context.space.grid.GridFactory;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.continuous.RandomCartesianAdder;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.space.grid.RandomGridAdder;
import repast.simphony.space.grid.SimpleGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;

public class Test_contextbuilder implements ContextBuilder<Object> {

	@Override
	public Context<Object> build(Context<Object> context) {
		
		context.setId("Test Project");
		
		
		GridFactory gridFactory = GridFactoryFinder.createGridFactory(null);
		Grid<Object> grid=gridFactory.createGrid("grid", context, new GridBuilderParameters<Object>(new WrapAroundBorders(),
				new SimpleGridAdder<Object>(), true, 50,50));
		
		//Parameters params = RunEnvironment.getInstance().getParameters();
		//int agentACount= 4;
		
		ArrayList<GridPoint> apoints = new ArrayList<GridPoint>(); 
		GridPoint apoint1 = new GridPoint(45,16);
		GridPoint apoint2 = new GridPoint (45,15);
		GridPoint apoint3 = new GridPoint (45,14);
		GridPoint apoint4 = new GridPoint (45,13);
		GridPoint apoint5 = new GridPoint (45,12);
		  
		  apoints.add(apoint1);
		  apoints.add(apoint2);
		  apoints.add(apoint3);
		  apoints.add(apoint4);
		  apoints.add(apoint5);
		  
		  for (GridPoint nextPoint: apoints) { 
			  AgentClassA agentclass = new AgentClassA(grid, nextPoint);
			  context.add(agentclass); 
			  grid.moveTo(agentclass, (int) nextPoint.getX(), (int) nextPoint.getY());
			  context.add(agentclass); 
		  }
		 
		 
		
		
			/*
			 * for(int i=0;i<agentACount;i++ ) { AgentClassA agent=new AgentClassA(grid);
			 * context.add(agent); }
			 */
		 
		 
		
		// Light Agent
		int lightCount=1;
		Point p1 = new Point (10,10);
		for(int i=0;i<lightCount;i++) {
			LightBulb lightbulb=new LightBulb(grid,p1);			
			context.add(lightbulb);
			grid.moveTo(lightbulb, (int) p1.getX(),(int) p1.getY());
			context.add(lightbulb);
		}
		
		// Washing Machine Agent
				int countWM=1;
				Point pwm = new Point (10,15);
				for(int i=0;i<countWM;i++) {
					WashingMachine wm=new WashingMachine(grid);			
					context.add(wm);
					grid.moveTo(wm, (int) pwm.getX(),(int) pwm.getY());
					context.add(wm);
				}
		
		// Window Agent
				ArrayList<Point> points = new ArrayList<Point>();
				Point point1 = new Point (20,15);
				Point point2 = new Point (20,14);
				Point point3 = new Point (20,13);
				Point point4 = new Point (20,12);
				
				points.add(point1);
				points.add(point2);
				points.add(point3);
				points.add(point4);
				
				
				for (Point nextPoint: points) {
					Window window = new Window(grid,nextPoint);				
					context.add(window);
					grid.moveTo(window, (int) nextPoint.getX(), (int)nextPoint.getY());
					context.add(window);					 
				}
		
		//House Agent
		ArrayList<Point> hpoints = new ArrayList<Point>();
		Point hpoint1 = new Point (5,16);
		Point hpoint2 = new Point (5,15);
		Point hpoint3 = new Point (5,14);
		Point hpoint4 = new Point (5,13);
		Point hpoint5 = new Point (5,12);
		Point hpoint6 = new Point (5,11);
		Point hpoint7 = new Point (5,10);
		Point hpoint8 = new Point (5,9);
		Point hpoint9 = new Point (5,8);
		Point hpoint10 = new Point (5,7);
		Point hpoint11 = new Point (5,6);
		Point hpoint12= new Point (5,5);
		Point hpoint13= new Point (6,5);
		Point hpoint14= new Point (7,5);
		Point hpoint15= new Point (8,5);
		Point hpoint16= new Point (9,5);
		Point hpoint17= new Point (10,5);
		Point hpoint18= new Point (11,5);
		Point hpoint19= new Point (12,5);
		Point hpoint20= new Point (13,5);
		Point hpoint21= new Point (14,5);
		Point hpoint22= new Point (15,5);
		Point hpoint23= new Point (16,5);
		Point hpoint24= new Point (17,5);
		Point hpoint25= new Point (18,5);
		Point hpoint26= new Point (19,5);
		Point hpoint27 = new Point (5,16);
		Point hpoint28 = new Point (6,16);
		Point hpoint29 = new Point (7,16);
		Point hpoint30 = new Point (8,16);
		Point hpoint31 = new Point (9,16);
		Point hpoint32 = new Point (10,16);
		Point hpoint33 = new Point (11,16);
		Point hpoint34 = new Point (12,16);
		Point hpoint35 = new Point (13,16);
		Point hpoint36 = new Point (14,16);
		Point hpoint37 = new Point (15,16);
		Point hpoint38 = new Point (16,16);
		Point hpoint39 = new Point (17,16);
		Point hpoint40 = new Point (18,16);
		Point hpoint41 = new Point (19,16);
		Point hpoint42 = new Point (20,16);		
		Point hpoint43 = new Point (20,5);
		Point hpoint44 = new Point (20,6);
		Point hpoint45 = new Point (20,7);
		Point hpoint46 = new Point (20,8);
		Point hpoint47 = new Point (20,9);
		Point hpoint48 = new Point (20,10);
		Point hpoint49 = new Point (20,11);
		
		hpoints.add(hpoint1);
		hpoints.add(hpoint2);
		hpoints.add(hpoint3);
		hpoints.add(hpoint4);
		hpoints.add(hpoint5);
		hpoints.add(hpoint6);
		hpoints.add(hpoint7);
		hpoints.add(hpoint8);
		hpoints.add(hpoint9);
		hpoints.add(hpoint10);
		hpoints.add(hpoint11);
		hpoints.add(hpoint12);
		hpoints.add(hpoint13);
		hpoints.add(hpoint14);
		hpoints.add(hpoint15);
		hpoints.add(hpoint16);
		hpoints.add(hpoint17);
		hpoints.add(hpoint18);
		hpoints.add(hpoint19);
		hpoints.add(hpoint20);
		hpoints.add(hpoint21);
		hpoints.add(hpoint22);
		hpoints.add(hpoint23);
		hpoints.add(hpoint24);
		hpoints.add(hpoint25);
		hpoints.add(hpoint26);
		hpoints.add(hpoint27);
		hpoints.add(hpoint28);
		hpoints.add(hpoint29);
		hpoints.add(hpoint30);
		hpoints.add(hpoint31);
		hpoints.add(hpoint32);
		hpoints.add(hpoint33);
		hpoints.add(hpoint34);
		hpoints.add(hpoint35);
		hpoints.add(hpoint36);
		hpoints.add(hpoint37);
		hpoints.add(hpoint38);
		hpoints.add(hpoint39);
		hpoints.add(hpoint40);
		hpoints.add(hpoint41);
		hpoints.add(hpoint42);
		hpoints.add(hpoint43);
		hpoints.add(hpoint44);
		hpoints.add(hpoint45);
		hpoints.add(hpoint46);
		hpoints.add(hpoint47);
		hpoints.add(hpoint48);
		hpoints.add(hpoint49);
		
		for (Point nextp: hpoints) {
			House house = new House(grid);
			context.add(house);
			grid.moveTo(house, (int) nextp.getX(), (int) nextp.getY());
			context.add(house);
		}
				  
		
		 if (RunEnvironment.getInstance().isBatch()) {
			 RunEnvironment.getInstance().endAt(20);
			 }
		 
		return context;
	}
}
 	