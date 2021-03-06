package com.treehouse.spacecraft.core.data.entity;

import java.awt.Rectangle;

public interface Entity {
	public void update(long delta);

	public void setLocation(double x, double y);
	
	public void setID(long id);
	
	public long getID();

	public void setX(double x);

	public void setY(double y);

	public void setWidth(double width);

	public void setHeight(double height);

	public double getX();

	public double getY();

	public double getHeight();

	public double getWidth();

	public boolean intersects(Entity other);

	public Rectangle getHitbox();
}
