package com.programmersbyte.politicalaction.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.programmersbyte.politicalaction.R;
import com.programmersbyte.politicalaction.models.Legislator;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LegislatorListAdapter extends RecyclerView.Adapter<LegislatorListAdapter.LegislatorViewHolder> {
    private ArrayList<Legislator> mLegislators = new ArrayList<>();
    private Context mContext;

    public LegislatorListAdapter(Context context, ArrayList<Legislator> legislators) {
        mContext = context;
        mLegislators = legislators;
    }

    @Override
    public LegislatorListAdapter.LegislatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.legislator_list_item, parent, false);
        LegislatorViewHolder viewHolder = new LegislatorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LegislatorListAdapter.LegislatorViewHolder holder, int position) {
        holder.bindLegislator(mLegislators.get(position));
    }

    @Override
    public int getItemCount() {
        return mLegislators.size();
    }

    public class LegislatorViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.legislatorFullNameTextView) TextView mFullNameText;
        @Bind(R.id.partyTextView) TextView mPartyText;
        @Bind(R.id.chamberTextView) TextView mChamberText;

        private Context mContext;

        public LegislatorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindLegislator(Legislator legislator) {
            mFullNameText.setText(legislator.getFirstName() + " " + legislator.getLastName());
            mPartyText.setText(legislator.getParty());
            mChamberText.setText(legislator.getChamber());
        }
    }
}