package com.bridgelabz.gamblingproblem;

public class GamblingProblem 
{
	public static final int STAKE=100;
	public static final int BET_EVERY_GAME=1;
	
	public static int stake=STAKE;
	public static int amountWon=0,amountLost=0;
	public static int totalStake = 0;
	
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
			System.out.println("Gambler lost ");
		}
		return betWin;
	}
	public static boolean resignStake()
	
	{ boolean resign=false;
		
		int stakePerecentage=(stake*100)/STAKE;
		
		System.out.println(stake);
		if(stakePerecentage>=150 || stakePerecentage<50)
		{
			
			resign=true;
		}
		return resign;
		
	}

	public static void  countStake()
	{
		
		totalStake=totalStake+stake;
		
		
	}
	
	public static void main(String[] args) 
	{
		boolean resign=false;
		boolean betResult=false;
		System.out.println("Welcoem to gambling problem");
		
		int numberOfDays=20;
		int countDays=0;
		int amount=0;
		
		while(countDays<numberOfDays)
		{
			stake=STAKE;
			
			while(resign==false)
			{
				betResult=makeBet();
				if(resignStake()==true)
				{
					System.out.println("Player resigned the game");
					countStake();
					break;
				}
			}
			
			countDays++;
			
		}
		
		System.out.println("After "+countDays+" days stake is "+totalStake);
	
	}

}