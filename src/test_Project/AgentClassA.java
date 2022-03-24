package test_Project;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.Direction;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.ContextUtils;

public class AgentClassA {

	private Grid<Object> grid;
	private boolean wind=false;
	//private boolean nowind=false;
	private GridPoint point;
	
	public AgentClassA(Grid<Object> grid, GridPoint point) {
		System.out.print("AgentCLass "+'\n');
		this.point = point;
		this.grid = grid;		
	}

	@ScheduledMethod(start = 1, interval = 1, priority=3)
	public void step() {
		GridPoint pt = grid.getLocation(this);
		
		Context<AgentClassA> context = ContextUtils.getContext(this);
		move();
		//nowind=true;
		if((int)pt.getX()<23) {
			wind=true;
			if((int) pt.getX() < 21){
				
				System.out.print("AgentCLass-stepMethod-if wind reached Window "+'\n');
				
				startOver(point);
			}
		}
		
	}

	private void move() {
		System.out.print("AgentCLass-moveMethod "+'\n');
		//GridPoint pt = grid.getLocation(this);
		grid.moveByVector(this, 1, Direction.WEST);
	}

	
	  private void startOver(GridPoint pt) { 
		  // TODO Auto-generated method stub
		  System.out.print("AgentCLass-startOver "+'\n');
		  
		  Context<Object> context = ContextUtils.getContext(this);
		  
		  context.remove(this);
		  
		  AgentClassA agentclass = new AgentClassA(grid, pt);
		  context.add(agentclass);		
		  grid.moveTo(agentclass, (int) pt.getX(), (int) pt.getY());
		  context.add(agentclass);
		 	  
	  }
	 

}
