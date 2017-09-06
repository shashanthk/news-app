package in.shashanth.newsapp.source;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shashanth on 27/8/17.
 */

public class Source {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("category")
    private String category;
    @SerializedName("language")
    private String language;
    @SerializedName("country")
    private String country;
    @SerializedName("urlsToLogos")
    private UrlsToLogos urlsToLogos;
    @SerializedName("sortBysAvailable")
    private List<String> sortBysAvailable = null;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return (category.substring(0, 1).toUpperCase() + category.substring(1));
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public UrlsToLogos getUrlsToLogos() {
        return urlsToLogos;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }
}
