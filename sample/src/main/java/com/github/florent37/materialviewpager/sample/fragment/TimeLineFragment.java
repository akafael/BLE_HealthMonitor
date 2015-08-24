package com.github.florent37.materialviewpager.sample.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.sample.R;
import com.github.florent37.materialviewpager.sample.common.ChartData;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;


public class TimeLineFragment extends Fragment {

    public static final String TAG = "HeartMonitoringFragment";
    private static final int NUM_POINTS_GRAPH = 60;

    /**
     * Linear Chart and Statistical Data
     */
    private LineChart mChart;
    private ChartData mData;
    int counter = 0;

    /**
     * Fragment View
     */
    private View rootView;

    private ObservableScrollView mScrollView;

    public static TimeLineFragment newInstance() {
        return new TimeLineFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_time_line, container, false);
        mChart = (LineChart) rootView.findViewById(R.id.chart);

        UpdateLinearChart();

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);

        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }

    public void UpdateLinearChart(){
        // Data
        setData(NUM_POINTS_GRAPH, 70);

        // Zoom Options
        mChart.zoom(2,1,0,0);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);
        mChart.setDoubleTapToZoomEnabled(false);

        // Legend Layout
        mChart.setDescription("");
        mChart.getLegend().setEnabled(false);

        // Y Axis Layout
        mChart.getAxisLeft().setEnabled(false);
        mChart.getAxisRight().setEnabled(false);

        // X Axis layout
        XAxis mXAxis = mChart.getXAxis();
        mXAxis.setDrawGridLines(true);
        mXAxis.setDrawAxisLine(false);
        mXAxis.setDrawLabels(true);
        mXAxis.setLabelsToSkip(5);
    }

    private void setData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add((i) + "");
        }

        ArrayList<Entry> yVals = new ArrayList<Entry>();


        for (int i = 0; i < count; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult) + 3;

            yVals.add(new Entry(val, i));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(yVals, "DataSet 1");
        // set1.setFillAlpha(110);

        // set the line to be drawn like this "- - - - - -"
        set1.setColor(Color.RED);
        set1.setCircleColor(Color.RED);
        set1.setFillColor(Color.RED);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);
        set1.setLineWidth(1f);
        set1.setCircleSize(4f);
        set1.setFillAlpha(65);

        // set1.setShader(new LinearGradient(0, 0, 0, mChart.getHeight(),
        // Color.BLACK, Color.WHITE, Shader.TileMode.MIRROR));

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);

        // set data
        mChart.setData(data);

    }

    private void plotData(float newValue) {

        mData.addNewData((float) counter,newValue);
        counter++;

        ArrayList<String> chartAxisXVals = new ArrayList<String>();
        ArrayList<Entry> chartAxisYVals = new ArrayList<Entry>();
        int size = mData.getTimeVals().size();

        for(int i = (size> NUM_POINTS_GRAPH)? NUM_POINTS_GRAPH :size,j=0;i>0;i--,j++){
            int n= size - i;
            float xval = mData.getTimeVals().get(n);
            float yval = mData.getyVals().get(n);
            chartAxisXVals.add(xval + "");
            chartAxisYVals.add(new Entry(yval,j));
        }

        LineDataSet set1 = new LineDataSet(chartAxisYVals, "Data");

        // set the line to be drawn like this "- - - - - -"
        set1.enableDashedLine(10f, 5f, 0f);
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleSize(4f);
        set1.setFillAlpha(65);
        set1.setFillColor(Color.BLACK);

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(chartAxisXVals, dataSets);

        // set data
        mChart.setData(data);
        mChart.setDescription("");
        mChart.notifyDataSetChanged();
    }
}
