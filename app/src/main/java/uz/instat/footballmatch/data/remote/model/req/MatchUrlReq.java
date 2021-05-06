package uz.instat.footballmatch.data.remote.model.req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchUrlReq {

    @SerializedName("match_id")
    @Expose
    private Long matchId;
    @SerializedName("sport_id")
    @Expose
    private Long sportId;

    public MatchUrlReq(Long matchId, Long sportId) {
        this.matchId = matchId;
        this.sportId = sportId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

}
