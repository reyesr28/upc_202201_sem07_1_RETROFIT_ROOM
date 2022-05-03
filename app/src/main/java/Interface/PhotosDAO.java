package Interface;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Beans.Photos;

@Dao
public interface PhotosDAO {

    @Insert
    public void insert(Photos p);

    @Query("SELECT * FROM Photos")
    List<Photos> listarPhotos();

}
