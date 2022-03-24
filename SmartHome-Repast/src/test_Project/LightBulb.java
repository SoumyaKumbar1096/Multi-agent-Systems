package test_Project;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.query.space.grid.GridCell;
import repast.simphony.query.space.grid.GridCellNgh;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridPoint;
import repast.simphony.util.ContextUtils;

/* Implements Light agent. It switches on when window closes. It switches off when window is open*/
public class LightBulb {
	
	private Grid<Object> grid;
	private Point point;
	
	public LightBulb( Grid<Object> grid, Point point) {
		System.out.printf(" LightBulb() "+'\n');
		this.grid = grid;
		this.point=point;
	}
	
	
	  private void SwitchOn(Object obj){
		  System.out.printf(" LightBulb()-SwitchOn() "+'\n');
	  			   
		  Context context = ContextUtils.getContext(obj);
		  LightBulb bulb=new LightBulb(grid, point);
		  context.add(bulb);
		  grid.moveTo(bulb, (int) this.point.getX(), (int)this.point.getY());
		  context.add(bulb);
	  }	  	 
	
	  private void SwitchOff() { 
		  // TODO Auto-generated method stub GridPoint
		  System.out.printf(" LightBulb()-SwitchOff() "+'\n');
		  Context context=ContextUtils.getContext(this);
	  		context.remove(this);
	  }
	  	 
	
	  @ScheduledMethod(start = 1, interval = 1, priority=1)
	  public void LightStatus() { 
		  System.out.printf(" LightBulb()-LightStatus()"+'\n');
		  //Iterable<Object> objs=grid.getObjects();
		  Context context = ContextUtils.getContext(this);
		  Stream<Window> s=context.getObjectsAsStream(Window.class);
		  List<Window> wobj=s.collect(Collectors.toList());
		  System.out.printf(" LightBulb()-LightStatus()"+wobj+'\n');
		  for(Object obj: wobj) {
			  System.out.printf(" LightBulb()-LightStatus()-forLoop()"+obj+'\n');
			  if(obj instanceof Window) {
				  System.out.printf(" LightBulb()-LightStatus()-forLoop()-if status is open"+'\n');
			  		SwitchOff();
			  		break;
			  		}
			  	else {
			  		System.out.printf(" LightBulb()-LightStatus()-forLoop()-if status is close"+'\n');
			  		SwitchOn(obj);
			  		break;
			  		}
			  	}
	  		}
			  
		  }
		  	
	 

	
	

