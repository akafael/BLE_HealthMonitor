package com.github.florent37.materialviewpager.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class MotionRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_accel_data, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_AXIS_X: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                TextView accelText = (TextView) view.findViewById(R.id.accelerationAxisLabel);
                accelText.setText("Acceleration X Axis:");

                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_AXIS_Y: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                TextView accelText = (TextView) view.findViewById(R.id.accelerationAxisLabel);
                accelText.setText("Acceleration Y Axis:");

                return new RecyclerView.ViewHolder(view) {
                };
            }

            case TYPE_AXIS_Z: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_raw_data, parent, false);

                TextView accelText = (TextView) view.findViewById(R.id.accelerationAxisLabel);
                accelText.setText("Acceleration Z Axis:");

                return new RecyclerView.ViewHolder(view) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
            case TYPE_AXIS_X:
                break;
            case TYPE_AXIS_Y:
                break;
            case TYPE_AXIS_Z:
                break;
        }
    }
}