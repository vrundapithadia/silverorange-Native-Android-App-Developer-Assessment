
import android.app.Activity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

object ApiClient {

    var BASE_URL = "http://localhost:4000/" // live url
    private var retrofit: Retrofit? = null
    private var toastLessRetrofit: Retrofit? = null

    val getToastLessClient: ApiInterface
        get() {
            val client = OkHttpClient.Builder()
                .connectTimeout(
                    Constants.CONNECTION_TIMEOUT,
                    TimeUnit.SECONDS
                )
                .readTimeout(
                   Constants.READ_TIMEOUT,
                    TimeUnit.SECONDS
                ).build()

            if (toastLessRetrofit == null) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY

                val httpClient = OkHttpClient.Builder()
                httpClient.addInterceptor(logging)
                toastLessRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            }
            return toastLessRetrofit!!.create(ApiInterface::class.java)
        }

    fun getClient(context: Activity): ApiInterface {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.HEADERS

        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()

            .connectTimeout(
                Constants.CONNECTION_TIMEOUT,
                TimeUnit.SECONDS
            )
          //  .addInterceptor(ConnectivityInterceptor(context))
            .addInterceptor(logging)
            .readTimeout(
                Constants.READ_TIMEOUT,
                TimeUnit.SECONDS
            ).build()

        if (retrofit == null) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.HEADERS

            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging) // <-- this is the important line!
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        return retrofit!!.create(ApiInterface::class.java)
    }
}
