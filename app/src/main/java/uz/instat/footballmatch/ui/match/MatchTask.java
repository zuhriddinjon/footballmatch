package uz.instat.footballmatch.ui.match;

import android.util.Log;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import uz.instat.footballmatch.data.remote.NetworkService;
import uz.instat.footballmatch.data.remote.model.req.MatchInfoReq;
import uz.instat.footballmatch.data.remote.model.req.MatchUrlReq;
import uz.instat.footballmatch.data.remote.model.res.MatchInfoRes;
import uz.instat.footballmatch.data.remote.model.res.MatchUrlRes;

public class MatchTask {

    public static void getMatchInfo(final MatchInfoReq infoReq, final MyCallBack<MatchInfoRes> callback) {

        NetworkService.getInstance()
                .getApiService()
                .getMatchInfo(infoReq)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(matchInfoRes -> {
                    callback.onSuccess(matchInfoRes);
                }, throwable -> {
                    callback.onError(throwable.getMessage());
                });
    }

    public static void getMatchUrl(final MatchUrlReq urlReq, final MyCallBack<ArrayList<MatchUrlRes>> callBack) {
        NetworkService.getInstance()
                .getApiService()
                .getMatchUrlList(urlReq)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(matchUrlRes -> {
                    callBack.onSuccess(matchUrlRes);
                }, throwable -> {
                    callBack.onError(throwable.getMessage());
                });
    }

}
