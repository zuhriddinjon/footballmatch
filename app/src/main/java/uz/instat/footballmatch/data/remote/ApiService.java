package uz.instat.footballmatch.data.remote;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import uz.instat.footballmatch.data.remote.model.req.MatchInfoReq;
import uz.instat.footballmatch.data.remote.model.req.MatchUrlReq;
import uz.instat.footballmatch.data.remote.model.res.MatchInfoRes;
import uz.instat.footballmatch.data.remote.model.res.MatchUrlRes;

public interface ApiService {

    @POST("test/data")
    Single<MatchInfoRes> getMatchInfo(@Body MatchInfoReq infoReq);

    @POST("test/video-urls")
    Single<ArrayList<MatchUrlRes>> getMatchUrlList(@Body MatchUrlReq urlReq);
}
