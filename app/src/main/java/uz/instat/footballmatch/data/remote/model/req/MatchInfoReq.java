package uz.instat.footballmatch.data.remote.model.req;

import com.google.gson.annotations.SerializedName;

public class MatchInfoReq {

    public MatchInfoReq(String proc, Params params) {
        this.proc = proc;
        this.params = params;
    }

    @SerializedName("proc")
    private String proc;
    @SerializedName("params")
    private Params params;

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
