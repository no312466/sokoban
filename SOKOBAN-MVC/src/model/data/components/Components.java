package model.data.components;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Components implements Serializable {

	protected Point position;
	protected boolean onTarget = false;
	
	public Components() {}
	
	public Components(Point position) { 
		this.position = position; 
		}
		
	public abstract boolean onTarget();
	
	public abstract char getObjRep();
	
	public abstract ComponentsType getComponentType();

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public boolean getOnTarget() {
		return onTarget;
	}

	public void setOnTarget(boolean onTarget) {
		this.onTarget = onTarget;
	}

	

	
}
