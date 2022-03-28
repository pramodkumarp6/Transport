package com.pramod.transport.app;

import com.pramod.transport.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;


import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;


public class HostSelectionInterceptor   {
   /* private volatile HttpUrl host = HttpUrl.parse(BuildConfig.DEVELOPMENT_BASE_URL);
    PreferenceHelper preferenceHelper;

    @Inject
    public HostSelectionInterceptor(PreferenceHelper preferenceHelper){
        this.preferenceHelper = preferenceHelper;
        setHostBaseUrl();
    }

    public void setHostBaseUrl() {
        if (preferenceHelper.isProdEnvironment()) {
            this.host = HttpUrl.parse(BuildConfig.PRODUCTION_BASE_URL);
        } else {
            this.host = HttpUrl.parse(BuildConfig.DEVELOPMENT_BASE_URL);
        }
    }

    @NotNull
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        if (host != null) {
            HttpUrl newUrl = null;
            try {
                newUrl = request.url().newBuilder()
                        .scheme(host.scheme())
                        .host(host.url().toURI().getHost())
                        .build();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            assert newUrl != null;
            request = request.newBuilder()
                    .url(newUrl)
                    .build();
        }
        return chain.proceed(request);
    }*/
}
