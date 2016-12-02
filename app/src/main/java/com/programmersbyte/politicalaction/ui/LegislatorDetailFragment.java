package com.programmersbyte.politicalaction.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import com.programmersbyte.politicalaction.R;
import com.programmersbyte.politicalaction.models.Legislator;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LegislatorDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.profileImageView) ImageView mImageLabel;
    @Bind(R.id.legislatorNameTextView) TextView mNameLabel;
    @Bind(R.id.partyTextView) TextView mPartyLabel;
    @Bind(R.id.chamberTextView) TextView mChamberLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.twitterTextView) TextView mTwitterLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    private Legislator mLegislator;

    public static LegislatorDetailFragment newInstance(Legislator legislator) {
        LegislatorDetailFragment legislatorDetailFragment = new LegislatorDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("legislator", Parcels.wrap(legislator));
        legislatorDetailFragment.setArguments(args);
        return legislatorDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLegislator = Parcels.unwrap(getArguments().getParcelable("legislator"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_legislator_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mLegislator.getProfileImgUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);

        mNameLabel.setText(mLegislator.getFullName());
        mPartyLabel.setText(mLegislator.getParty() + " - " + mLegislator.getState());
        mChamberLabel.setText(mLegislator.getChamber());
        mWebsiteLabel.setText(mLegislator.getWebsite());
        mTwitterLabel.setText("@" + mLegislator.getTwitterId());
        mPhoneLabel.setText(mLegislator.getPhone());
        mAddressLabel.setText(mLegislator.getOffice());

        mWebsiteLabel.setOnClickListener(this);
        mTwitterLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mLegislator.getWebsite()));
            startActivity(webIntent);
        } else if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mLegislator.getPhone()));
            startActivity(phoneIntent);
        } else if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + mLegislator.getOffice()));
            startActivity(mapIntent);
        } else if (v == mTwitterLabel) {
            Intent intent = null;
            try {
                this.getActivity().getPackageManager().getPackageInfo("com.twitter.android", 0);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=" + mLegislator.getTwitterId()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + mLegislator.getTwitterId()));
            }
            startActivity(intent);
        }
    }

}
