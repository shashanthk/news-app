package in.shashanth.newsapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shashanth on 27/8/17.
 */

public class SourcesWrapper {

    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String errorMessage;
    @SerializedName("sources")
    private List<Source> sources = null;

    public String getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<Source> getSourcesList() {
        return sources;
    }
}
