package uz.instat.footballmatch.ui.match.adapter;

import android.os.Parcel;
import android.os.Parcelable;

public class MatchModel implements Parcelable {
    private String name;
    private Long period;
    private Long startms;
    private Long duration;
    private String url240;
    private String url400;
    private String url720;
    private String url1000;
    private Long size240;
    private Long size400;
    private Long size720;
    private Long size1000;

    public MatchModel(String name, Long period, Long startms, Long duration) {
        this.name = name;
        this.period = period;
        this.startms = startms;
        this.duration = duration;
    }

    protected MatchModel(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            period = null;
        } else {
            period = in.readLong();
        }
        if (in.readByte() == 0) {
            startms = null;
        } else {
            startms = in.readLong();
        }
        if (in.readByte() == 0) {
            duration = null;
        } else {
            duration = in.readLong();
        }
        url240 = in.readString();
        url400 = in.readString();
        url720 = in.readString();
        url1000 = in.readString();
        if (in.readByte() == 0) {
            size240 = null;
        } else {
            size240 = in.readLong();
        }
        if (in.readByte() == 0) {
            size400 = null;
        } else {
            size400 = in.readLong();
        }
        if (in.readByte() == 0) {
            size720 = null;
        } else {
            size720 = in.readLong();
        }
        if (in.readByte() == 0) {
            size1000 = null;
        } else {
            size1000 = in.readLong();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        if (period == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(period);
        }
        if (startms == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(startms);
        }
        if (duration == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(duration);
        }
        dest.writeString(url240);
        dest.writeString(url400);
        dest.writeString(url720);
        dest.writeString(url1000);
        if (size240 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(size240);
        }
        if (size400 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(size400);
        }
        if (size720 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(size720);
        }
        if (size1000 == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(size1000);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MatchModel> CREATOR = new Creator<MatchModel>() {
        @Override
        public MatchModel createFromParcel(Parcel in) {
            return new MatchModel(in);
        }

        @Override
        public MatchModel[] newArray(int size) {
            return new MatchModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getStartms() {
        return startms;
    }

    public void setStartms(Long startms) {
        this.startms = startms;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getUrl240() {
        return url240;
    }

    public void setUrl240(String url240) {
        this.url240 = url240;
    }

    public String getUrl400() {
        return url400;
    }

    public void setUrl400(String url400) {
        this.url400 = url400;
    }

    public String getUrl720() {
        return url720;
    }

    public void setUrl720(String url720) {
        this.url720 = url720;
    }

    public String getUrl1000() {
        return url1000;
    }

    public void setUrl1000(String url1000) {
        this.url1000 = url1000;
    }

    public Long getSize240() {
        return size240;
    }

    public void setSize240(Long size240) {
        this.size240 = size240;
    }

    public Long getSize400() {
        return size400;
    }

    public void setSize400(Long size400) {
        this.size400 = size400;
    }

    public Long getSize720() {
        return size720;
    }

    public void setSize720(Long size720) {
        this.size720 = size720;
    }

    public Long getSize1000() {
        return size1000;
    }

    public void setSize1000(Long size1000) {
        this.size1000 = size1000;
    }
}
