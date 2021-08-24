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
			betWin=true;
		}
		else if(output==0)
		{
			betWin=false;
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
			System.out.println("Gambler won 1 dollar");
		}
		else
		{
			System.out.println("Gambler lost 1 dollar");

		}
		
		
		

	}

}