package in.shashanth.newsapp.presenters;

import in.shashanth.newsapp.interfaces.RequestListener;
import in.shashanth.newsapp.interfaces.RestService;
import in.shashanth.newsapp.interfaces.SourceView;
import in.shashanth.newsapp.models.SourcesWrapper;

/**
 * Created by shashanth on 27/8/17.
 */

public class SourcesPresenter implements RequestListener<SourcesWrapper> {

    private SourceView sourceView;
    private RestService service;

    public SourcesPresenter(SourceView sourceView, RestService service) {
        this.sourceView = sourceView;
        this.service = service;
    }

    public void getSourcesList() {
        sourceView.showProgressDialog("Getting...");
        service.getSourcesList(SourcesPresenter.this);
    }

    @Override
    public void onSuccessResponse(SourcesWrapper sourcesWrapper) {

        sourceView.hideProgressDialog();

        if (sourcesWrapper != null) {
            if ("ok".equals(sourcesWrapper.getStatus())) {
                sourceView.showSources(sourcesWrapper.getSourcesList());
            } else {
                sourceView.showAlertMessage("Something went wrong...");
            }
        }
    }

    @Override
    public void onFailureResponse(Throwable t) {

        sourceView.hideProgressDialog();

        if (t != null) {
            sourceView.showAlertMessage(t.getMessage());
        }
    }

}
