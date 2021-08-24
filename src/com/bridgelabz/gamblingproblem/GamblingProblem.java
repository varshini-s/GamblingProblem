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
	public static int daysWon=0,daysLost=0,totalWon=0,totalLost=0;
	public static int luckiestDay=0,unLuckiestDay=0,maxLost=0,maxWon=0;

	//To make bet and get result
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
	//To resign from game
	public static boolean resignStake()
	
	{ boolean resign=false;
		
		int stakePerecentage=(PerDayStake*100)/STAKE;
		
		System.out.println(PerDayStake);
		if(stakePerecentage>=150 || stakePerecentage<=50)
		{
			
			resign=true;
		}
		return resign;
		
	}
	//to track days won and lost
	public static void trackTotalWonLostDay()
	{
		if(PerDayStake>STAKE)
		{
			daysWon++;
			totalWon+=(PerDayStake-STAKE);
		}
		else
		{
			daysLost++;
			totalLost+=(STAKE-PerDayStake);
		}
		
	}
	//to play for given number of days
	public static void  playForGivenDays(int numberOfDays )
	
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
			//To keep track of total stakes won lost at the end of day
			trackTotalWonLostDay();
			trackMaxWonLostDay(index+1);
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
	//to track the day lost the maximum and won maximum
	public static void trackMaxWonLostDay(int currentDay)
	{
		
		if((PerDayStake>STAKE)&& (PerDayStake-STAKE)>maxWon)
		{
			luckiestDay=currentDay;
			maxWon=PerDayStake-STAKE;
		}
		else if((PerDayStake<STAKE)&& (STAKE-PerDayStake)>maxLost)
		{
			unLuckiestDay=currentDay;
			maxLost=STAKE-PerDayStake;
		}
		
		
		
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println("Welcome to gambling problem");
		
		int numberOfDays=20;
	
		playForGivenDays(numberOfDays);
		
		System.out.println("Total number of days won :"+daysWon+" and the stake won is "+totalWon);
		System.out.println("Total number of days lost :"+daysLost+" and the stake won is "+totalLost);
		
		System.out.println("The luckiest day was :"+luckiestDay+" and maximum won on that day is :"+maxWon);
		System.out.println("The Unluckiest day was :"+unLuckiestDay+" and maximum Lost on that day is :"+maxLost);


		
	
	}

}