package com.github.florent37.materialviewpager.sample;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MotionRecyclerViewAdapter extends RecyclerView.Adapter<MotionRecyclerViewAdapter.ChartViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 4;
    static final int TYPE_AXIS_X = 1;
    static final int TYPE_AXIS_Y = 2;
    static final int TYPE_AXIS_Z = 3;

    public MotionRecyclerViewAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            case 1:
                return TYPE_AXIS_X;
            case 2:
                return TYPE_AXIS_Y;
            case 3:
                return TYPE_AXIS_Z;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public MotionRecyclerViewAdapter.ChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_accel_data, parent, false);
                return new ChartViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                return new ChartViewHolder(view) {
                };
            }

            case TYPE_AXIS_X: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                return new ChartViewHolder(view) {
                };
            }

            case TYPE_AXIS_Y: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                return new ChartViewHolder(view) {
                };
            }

            case TYPE_AXIS_Z: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                return new ChartViewHolder(view) {
                };
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MotionRecyclerViewAdapter.ChartViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                UpdateChart((LineChart) holder.mChart);
                break;
            case TYPE_CELL:
                break;
            case TYPE_AXIS_X:
                holder.chartDescriptionText.setText( "Acceleration X Axis:");
                UpdateChart((LineChart) holder.mChart);
                break;
            case TYPE_AXIS_Y:
                holder.chartDescriptionText.setText("Acceleration Y Axis:");
                UpdateChart((LineChart) holder.mChart);
                break;
            case TYPE_AXIS_Z:
                holder.chartDescriptionText.setText( "Acceleration Z Axis:");
                UpdateChart((LineChart) holder.mChart);
                break;
        }
    }

    /**
     * View Holder for the chart cards
     */
    public class ChartViewHolder extends RecyclerView.ViewHolder{
        protected View mChart;
        protected TextView chartDescriptionText;


        public ChartViewHolder(View itemView) {
            super(itemView);

            mChart = itemView.findViewById(R.id.chart);
            chartDescriptionText = (TextView) itemView.findViewById(R.id.accelerationAxisLabel);
        }
    }

    public void UpdateChart(LineChart mChart){
        setData(mChart,30, 70);
        // Clean Format for the Chart
        mChart.setDragEnabled(false);
        mChart.setScaleEnabled(false);
        mChart.setDoubleTapToZoomEnabled(false);
        mChart.setDragEnabled(false);
        mChart.setDescription("");
        mChart.getAxisLeft().setEnabled(false);
        mChart.getAxisRight().setEnabled(false);
        mChart.getXAxis().setEnabled(false);
        mChart.getLegend().setEnabled(false);
    }

    private void setData(LineChart mChart,int count, float range) {

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
        set1.setColor(Color.BLUE);
        set1.setCircleColor(Color.BLUE);
        set1.setFillColor(Color.BLUE);
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


}