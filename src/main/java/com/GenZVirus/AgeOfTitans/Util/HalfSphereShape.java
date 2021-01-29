package com.GenZVirus.AgeOfTitans.Util;

import net.minecraft.util.math.vector.Vector3d;

public class HalfSphereShape {
	
	public Vector3d tip_pos, base_pos;
	double height, bRadius, tRadius;
	
	public HalfSphereShape(Vector3d base_pos, Vector3d tip_pos) {
		
		this.tip_pos = tip_pos;
		this.base_pos = base_pos;
		this.height = Math.sqrt((this.tip_pos.x - base_pos.x) * (this.tip_pos.x - base_pos.x) + (this.tip_pos.y - base_pos.y) * (this.tip_pos.y - base_pos.y) + (this.tip_pos.z - base_pos.z) * (this.tip_pos.z - base_pos.z));
	}
	
	public boolean containsPoint(double x, double y, double z) {

		double dist = Math.sqrt((this.tip_pos.x - x) * (this.tip_pos.x - x) + (this.tip_pos.y - y) * (this.tip_pos.y - y) + (this.tip_pos.z - z) * (this.tip_pos.z - z));
		if(this.height - dist < 0) {
			return false;
		}

		double dist_point_base = Math.sqrt((this.base_pos.x - x) * (this.base_pos.x - x) + (this.base_pos.y - y) * (this.base_pos.y - y) + (this.base_pos.z - z) * (this.base_pos.z - z));
		if( dist_point_base <= this.height) {
			return true;
		}
		
		return false;
	}

	
	
}
