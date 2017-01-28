package receiver_move;

import java.awt.Point;

import level.Level;
import component.*;


public class Move {

	protected Level level;
	protected Component component;
	Direction direction;
	
	public Move(Level level, Component component, Direction direction) {
		this.level = level;
		this.component = component;
		this.direction = direction;
	}
	
	
	public void move() {

		// Current component position
		Point currentPosition = component.getPosition();
		int x = (int)currentPosition.getX();
		int y = (int)currentPosition.getY();

		// Current component onTarget status
		boolean onTarget = component.getOnTarget();

		// Check if the component is going to cover something
		if (level.getAdjacent(currentPosition,direction).getComponentType() == ComponentType.TARGET)
			component.setOnTarget(true);
		if (level.getAdjacent(currentPosition,direction).getComponentType() == ComponentType.FLOOR)
			component.setOnTarget(false);

		// Making a move
		makeMove(direction);

		// Recovering a covered place
		if (onTarget) { level.getLevel().get(x).set(y, new Target(currentPosition)); }
		if (!onTarget) { level.getLevel().get(x).set(y, new Floor(currentPosition)); }

		
	}
	
	public void makeMove(Direction direction){

		int x = (int)component.getPosition().getX();
		int y = (int)component.getPosition().getY();

		switch (direction) {
			case UP: 	level.getLevel().get(x-1).set(y, component);
						component.setPosition(new Point(x-1,y));
						break;
						
			case DOWN:	level.getLevel().get(x+1).set(y, component);
						component.setPosition(new Point(x+1,y));
						break;
						
			case LEFT:  level.getLevel().get(x).set(y-1, component);
						component.setPosition(new Point(x,y-1));
						break;
						
			case RIGHT:	level.getLevel().get(x).set(y+1, component);
						component.setPosition(new Point(x,y+1));
						break;
		}
	}
	
	public Direction getDirection(){
		return direction;
	}
	
}