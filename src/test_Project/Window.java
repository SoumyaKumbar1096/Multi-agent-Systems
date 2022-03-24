package test_Project;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.query.space.grid.GridCell;
import repast.simphony.query.space.grid.GridCellNgh;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.ContextUtils;
import repast.simphony.util.SimUtilities;

/* implements window agent. closes/opens based on wind flowing inside the house. */
public class Window {
	
	private Grid<Object> grid;
	private boolean open = false;
	//private boolean close = false;// boolean for window open/close
	private Point nextPoint;

	public Window(Grid<Object> grid, Point nextPoint) {
		System.out.printf(" Window() "+'\n');
		this.grid = grid;
		this.nextPoint=nextPoint;
	}

	
	
	  public void open() {
		  // open
		  System.out.printf(" open() "+'\n');
		  Context context = ContextUtils.getContext(this);
		  context.remove(this); 
		  open=true;
	  }
	 
	  
	  public void close() {
		  System.out.printf(" close() "+'\n');
		  Iterable<Object> objs=grid.getObjects();  
		  System.out.printf(" Window()-close() "+objs+'\n');
		  for(Object obj: objs) {
			  Context context = ContextUtils.getContext(obj);
			  Window window=new Window(grid, nextPoint);
			  context.add(window);
			  grid.moveTo(window, (int) this.nextPoint.getX(), (int)this.nextPoint.getY());
			  context.add(window);
		  		   
			  open = false;
			  break;
		  }
		  
		  
		  }
	 

	  @ScheduledMethod(start = 1, interval = 1, priority=2)
	  public void windowStatus() {
		  GridPoint gpt=grid.getLocation(this);
		  
		  System.out.printf(" Window()-windowStatus() "+'\n');
		  //close();
		  //open();
		  GridCellNgh<AgentClassA> nghCreator = new GridCellNgh<AgentClassA>(grid, gpt, AgentClassA.class, 1, 1);		  
		  List<GridCell<AgentClassA>> gridCells = nghCreator.getNeighborhood(true);		  
		  SimUtilities.shuffle(gridCells, RandomHelper.getUniform());
		  
		  for(GridCell<AgentClassA> cell:gridCells) {
			  System.out.printf(" Window()-windowStatus()-forLoop() "+'\n');
			  
			  if( cell.size()>1) {
				  System.out.printf(" windowStatus-forloop-if cell has AgentCLassA "+'\n');
				  close();
				  break;
				  }
	  
			  else {
				  System.out.printf(" windowStatus-forloop-else cell do not have AgentCLassA "+'\n');
				  open();
				  break; 
				  }	  
		  	}	  
		  
			/*
			 * GridPoint pointWithMostWind = null; int maxCount = -1; for
			 * (GridCell<AgentClassA> cell : gridCells) { if (cell.size() > maxCount) {
			 * pointWithMostWind = cell.getPoint(); maxCount = cell.size(); if(maxCount>-1)
			 * { close(); break; } else { open(); break; } }
			 * 
			 * }
			 */
	  		
			
			/*
			 * for(GridCell<AgentClassA> cell:gridCells) {
			 * System.out.printf(" Window()-windowStatus()-forLoop() "+'\n');
			 * 
			 * if( cell.size()>1) {
			 * System.out.printf(" windowStatus-forloop-if cell has AgentCLassA "+'\n');
			 * close(); break; }
			 * 
			 * else {
			 * System.out.printf(" windowStatus-forloop-else cell do not have AgentCLassA "+
			 * '\n'); open(); break; } }
			 */		  
		  
	  } 

	
	  public boolean getStatus() {
		  System.out.printf(" Window()-getStatus() "+'\n');
		  // TODO Auto-generated method stub return open;
		  return open;
	  }
	 
}
