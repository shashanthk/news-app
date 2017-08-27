package in.shashanth.newsapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shashanth on 27/8/17.
 */

public class ArticlesWrapper {

    @SerializedName("status")
    private String status;
    @SerializedName("source")
    private String source;
    @SerializedName("sortBy")
    private String sortBy;
    @SerializedName("articles")
    private List<Articles> articles = null;

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<Articles> getArticles() {
        return articles;
    }
}
