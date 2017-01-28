package model;

import java.util.Observable;

import model.data.level.Level;
import model.moveable.Moveable;
import model.moveable.MySokobanMoveable;
import model.receivers.move.Direction;
import model.receivers.move.Move;

public class MyModel extends Observable implements Model {

	private Level level = null;
	private Move moveUp = null;
	private Move moveDown = null;
	private Move moveRight = null;
	private Move moveLeft = null;
	private Moveable movable = null;

	@Override
	public void move(Direction direction) {
		if (level == null){
			//System.out.println("there is no level loaded");
			return;
		}
		
		switch(direction) {
		
		case UP:	movable.execute(moveUp);
					break;
			 
		case DOWN:  movable.execute(moveDown);
					break;
			
		case RIGHT: movable.execute(moveRight);
					break;
			
		case LEFT:  movable.execute(moveLeft);
				   	break;
			
		default:	
					  break;
		}		
		setChanged();
		notifyObservers("display");
	
	}

	@Override
	public Level getLevel() {
		return level;
	}
	
	@Override
	public void setLevel(Level level) {
		this.level = level;
		movable = new MySokobanMoveable(level);	
	
		moveUp = new Move(level,level.getPlayer(),Direction.UP);
		moveDown = new Move(level,level.getPlayer(),Direction.DOWN);
		moveLeft = new Move(level,level.getPlayer(),Direction.LEFT);
		moveRight = new Move(level,level.getPlayer(),Direction.RIGHT);
		
		setChanged();
		notifyObservers("display");
		
	}
	
}
