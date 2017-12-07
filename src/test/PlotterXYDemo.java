package test;

import org.junit.jupiter.api.Test;

import plotting.PlotterXY;

public class PlotterXYDemo {

	/**
	 * Tests a simple plot for 2 constant series, where one series
	 * only gets plotted until half the time has passed
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testXYPlot() throws InterruptedException
	{
		PlotterXY demoPlot = new PlotterXY(2);
		
		//we have no started JFX yet
		boolean fxOn=false;
		
		//setting up all the data
		String plotTitle = "demoPlot";
		String windowTitle = "plotWindow";
		String titleX = "time[sec]";
		String[] Tags = new String[2];
		Tags[0] = "constantly_1";
		Tags[1] = "constantly_2";
		int height = 1000;
		int width = 1000;
		
		//putting the data into the plotter
		demoPlot.initializePlotter(fxOn, plotTitle, windowTitle, titleX, Tags, height, width);
		
		float time=0;
		float dur=11;
		
		while (time<dur/2)
		{ 	
			//create y-series
			float[] data = new float[2];
			data[0] = 1;
			data[1] = 2;
			demoPlot.plotFullDataSetXY(time, data);
			time += 1;
			Thread.sleep(1000);
		}
		
		while (time<dur)
		{ 	
			//create a new entry for only one y-series
			float y = 1;
			int index = 0;
			demoPlot.plotSingleDataXY(time, y, index);
			time += 1;
			Thread.sleep(1000);
		}
		System.out.println("Plot finished");
	}
	
	/**
	 * i basically just wanted to know how long it takes to get the current system time
	 */
	@Test
	public void printTime()
	{
		System.out.println(System.currentTimeMillis());
	}
}
