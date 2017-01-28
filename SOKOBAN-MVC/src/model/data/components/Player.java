package model.data.components;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Player extends Components implements Serializable{

	public Player() {}
	public Player(Point position) {	super(position); }
	
	@Override
	public ComponentsType getComponentType() {
		return ComponentsType.PLAYER;
	}

	@Override
	public char getObjRep() {
		return 'A';
	}

	@Override
	public boolean onTarget() {
		return onTarget;
	}

}
