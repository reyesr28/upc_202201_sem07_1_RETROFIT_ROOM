package Beans;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Photos")
public class Photos {

    @PrimaryKey()
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name="albumId")
    @NonNull
    private int albumId;

    @ColumnInfo(name="title")
    @NonNull
    private String title;

    @ColumnInfo(name="url")
    @NonNull
    private String url;

    @ColumnInfo(name="thumbnailUrl")
    @NonNull
    private String thumbnailUrl;

    public Photos(int id, int albumId, @NonNull String title,
                  @NonNull String url, @NonNull String thumbnailUrl) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    public void setUrl(@NonNull String url) {
        this.url = url;
    }

    @NonNull
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(@NonNull String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
