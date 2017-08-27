package in.shashanth.newsapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.shashanth.newsapp.R;
import in.shashanth.newsapp.interfaces.SourceView;
import in.shashanth.newsapp.models.Source;

/**
 * Created by shashanth on 27/8/17.
 */

public class SourcesListAdapter extends RecyclerView.Adapter<SourcesListAdapter.SourcesViewHolder> {

    private List<Source> sourceList;
    private SourceView sourceView;

    public SourcesListAdapter(List<Source> sourceList, SourceView sourceView) {
        this.sourceList = sourceList;
        this.sourceView = sourceView;
    }

    @Override
    public SourcesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_sources_row, parent, false);
        return new SourcesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SourcesViewHolder holder, int position) {
        bind(holder, sourceList.get(position));
    }

    private void bind(SourcesViewHolder holder, Source source) {
        holder.setSource(source);
        holder.lblSourceName.setText(source.getName());
        holder.lblSourceCategory.setText(source.getCategory());
        holder.lblSourceLanguage.setText(source.getLanguage());
        holder.lblSourceCountry.setText(source.getCountry());
        holder.lblSourceDesc.setText(source.getDescription());
        holder.itemView.setOnClickListener(holder);
    }

    @Override
    public int getItemCount() {
        return sourceList == null ? 0 : sourceList.size();
    }

    class SourcesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView lblSourceName, lblSourceCategory, lblSourceLanguage, lblSourceCountry, lblSourceDesc;

        private Source source;

        private SourcesViewHolder(View itemView) {
            super(itemView);

            lblSourceName = itemView.findViewById(R.id.lbl_source_name);
            lblSourceCategory = itemView.findViewById(R.id.lbl_source_category);
            lblSourceLanguage = itemView.findViewById(R.id.lbl_source_language);
            lblSourceCountry = itemView.findViewById(R.id.lbl_source_country);
            lblSourceDesc = itemView.findViewById(R.id.lbl_source_desc);

        }

        @Override
        public void onClick(View view) {
            sourceView.onSourceClicked(source);
        }

        private void setSource(Source source) {
            this.source = source;
        }
    }
}
