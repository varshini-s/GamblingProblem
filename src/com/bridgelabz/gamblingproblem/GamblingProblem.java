package com.bridgelabz.gamblingproblem;

public class GamblingProblem 
{
	public static int STAKE=100;
	public static int BET_EVERY_GAME=1;
	
	public static boolean makeBet()
	{
		boolean betWin=false;
		int output=(int)Math.floor(Math.random()*10)%2;
		
		if(output==1)
		{
			stake++;
			System.out.println("Gambler won");
		}
		else if(output==0)
		{
			stake--;
			System.out.println("Gambler ");
		}
		return betWin;
	}

	public static void main(String[] args) 
	{
		boolean betResult=false;
		System.out.println("Welcoem to gambling problem");
		
		
		betResult=makeBet();
		if(betResult==true)
		{
			
		}
		else
		{
			

		}
		
		
		

	}

}