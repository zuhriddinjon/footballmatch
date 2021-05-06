package uz.instat.footballmatch.data.remote.model.res;

import com.google.gson.annotations.SerializedName;

public class MatchUrlRes {

    @SerializedName("name")
    private String name;
    @SerializedName("match_id")
    private Long matchId;
    @SerializedName("period")
    private Long period;
    @SerializedName("server_id")
    private Long serverId;
    @SerializedName("quality")
    private String quality;
    @SerializedName("folder")
    private String folder;
    @SerializedName("video_type")
    private String videoType;
    @SerializedName("abc")
    private String abc;
    @SerializedName("start_ms")
    private Long startMs;
    @SerializedName("checksum")
    private Long checksum;
    @SerializedName("size")
    private Long size;
    @SerializedName("abc_type")
    private String abcType;
    @SerializedName("duration")
    private Long duration;
    @SerializedName("fps")
    private Long fps;
    @SerializedName("url_root")
    private String urlRoot;
    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public Long getStartMs() {
        return startMs;
    }

    public void setStartMs(Long startMs) {
        this.startMs = startMs;
    }

    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getAbcType() {
        return abcType;
    }

    public void setAbcType(String abcType) {
        this.abcType = abcType;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getFps() {
        return fps;
    }

    public void setFps(Long fps) {
        this.fps = fps;
    }

    public String getUrlRoot() {
        return urlRoot;
    }

    public void setUrlRoot(String urlRoot) {
        this.urlRoot = urlRoot;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}