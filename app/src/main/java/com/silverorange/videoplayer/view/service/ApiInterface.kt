
import com.silverorange.videoplayer.model.WireframeResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("videos")
    fun getVideoResponse( ): Call<WireframeResponseModel>



}