package org.util;

/**
 * Created by 王哲 on 2017/4/13.
 */

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class okHttpUtil {
    private static final OkHttpClient client=new OkHttpClient();
    public String get(String url) throws IOException{
        Request request=new Request.Builder().url(url).build();
        Response response=client.newCall(request).execute();
        String result;
        if(response.isSuccessful()){
            System.out.println("success");
            result=response.body().string();
            return result;
        }
        else
        {
            throw new IOException("Unexpected code"+response);
        }
    }
}
