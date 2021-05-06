package uz.instat.footballmatch.data.remote.model.res;

import com.google.gson.annotations.SerializedName;

public class MatchInfoRes {

    @SerializedName("tournament")
    private Tournament tournament;
    @SerializedName("date")
    private String date;
    @SerializedName("team1")
    private Team team1;
    @SerializedName("team2")
    private Team team2;
    @SerializedName("calc")
    private Boolean calc;
    @SerializedName("has_video")
    private Boolean hasVideo;
    @SerializedName("live")
    private Boolean live;
    @SerializedName("storage")
    private Boolean storage;
    @SerializedName("sub")
    private Boolean sub;
    @SerializedName("access")
    private Boolean access;

    public Tournament getTournament() {
        return tournament;
    }

    public String getDate() {
        return date;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Boolean getCalc() {
        return calc;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public Boolean getLive() {
        return live;
    }

    public Boolean getStorage() {
        return storage;
    }

    public Boolean getSub() {
        return sub;
    }

    public Boolean getAccess() {
        return access;
    }

}