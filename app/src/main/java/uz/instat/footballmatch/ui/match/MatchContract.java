package uz.instat.footballmatch.ui.match;

import java.util.ArrayList;

import uz.instat.footballmatch.data.remote.model.req.MatchInfoReq;
import uz.instat.footballmatch.data.remote.model.req.MatchUrlReq;
import uz.instat.footballmatch.data.remote.model.res.MatchInfoRes;
import uz.instat.footballmatch.data.remote.model.res.MatchUrlRes;

public interface MatchContract {

    interface View {
        void init();

        void showErrorInfo(String message);

        void showErrorUrl(String message);

        void loadMatchInfo(MatchInfoRes infoRes);

        void loadMatchUrlList(ArrayList<MatchUrlRes> urlResList);
    }

    interface Presenter {

        void start();

        void loadMatchInfo(MatchInfoReq infoReq);

        void loadMatchUrlList(MatchUrlReq urlReq);

    }

}
