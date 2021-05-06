package uz.instat.footballmatch.data.remote.model.res;

import com.google.gson.annotations.SerializedName;

public class Tournament {

    @SerializedName("id")
    private Long id;
    @SerializedName("name_eng")
    private String nameEng;
    @SerializedName("name_rus")
    private String nameRus;

    public Long getId() {
        return id;
    }

    public String getNameEng() {
        return nameEng;
    }

    public String getNameRus() {
        return nameRus;
    }

}