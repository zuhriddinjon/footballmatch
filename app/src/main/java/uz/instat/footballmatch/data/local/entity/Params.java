package uz.instat.footballmatch.data.local.entity;

import androidx.room.ColumnInfo;

public class Params {
    public Params(Integer pSport, Integer pMatchId) {
        this.pSport = pSport;
        this.pMatchId = pMatchId;
    }

    @ColumnInfo(name = "p_sport")
    private Integer pSport;
    @ColumnInfo(name = "p_match_id")
    private Integer pMatchId;

    public Integer getPSport() {
        return pSport;
    }

    public Integer getPMatchId() {
        return pMatchId;
    }
}
