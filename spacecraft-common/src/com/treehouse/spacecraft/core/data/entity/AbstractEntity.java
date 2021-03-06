package com.treehouse.spacecraft.core.data.entity;

import java.awt.Rectangle;
import java.io.Serializable;

public abstract class AbstractEntity implements Entity, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2126435635996441409L;
	protected double x, y, width, height;
	protected Rectangle hitbox;
	protected long id;

	public AbstractEntity(double x, double y, double width, double height) {
		hitbox = new Rectangle();
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	@Override
	public void setLocation(double x, double y) {
		setX(x);
		setY(y);
	}

	@Override
	public void setX(double x) {
		this.x = x;
		hitbox.x = (int) x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
		hitbox.y = (int) y;
	}

	@Override
	public void setWidth(double width) {
		this.width = width;
		hitbox.width = (int) width;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
		hitbox.height = (int) height;
	}

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

	@Override
	public double getHeight() {
		return this.height;
	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public Rectangle getHitbox() {
		return this.hitbox;
	}

	@Override
	public boolean intersects(Entity other) {
		return hitbox.intersects(other.getHitbox());
	}

	public boolean intersects(int x, int y) {
		return hitbox.contains(x, y);
	}
	
	@Override
	public long getID(){
		return this.id;
	}
	
	@Override
	public void setID(long id){
		this.id = id;
	}
}
