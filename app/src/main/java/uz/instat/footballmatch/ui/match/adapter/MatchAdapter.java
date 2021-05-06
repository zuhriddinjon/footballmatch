package uz.instat.footballmatch.ui.match.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.instat.footballmatch.R;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchVH> {
    private IClickListener clickListener;
    private ArrayList<MatchModel> modelList;

    public MatchAdapter(ArrayList<MatchModel> modelList, IClickListener clickListener) {
        this.modelList = modelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MatchVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match_url, parent, false);
        return new MatchVH(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchVH holder, int position) {
        holder.onBind(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class MatchVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AppCompatTextView tvName;
        private final AppCompatButton btnQuality240;
        private final AppCompatButton btnQuality400;
        private final AppCompatButton btnQuality720;
        private final AppCompatButton btnQuality1000;
        private MatchModel model;
        private IClickListener clickListener;

        public MatchVH(@NonNull View itemView, IClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
            tvName = itemView.findViewById(R.id.tv_video_name);
            btnQuality240 = itemView.findViewById(R.id.btn_video_quality_240);
            btnQuality400 = itemView.findViewById(R.id.btn_video_quality_400);
            btnQuality720 = itemView.findViewById(R.id.btn_video_quality_720);
            btnQuality1000 = itemView.findViewById(R.id.btn_video_quality_1000);

            btnQuality240.setOnClickListener(this);
            btnQuality400.setOnClickListener(this);
            btnQuality720.setOnClickListener(this);
            btnQuality1000.setOnClickListener(this);
        }

        public void onBind(MatchModel model) {
            tvName.setText(model.getName());
            this.model = model;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_video_quality_240:
                    clickListener.onItemClick(model.getUrl240());
                    break;
                case R.id.btn_video_quality_400:
                    clickListener.onItemClick(model.getUrl400());
                    break;
                case R.id.btn_video_quality_720:
                    clickListener.onItemClick(model.getUrl720());
                    break;
                case R.id.btn_video_quality_1000:
                    clickListener.onItemClick(model.getUrl1000());
                    break;

            }
        }
    }

    public interface IClickListener {
        void onItemClick(String url);
    }

}
