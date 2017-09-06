package in.shashanth.newsapp.interfaces;

import in.shashanth.newsapp.articles.ArticlesWrapper;
import in.shashanth.newsapp.source.SourcesWrapper;

/**
 * Created by shashanth on 27/8/17.
 */

public interface RestService {

    void getSourcesList(RequestListener<SourcesWrapper> listener);
    void getArticlesList(String source, RequestListener<ArticlesWrapper> listener);
}
