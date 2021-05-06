package uz.instat.footballmatch.ui.match;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.instat.footballmatch.R;
import uz.instat.footballmatch.data.remote.model.req.MatchInfoReq;
import uz.instat.footballmatch.data.remote.model.req.MatchUrlReq;
import uz.instat.footballmatch.data.remote.model.req.Params;
import uz.instat.footballmatch.data.remote.model.res.MatchInfoRes;
import uz.instat.footballmatch.data.remote.model.res.MatchUrlRes;
import uz.instat.footballmatch.ui.match.adapter.MatchAdapter;
import uz.instat.footballmatch.ui.match.adapter.MatchModel;
import uz.instat.footballmatch.ui.match.movie.MatchMovieFragment;

public class MatchInfoFragment extends Fragment implements MatchContract.View, MatchAdapter.IClickListener {

    private MatchContract.Presenter presenter;
    private MatchInfoReq infoReq;
    private MatchUrlReq urlReq;

    private MatchAdapter adapter;
    private ArrayList<MatchModel> models;

    private AppCompatTextView tvMatchName;
    private AppCompatTextView tvMatchDate;
    private AppCompatTextView tvMatchTeam1;
    private AppCompatTextView tvMatchTeam2;
    private ProgressBar pbInfo;
    private ProgressBar pbRv;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MatchPresenter(this);

        infoReq = new MatchInfoReq("get_match_info", new Params(1L, 1724836L));
        urlReq = new MatchUrlReq(1724836L, 1L);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_match_info, container, false);
        tvMatchName = v.findViewById(R.id.tv_match_name);
        tvMatchDate = v.findViewById(R.id.tv_match_date);
        tvMatchTeam1 = v.findViewById(R.id.tv_match_team_1);
        tvMatchTeam2 = v.findViewById(R.id.tv_match_team_2);
        pbInfo = v.findViewById(R.id.pb_info);
        pbRv = v.findViewById(R.id.pb_rv);
        recyclerView = v.findViewById(R.id.rv_url);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            presenter.start();
        }
    }

    @Override
    public void init() {
        pbInfo.setVisibility(View.VISIBLE);
        pbRv.setVisibility(View.VISIBLE);
        presenter.loadMatchInfo(infoReq);
        presenter.loadMatchUrlList(urlReq);
    }

    @Override
    public void showErrorInfo(String message) {
        pbInfo.setVisibility(View.GONE);
    }

    @Override
    public void showErrorUrl(String message) {
        pbInfo.setVisibility(View.GONE);
    }

    @Override
    public void loadMatchInfo(MatchInfoRes infoRes) {
        tvMatchName.setText(infoRes.getTournament().getNameEng());
        tvMatchDate.setText(infoRes.getDate());
        tvMatchTeam1.setText(infoRes.getTeam1().getNameEng());
        tvMatchTeam2.setText(infoRes.getTeam2().getNameEng());
        pbInfo.setVisibility(View.GONE);
    }

    @Override
    public void loadMatchUrlList(ArrayList<MatchUrlRes> urlResList) {
        models = getModelList(urlResList);
        adapter = new MatchAdapter(models, this);
        recyclerView.setAdapter(adapter);
        pbRv.setVisibility(View.GONE);
    }

    private ArrayList<MatchModel> getModelList(ArrayList<MatchUrlRes> urlResList) {
        ArrayList<MatchModel> models = new ArrayList<>();

        for (int i = 0; i < urlResList.size(); i += 4) {
            MatchUrlRes urlRes = urlResList.get(i);
            MatchModel model = new MatchModel(urlRes.getName(), urlRes.getPeriod(), urlRes.getStartMs(), urlRes.getDuration());
            for (MatchUrlRes res : urlResList) {
                if (res.getName().equals(urlRes.getName()) && res.getPeriod() == urlRes.getPeriod()) {
                    switch (res.getQuality()) {
                        case "240":
                            model.setSize240(res.getSize());
                            model.setUrl240(res.getUrl());
                            break;
                        case "400":
                            model.setSize400(res.getSize());
                            model.setUrl400(res.getUrl());
                            break;
                        case "720":
                            model.setSize720(res.getSize());
                            model.setUrl720(res.getUrl());
                            break;
                        case "1000":
                            model.setSize1000(res.getSize());
                            model.setUrl1000(res.getUrl());
                            break;
                    }
                }
            }
            models.add(model);
        }
        return models;
    }

    @Override
    public void onItemClick(String url) {
        MatchMovieFragment fragment = MatchMovieFragment.newInstance(url);
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
