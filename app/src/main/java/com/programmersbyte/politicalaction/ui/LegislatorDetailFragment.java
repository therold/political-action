package com.programmersbyte.politicalaction.ui;


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

import butterknife.Bind;
import butterknife.ButterKnife;


public class LegislatorDetailFragment extends Fragment {
    @Bind(R.id.profileImageView) ImageView mImageLabel;
    @Bind(R.id.legislatorNameTextView) TextView mNameLabel;
    @Bind(R.id.partyTextView) TextView mPartyLabel;
    @Bind(R.id.chamberTextView) TextView mChamberLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.saveLegislatorButton) Button mSaveLegislatorButton;

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

        mNameLabel.setText(mLegislator.getFullName());
        mPartyLabel.setText(mLegislator.getParty());
        mChamberLabel.setText(mLegislator.getChamber());
        mWebsiteLabel.setText(mLegislator.getWebsite());
        mPhoneLabel.setText(mLegislator.getPhone());
        mAddressLabel.setText(mLegislator.getOffice());

        return view;
    }

}
