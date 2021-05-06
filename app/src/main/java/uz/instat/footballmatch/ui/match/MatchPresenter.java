package uz.instat.footballmatch.ui.match;

import android.util.Log;

import java.util.ArrayList;

import uz.instat.footballmatch.data.remote.model.req.MatchInfoReq;
import uz.instat.footballmatch.data.remote.model.req.MatchUrlReq;
import uz.instat.footballmatch.data.remote.model.res.MatchInfoRes;
import uz.instat.footballmatch.data.remote.model.res.MatchUrlRes;

public class MatchPresenter implements MatchContract.Presenter {
    MatchContract.View view;

    MatchPresenter(MatchContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        view.init();
    }

    @Override
    public void loadMatchInfo(MatchInfoReq infoReq) {
        MatchTask.getMatchInfo(infoReq, new MyCallBack<MatchInfoRes>() {
            @Override
            public void onSuccess(MatchInfoRes matchInfoRes) {
                view.loadMatchInfo(matchInfoRes);
            }

            @Override
            public void onError(String message) {
                view.showErrorInfo(message);
            }
        });
    }

    @Override
    public void loadMatchUrlList(MatchUrlReq urlReq) {
        Log.d("TAG", "loadMatchUrlList: ");

        MatchTask.getMatchUrl(urlReq, new MyCallBack<ArrayList<MatchUrlRes>>() {
            @Override
            public void onSuccess(ArrayList<MatchUrlRes> urlRes) {
                Log.d("TAG", "loadMatchUrlList: ");

                view.loadMatchUrlList(urlRes);
            }

            @Override
            public void onError(String message) {
                Log.d("TAG", "showErrorUrl: " + message);
                view.showErrorUrl(message);

            }
        });
    }
}
