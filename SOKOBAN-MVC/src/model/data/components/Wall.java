package model.data.components;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Wall extends Components implements Serializable{

	public Wall() {}
	public Wall(Point position) { super(position); }

	@Override
	public ComponentsType getComponentType() {
		return ComponentsType.WALL;
	}

	@Override
	public char getObjRep() {
		return '#';
	}

	@Override
	public boolean onTarget() {
		return false; // wall can't be on target
	}

}
