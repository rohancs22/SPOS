package scheduler;

import java.util.Scanner;

public class sjf 
{
	String pno;
	int btime;
	int wtime=0;
	int tatime;
	int atime;
	int time;
	int ctime=0;
	//static int t=0;
	Scanner in = new Scanner(System.in);

	void algo()
	{
		int total_time=0;
		Scanner in = new Scanner(System.in);
		int pro=10,shortest=1000;
		sjf[] p_array = new sjf[pro];
		int i=0,sum=0,m=0;
		for(i=0;;i++)
		{
			System.out.println("Arrival time = "+i);
			System.out.println("Any new processes at this time?(y/n)");
			String ans=in.next();
			if(ans.equals("y"))
			{
				System.out.println("Enter the number of arriving Processes at this time.");
				int num=in.nextInt();
				while(num!=0)
				{
			       p_array[m]= new sjf();
			       System.out.println("Enter for Process P"+m+":");
			       p_array[m].pno= "P"+m;
			       System.out.println("Enter burst time in minutes.");
			       p_array[m].btime= in.nextInt();
			       total_time+=p_array[m].btime;
			       p_array[m].atime= i;
			       sum=sum+p_array[m].btime;
			       p_array[m].time= 0;
			       if(p_array[m].btime<=(p_array[0].btime-p_array[0].time))
			       {
			    	   shortest= p_array[m].btime;
			    	   sjf temp=new sjf();
			    	   temp= p_array[m];
			    	   p_array[m]=p_array[0];
			    	   p_array[0]=temp;
			       }
			       m++;
			       num--;
				}
			}
			if((p_array[0].btime-p_array[0].time)==0)
			{
				shortest=1000;
				for(int z=1;z<m;z++)
				{
					if((p_array[z].btime-p_array[z].time)<shortest && (p_array[z].btime-p_array[z].time)!=0)
					{
						shortest=(p_array[z].btime-p_array[z].time);
						sjf temp=new sjf();
						temp= p_array[z];
						p_array[z]=p_array[0];
						p_array[0]=temp;
					}
				}
			}
			if(p_array[0].time!=p_array[0].btime)
			{
				p_array[0].time++;
				for(int a=1;a<m;a++)
				{
					if(p_array[a].btime!=p_array[a].time)
						p_array[a].wtime++;
				}
			}
			total_time= display(p_array, m, total_time, i);
			if(total_time==0)
			{
				System.out.println("All jobs Completed in time = "+(i+1));
				final_display(p_array, m);
				break;
			}
		}
	}
	int display(sjf[] p_array, int x, int total_time, int y)
	{
		System.out.println();
		System.out.println("P_id\t\tArrival_time\t\tWait_time\t\tBurst\t\tTime_completed\t\tTime_required_to_complete\t\tStatus");
		System.out.println("_____________________________________________________________________________________________________________________________________________________________");
		System.out.println();
		for(int i=0;i<x;i++)
		{
			if(p_array[i].time!=p_array[i].btime)
			{
				System.out.println(p_array[i].pno+"\t\t"+p_array[i].atime+"\t\t\t"+p_array[i].wtime+"\t\t\t"+p_array[i].btime+"\t\t"+p_array[i].time+"\t\t\t"+(p_array[i].btime-p_array[i].time)+"\t\t\t\t\tIncomplete");
			}
			    else
			{
			    System.out.println(p_array[i].pno+"\t\t"+p_array[i].atime+"\t\t\t"+p_array[i].wtime+"\t\t\t"+p_array[i].btime+"\t\t"+p_array[i].time+"\t\t\t"+(p_array[i].btime-p_array[i].time)+"\t\t\t\t\tComplete");
			    if(p_array[i].ctime==0)
			    {
			       p_array[i].ctime=y;
			    }
			}
		}
		System.out.println();
		total_time-=1;
		System.out.println("Total time remaining to complete all jobs= "+total_time);
		System.out.println();
		return total_time;
	}
	void final_display(sjf[] p_array, int x)
	{
		System.out.println();
		System.out.println("P_id\t\tArrival_time\t\tWait_time\t\tBurst\t\tTurn_Around\t\tCompletion_time");
		System.out.println("_____________________________________________________________________________________________________________________________________________________________");
		System.out.println();
		for(int i=0;i<x;i++)
		{
			System.out.println(p_array[i].pno+"\t\t"+p_array[i].atime+"\t\t\t"+p_array[i].wtime+"\t\t\t"+p_array[i].btime+"\t\t"+(p_array[i].btime+p_array[i].wtime)+"\t\t\t"+(p_array[i].ctime+1));
		}
		System.out.println();
	}
}