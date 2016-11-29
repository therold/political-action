package com.programmersbyte.politicalaction;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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
}
