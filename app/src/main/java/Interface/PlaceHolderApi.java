package Interface;

import Beans.Photos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlaceHolderApi {

    @GET("photos/{id}")
    Call<Photos> getPhoto(@Path("id") int id);

}
