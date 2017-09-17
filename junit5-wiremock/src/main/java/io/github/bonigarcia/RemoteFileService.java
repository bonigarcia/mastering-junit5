/*
 * (C) Copyright 2017 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteFileService {

    private RemoteFileApi remoteFileApi;
    private String baseUrl;

    public void initService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(this.getBaseUrl()).build();
        remoteFileApi = retrofit.create(RemoteFileApi.class);
    }

    public byte[] getFile(String file) throws IOException {
        Call<ResponseBody> openFile = remoteFileApi.openFile(file);
        Response<ResponseBody> execute = openFile.execute();
        String streamId = execute.body().string();
        System.out.println("Stream " + streamId + " open");

        Call<ResponseBody> readStream = remoteFileApi.readStream(streamId);
        byte[] content = readStream.execute().body().bytes();
        System.out.println("Received " + content.length + " bytes");

        remoteFileApi.closeStream(streamId).execute();
        System.out.println("Stream " + streamId + " closed");

        return content;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}