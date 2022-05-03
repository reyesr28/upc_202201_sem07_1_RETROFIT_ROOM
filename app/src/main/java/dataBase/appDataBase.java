package dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import Beans.Photos;
import Interface.PhotosDAO;

@Database(entities = {Photos.class},version=1)
public abstract  class appDataBase extends RoomDatabase {

    public static appDataBase INSTANCE;

    public abstract PhotosDAO photosDAO();

    public static appDataBase getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context,appDataBase.class,"bdPhotos")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

}
