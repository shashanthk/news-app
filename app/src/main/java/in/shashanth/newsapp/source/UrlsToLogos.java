package in.shashanth.newsapp.source;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shashanth on 27/8/17.
 */

public class UrlsToLogos {

    @SerializedName("small")
    private String small;
    @SerializedName("medium")
    private String medium;
    @SerializedName("large")
    private String large;

    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }
}
