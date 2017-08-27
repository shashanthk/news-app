package in.shashanth.newsapp.interfaces;

import in.shashanth.newsapp.models.ArticlesWrapper;
import in.shashanth.newsapp.models.SourcesWrapper;

/**
 * Created by shashanth on 27/8/17.
 */

public interface RestService {

    void getSourcesList(RequestListener<SourcesWrapper> listener);
    void getArticlesList(String source, RequestListener<ArticlesWrapper> listener);
}
