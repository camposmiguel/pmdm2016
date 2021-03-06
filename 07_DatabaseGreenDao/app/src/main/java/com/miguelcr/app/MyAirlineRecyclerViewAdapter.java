package com.miguelcr.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.miguelcr.app.localdb.Airline;
import com.miguelcr.app.localdb.OnAirlineListListener;

import java.util.List;

public class MyAirlineRecyclerViewAdapter extends RecyclerView.Adapter<MyAirlineRecyclerViewAdapter.ViewHolder> {

    private final List<Airline> mValues;
    private final OnAirlineListListener mListener;

    public MyAirlineRecyclerViewAdapter(List<Airline> items, OnAirlineListListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_airline_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewAirlineName.setText(mValues.get(position).getNombre());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onAirlineClickListener(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewAirlineName;
        public Airline mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewAirlineName = (TextView) view.findViewById(R.id.text_view_airline_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewAirlineName.getText() + "'";
        }
    }
}
