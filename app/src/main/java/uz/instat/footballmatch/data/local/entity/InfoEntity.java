package uz.instat.footballmatch.data.local.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "match_info")
public class InfoEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id = 0L;
}
