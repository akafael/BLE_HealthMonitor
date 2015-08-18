package com.github.florent37.materialviewpager.sample.fragment;

import java.util.ArrayList;

/**
 * Created by root on 8/5/15.
 */
public class ChartData {

    private static int MAX_SIZE_BUFFER = 1000;

    private ArrayList<Float> timeVals = new ArrayList<Float>();
    private ArrayList<Float> yVals = new ArrayList<Float>();

    private int count = 0;
    private float statisticYMax = Float.MIN_VALUE;
    private float statisticYMin = Float.MAX_VALUE;
    private float statisticYMean = 0f;

    public ChartData(){
        addNewData(0f,0f);
    }

    public void addNewData(float time, float yVal){
        timeVals.add(time);
        yVals.add(yVal);

        // Basic Statistics:
        statisticYMax = ((statisticYMax > yVal) ? statisticYMax : yVal);
        statisticYMin = ((statisticYMin > yVal) ? yVal : statisticYMin);
        statisticYMean = (statisticYMean*count + yVal)/(count+1);
        count++;
    }

    /**
     * Function to return the max value for Y
     * @return
     */
    public float getYMax(){
        return statisticYMax;
    }

    /**
     * Function to return the lower value for Y
     * @return
     */
    public float getYMin(){
        return statisticYMin;
    }

    /**
     * Function to return the Y Mean
     * @return
     */
    public float getYMean(){
        return statisticYMean;
    }

    /**
     * Get Size of Data
     * @return
     */
    public int getSize(){
        return count;
    }

    /**
     * Get the last value
     * @return
     */
    public float getLast(){return yVals.get(count-1);}

    /**
     * Function to return time values
     * @return
     */
    public ArrayList<Float> getTimeVals(){
        return timeVals;
    }

    /**
     * Funcion to return Y values
     * @return
     */
    public ArrayList<Float> getyVals(){
        return yVals;
    }

}
