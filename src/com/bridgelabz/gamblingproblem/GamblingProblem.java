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
	public static boolean betResult=false,won=false,stopPlaying=false;
	public static int daysWon=0,daysLost=0,totalWon=0,totalLost=0;
	public static int luckiestMonth=0,unLuckiestMonth=0,maxLost=0,maxWon=0;

	//To make bet and get result
	public static boolean makeBet()
	{
		boolean betWin=false;
		int output=(int)Math.floor(Math.random()*10)%2;
		
		if(output==1)
		{
			PerDayStake++;
			
		}
		else if(output==0)
		{
			PerDayStake--;
		}
		return betWin;
	}
	//To resign from game
	public static boolean resignStake()
	
	{ boolean resign=false;
		
		int stakePerecentage=(PerDayStake*100)/STAKE;
		

		if(stakePerecentage>=150 || stakePerecentage<50)
		{
			
			resign=true;
		}
		return resign;
		
	}
	//to track days won and lost

	public static void playForGivenMonths(int numberOfMonths)
	{
		int numberOfDays=30;
		
		for(int index=0;index<numberOfMonths;index++)
		{
			playForGivenDays(numberOfDays);
			trackMaxWonLostDay(index);
		
			
			System.out.println("Number of days won in the month "+index+"  is"+daysWon);

			System.out.println("Number of days lost in the month "+index+"  is"+daysLost);
			
			decideToPlay();
			if(stopPlaying)
			{
				break;
			}

		}
		
		
		
	}
	//to play for given number of days
	public static void  playForGivenDays(int numberOfDays )
	
	{	
		daysLost=0;
		daysWon=0;
		for(int index=0;index<numberOfDays;index++)
		{
			PerDayStake=STAKE;

			while(resign==false)
			{
				betResult=makeBet();
				if(resignStake()==true)
				{
					//System.out.println("Player resigned the game");

					totalStakeRemaining=totalStakeRemaining+PerDayStake;

					break;
				}
			}
	
			//to track the days lost and won
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
		
		int totalStakeGiven = STAKE*numberOfDays;
		
		if(totalStakeGiven>totalStakeRemaining)
		{
			won=false;
			System.out.println("Total stake lost by player: "+(totalStakeGiven-totalStakeRemaining));
		}
		else
		{
			won=true;
			System.out.println("Total stake Won by player: "+(totalStakeRemaining-totalStakeGiven));

			
		}
		totalStakeRemaining=0;
	}
	//to track the day lost the maximum and won maximum
	public static void trackMaxWonLostDay(int currentMonth)
	{
		
		if(daysWon>maxWon)
		{
			luckiestMonth=currentMonth;
			maxWon=daysWon;
		}
		else if(daysLost>maxLost)
		{
			unLuckiestMonth=currentMonth;
			maxLost=daysLost;
		}
		
		
		
	}
	public static void decideToPlay()
	{
		if(won==true)
		{
			System.out.println("Player decides to continue playing the game next month");
		}
		else
		{
			stopPlaying=true;
			System.out.println("Player decides to stop playing the game next month");

		}
		
	}
	
	
	public static void main(String[] args) 
	{
		
		System.out.println("Welcome to gambling problem");
		
		
		int numberOfMonths=5;
		playForGivenMonths(numberOfMonths);
		
		System.out.println("Total number of days won :"+daysWon+" and the stake won is "+totalWon);
		System.out.println("Total number of days lost :"+daysLost+" and the stake won is "+totalLost);
		
		System.out.println("The luckiest month was :"+luckiestMonth);
		System.out.println("The Unluckiest month was :"+unLuckiestMonth);


		
	
	}

}