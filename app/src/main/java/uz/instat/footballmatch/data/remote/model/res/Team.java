package uz.instat.footballmatch.data.remote.model.res;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("id")
    private Long id;
    @SerializedName("name_eng")
    private String nameEng;
    @SerializedName("name_rus")
    private String nameRus;
    @SerializedName("score")
    private Long score;

    public Long getId() {
        return id;
    }

    public String getNameEng() {
        return nameEng;
    }

    public String getNameRus() {
        return nameRus;
    }

    public Long getScore() {
        return score;
    }

}
