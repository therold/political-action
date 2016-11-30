package com.programmersbyte.politicalaction.services;

import com.programmersbyte.politicalaction.Constants;
import com.programmersbyte.politicalaction.models.Legislator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SunlightService {
    public static void findLegislators(String chamber, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.SUNLIGHT_BASE_URL).newBuilder();
        urlBuilder.addPathSegment(Constants.SUNLIGHT_LEGISLATOR_BASE_PATH);
        urlBuilder.addQueryParameter(Constants.SUNLIGHT_LEGISTATOR_CHAMBER_QUERY_PARAMETER, chamber);
        urlBuilder.addQueryParameter(Constants.SUNLIGHT_LEGISTATOR_PAGELIMIT_QUERY_PARAMETER, "all");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Legislator> processResults(Response response) {
        ArrayList<Legislator> legislators = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject sunlightJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = sunlightJSON.getJSONArray("results");
                for(int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject legislatorJSON = resultsJSON.getJSONObject(i);
                    String bioguideId = legislatorJSON.getString("bioguide_id");
                    boolean inOffice = legislatorJSON.getBoolean("in_office");
                    String party = legislatorJSON.getString("party");
                    String gender = legislatorJSON.getString("gender");
                    String state = legislatorJSON.getString("state");;
                    String stateName = legislatorJSON.getString("state_name");
                    Integer district = legislatorJSON.optInt("district");
                    String title = legislatorJSON.getString("title");
                    String chamber = legislatorJSON.getString("chamber");
                    Integer senateClass = legislatorJSON.optInt("senate_class");
                    String stateRank = legislatorJSON.optString("senate_rank");
                    String birthday = legislatorJSON.getString("birthday");
                    String termStart = legislatorJSON.getString("term_start");
                    String termEnd = legislatorJSON.getString("term_end");
                    String firstName = legislatorJSON.getString("first_name");
                    String middleName = legislatorJSON.getString("middle_name");
                    String lastName = legislatorJSON.getString("last_name");
                    String nickname = legislatorJSON.getString("nickname");
                    String nameSuffix = legislatorJSON.getString("name_suffix");
                    String phone = legislatorJSON.getString("phone");
                    String website = legislatorJSON.getString("website");
                    String office = legislatorJSON.getString("office");
                    String contactForm = legislatorJSON.optString("contact_form");
                    String fax = legislatorJSON.optString("fax");
                    String twitterId = legislatorJSON.optString("twitter_id");
                    String youtubeId = legislatorJSON.optString("youtube_id");
                    String facebookId = legislatorJSON.optString("facebook_id");

                    Legislator legislator = new Legislator(bioguideId, inOffice, party, gender, state,
                        stateName, district, title, chamber, senateClass, stateRank, birthday, termStart,
                        termEnd, firstName, middleName, lastName, nickname, nameSuffix, phone, website,
                        office, contactForm, fax, twitterId, youtubeId, facebookId);
                    legislators.add(legislator);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return legislators;
    }
}
