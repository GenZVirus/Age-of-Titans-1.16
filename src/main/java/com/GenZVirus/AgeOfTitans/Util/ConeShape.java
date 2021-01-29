package com.GenZVirus.AgeOfTitans.Util;

import net.minecraft.util.math.vector.Vector3d;

public class ConeShape {
	
	public Vector3d tip_pos, base_pos;
	double height, bRadius, tRadius;
	
	public ConeShape(Vector3d base_pos, Vector3d tip_pos, double bRadius, double tRadius ) {
		
		this.tip_pos = tip_pos;
		this.base_pos = base_pos;
		this.height = Math.sqrt((this.tip_pos.x - base_pos.x) * (this.tip_pos.x - base_pos.x) + (this.tip_pos.y - base_pos.y) * (this.tip_pos.y - base_pos.y) + (this.tip_pos.z - base_pos.z) * (this.tip_pos.z - base_pos.z));
		this.bRadius = bRadius;
		this.tRadius = tRadius;
	}
	
	public boolean containsPoint(double x, double y, double z) {

		double dist = Math.sqrt((this.base_pos.x - x) * (this.base_pos.x - x) + (this.base_pos.y - y) * (this.base_pos.y - y) + (this.base_pos.z - z) * (this.base_pos.z - z));
		if(this.height - dist < 0) {
			return false;
		}

		Vector3d v = new Vector3d(x - this.tip_pos.x, y - this.tip_pos.y, z - this.tip_pos.z);
		Vector3d w = new Vector3d(this.base_pos.x - this.tip_pos.x, this.base_pos.y - this.tip_pos.y, this.base_pos.z - this.tip_pos.z);
		double a = Math.sqrt((this.tip_pos.x - x) * (this.tip_pos.x - x) + (this.tip_pos.y - y) * (this.tip_pos.y - y) + (this.tip_pos.z - z) * (this.tip_pos.z - z));
		double pointRadius = v.crossProduct(w).length() / w.length();	
		
		double radiusSlice = this.bRadius * Math.sqrt(a * a - pointRadius * pointRadius) / this.height;
		
		if(pointRadius <= radiusSlice) {
			return true;
		}
		
		return false;
	}

	
	
}
