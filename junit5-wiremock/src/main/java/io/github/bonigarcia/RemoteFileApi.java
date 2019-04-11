
package io.github.bonigarcia;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RemoteFileApi {

    @POST("/api/v1/paths/{file}/open-file")
    Call<ResponseBody> openFile(@Path("file") String file);

    @POST("/api/v1/streams/{streamId}/read")
    Call<ResponseBody> readStream(@Path("streamId") String streamId);

    @POST("/api/v1/streams/{streamId}/close")
    Call<ResponseBody> closeStream(@Path("streamId") String streamId);

}
