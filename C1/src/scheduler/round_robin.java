package scheduler;

import java.util.Scanner;

public class round_robin 
{
	String pno;
	int btime;
	int wtime;
	int tatime;
	int atime;
	int time;
	Scanner in = new Scanner(System.in);

	void get()
	{
		Scanner in = new Scanner(System.in);
		int pro=0;
		System.out.println("Enter the number of Processes.");
		pro=in.nextInt();
		round_robin[] p_array = new round_robin[pro];
		int i;
		for(i=0;i<pro;i++)
		{
			p_array[i]= new round_robin();
			System.out.println("Enter for Process P"+i+":");
			p_array[i].pno= "P"+i;
			System.out.println("Enter burst time in minutes.");
			p_array[i].btime= in.nextInt();
			p_array[i].time= p_array[i].btime;
			System.out.println("Enter arrival time.");
			p_array[i].atime= in.nextInt();
		}
		System.out.println("Enter the period of time slice.");
		int slice=in.nextInt();
		algo(p_array, pro, slice);
	}
	private static void algo(round_robin[] p_array, int pro, int slice)
	{
		int j=0;
		while(check(p_array,pro)==false)
		{
		for(int i=0;i<pro;i++)
		{
			if(p_array[i].atime<=j && p_array[i].time!=0)
			{
				p_array[i].time-= slice;
			}
			j=j+slice;
			if(p_array[i].time!=0)
			{
				p_array[i].wtime+= slice;
			}
		}
		display(p_array, pro);
		}
	}
	static boolean check(round_robin[] p_array, int pro)
	{
		boolean c=true;
		for(int i=0;i<pro;i++)
		{
			if(p_array[i].time!=0)
			{
				c=false;
				return c;
			}
		}
		
		return c;
	}
	static void display(round_robin[] p_array, int pro)
	{
		System.out.println();
		System.out.println("P_id\t\tArrival_time\t\tWait_time\t\tBurst\t\tTime_required_to_complete\t\tStatus");
		System.out.println("_____________________________________________________________________________________________________________________________________________________________");
		System.out.println();
		for(int i=0;i<pro;i++)
		{
			if(p_array[i].time>0)
			{
				System.out.println(p_array[i].pno+"\t\t"+p_array[i].atime+"\t\t\t"+p_array[i].wtime+"\t\t\t"+p_array[i].btime+"\t\t"+p_array[i].time+"\t\t\t\t\tIncomplete");
			}
			    else
			{
			   	p_array[i].time=0;
			    System.out.println(p_array[i].pno+"\t\t"+p_array[i].atime+"\t\t\t"+p_array[i].wtime+"\t\t\t"+p_array[i].btime+"\t\t"+p_array[i].time+"\t\t\t\t\tComplete");
			}
		}
	}						
}
