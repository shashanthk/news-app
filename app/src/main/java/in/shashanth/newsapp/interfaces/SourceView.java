package in.shashanth.newsapp.interfaces;

import java.util.List;

import in.shashanth.newsapp.models.Source;

/**
 * Created by shashanth on 27/8/17.
 */

public interface SourceView {

    void showSources(List<Source> sourceList);
    void showAlertMessage(String message);
    void showProgressDialog(String message);
    void onSourceClicked(Source source);
    void hideProgressDialog();
}
