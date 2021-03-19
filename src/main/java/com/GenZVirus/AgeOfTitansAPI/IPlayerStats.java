package com.GenZVirus.AgeOfTitansAPI;

public interface IPlayerStats {

	public int getPoints();
	
	public void setPoints(int points);

	public int getApplesEaten();
	
	public void setApplesEaten(int amount);
	
	public void appleEaten();

	public int getPlayerLevel();
	
	public void setPlayerLevel(int level);
	
	public void levelUp();
	
	public int getPlayerEXP();
	
	public void setPlayerEXP(int amount);
	
	public int getBalance();
	
	public void setBalance(int amount);

	public int getRagePoints();
	
	public void setRagePoints(int points);

	public int getMaxRagePoints();
	
	public void setMaxRagePoints(int points);
	

}
