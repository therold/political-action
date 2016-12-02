package com.programmersbyte.politicalaction.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.programmersbyte.politicalaction.R;
import com.programmersbyte.politicalaction.models.Legislator;
import com.programmersbyte.politicalaction.ui.LegislatorDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

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

    public class LegislatorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.legislatorFullNameTextView) TextView mFullNameText;
        @Bind(R.id.partyTextView) TextView mPartyText;
        @Bind(R.id.chamberTextView) TextView mChamberText;
        @Bind(R.id.legislatorImageView) ImageView mProfileImageView;

        private Context mContext;

        public LegislatorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, LegislatorDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("legislators", Parcels.wrap(mLegislators));
            mContext.startActivity(intent);
        }

        public void bindLegislator(Legislator legislator) {
            mFullNameText.setText(legislator.getFirstName() + " " + legislator.getLastName());
            mPartyText.setText(legislator.getParty() + " - " + legislator.getState());
            mChamberText.setText(legislator.getChamber());
            Picasso.with(mContext).load(legislator.getProfileImgUrl()).into(mProfileImageView);
        }
    }
}