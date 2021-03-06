package com.treehouse.spacecraft.core.data.entity;

public interface MoveableEntity extends Entity {
	public EntityType getType();

	public float getSpeed();
	
	public void setSpeed(float speed);
	
	public float getRotation();
	
	public void setRotation(float rotation);
}
