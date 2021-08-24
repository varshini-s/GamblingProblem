package com.bridgelabz.gamblingproblem;

public class GamblingProblem 
{
	//Global Constants
	public static final int STAKE=100;
	public static final int BET_EVERY_GAME=1;

	//Global Variables
	public static int PerDayStake=STAKE;
	public static int amountWon=0,amountLost=0;
	public static int totalStakeRemaining = 0;
	public static boolean resign=false;
	public static boolean betResult=false;

	
	public static boolean makeBet()
	{
		boolean betWin=false;
		int output=(int)Math.floor(Math.random()*10)%2;
		
		if(output==1)
		{
			PerDayStake++;
			System.out.println("Gambler won");
		}
		else if(output==0)
		{
			PerDayStake--;
			System.out.println("Gambler lost ");
		}
		return betWin;
	}
	public static boolean resignStake()
	
	{ boolean resign=false;
		
		int stakePerecentage=(PerDayStake*100)/STAKE;
		
		System.out.println(PerDayStake);
		if(stakePerecentage>=150 || stakePerecentage<50)
		{
			
			resign=true;
		}
		return resign;
		
	}


	public static void  PlayForGivenDays(int numberOfDays )
	
	{
		for(int index=0;index<numberOfDays;index++)
		{
			PerDayStake=STAKE;

			while(resign==false)
			{
				betResult=makeBet();
				if(resignStake()==true)
				{
					System.out.println("Player resigned the game");

					totalStakeRemaining=totalStakeRemaining+PerDayStake;

					break;
				}
			}
			

		}
		
		int totalStakeGiven = STAKE*numberOfDays;
		
		if(totalStakeGiven>totalStakeRemaining)
		{
			System.out.println("Total stake lost by player: "+(totalStakeGiven-totalStakeRemaining));
		}
		else
		{
			System.out.println("Total stake Won by player: "+(totalStakeRemaining-totalStakeGiven));

			
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println("Welcome to gambling problem");
		
		int numberOfDays=20;
	
		PlayForGivenDays(numberOfDays);
		

	
	}

}