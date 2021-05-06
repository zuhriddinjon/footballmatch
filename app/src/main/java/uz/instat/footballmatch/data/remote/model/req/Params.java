package uz.instat.footballmatch.data.remote.model.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {

    public Params(Long pSport, Long pMatchId) {
        this.pSport = pSport;
        this.pMatchId = pMatchId;
    }

    @SerializedName("_p_sport")
    @Expose
    private Long pSport;
    @SerializedName("_p_match_id")
    @Expose
    private Long pMatchId;

    public Long getPSport() {
        return pSport;
    }

    public Long getPMatchId() {
        return pMatchId;
    }
}
