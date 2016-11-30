package com.programmersbyte.politicalaction.models;

public class Legislator {
    private String mBioguideId;
    private boolean mInOffice;
    private String mParty;
    private String mGender;
    private String mState;
    private String mStateName;
    private Integer mDistrict; // null for Senators
    private String mTitle;
    private String mChamber;
    private Integer mSenateClass; // null for Congressmen
    private String mStateRank; // empty string for Congressmen
    private String mBirthday;
    private String mTermStart;
    private String mTermEnd;
    private String mFirstName;
    private String mMiddleName;
    private String mLastName;
    private String mNickname;
    private String mNameSuffix;
    private String mPhone;
    private String mWebsite;
    private String mOffice;
    private String mContactForm;
    private String mFax;
    private String mTwitterId;
    private String mYoutubeId;
    private String mFacebookId;

    public Legislator(String bioguideId, boolean inOffice, String party, String gender, String state,
                        String stateName, Integer district, String title, String chamber,
                        Integer senateClass, String stateRank, String birthday, String termStart,
                        String termEnd, String firstName, String middleName, String lastName,
                        String nickname, String nameSuffix, String phone, String website,
                        String office, String contactForm, String fax, String twitterId, String youtubeId,
                        String facebookId) {
        this.mBioguideId = bioguideId;
        this.mInOffice = inOffice;
        this.mParty = party;
        this.mGender = gender;
        this.mState = state;
        this.mStateName = stateName;
        this.mDistrict = district;
        this.mTitle = title;
        this.mChamber = chamber;
        this.mSenateClass = senateClass;
        this.mStateRank = stateRank;
        this.mBirthday = birthday;
        this.mTermStart = termStart;
        this.mTermEnd = termEnd;
        this.mFirstName = firstName;
        this.mMiddleName = middleName;
        this.mLastName = lastName;
        this.mNickname = nickname;
        this.mNameSuffix = nameSuffix;
        this.mPhone = phone;
        this.mWebsite = website;
        this.mOffice = office;
        this.mContactForm = contactForm;
        this.mFax = fax;
        this.mTwitterId =twitterId;
        this.mYoutubeId = youtubeId;
        this.mFacebookId = facebookId;
    }

    public String getBioguideId() {
        return mBioguideId;
    }

    public boolean isInOffice() {
        return mInOffice;
    }

    public String getParty() {
        return mParty;
    }

    public String getGender() {
        return mGender;
    }

    public String getState() {
        return mState;
    }

    public String getStateName() {
        return mStateName;
    }

    public Integer getDistrict() {
        return mDistrict;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getChamber() {
        return mChamber;
    }

    public Integer getSenateClass() {
        return mSenateClass;
    }

    public String getStateRank() {
        return mStateRank;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public String getTermStart() {
        return mTermStart;
    }

    public String getTermEnd() {
        return mTermEnd;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getMiddleName() {
        return mMiddleName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getNickname() {
        return mNickname;
    }

    public String getNameSuffix() {
        return mNameSuffix;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public String getOffice() {
        return mOffice;
    }

    public String getContactForm() {
        return mContactForm;
    }

    public String getFax() {
        return mFax;
    }

    public String getTwitterId() {
        return mTwitterId;
    }

    public String getYoutubeId() {
        return mYoutubeId;
    }

    public String getFacebookId() {
        return mFacebookId;
    }

}
