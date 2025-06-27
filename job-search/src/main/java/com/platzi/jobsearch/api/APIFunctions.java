package com.platzi.jobsearch.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.platzi.jobsearch.JobPosition;
import feign.Feign;
import feign.Util;
import feign.gson.GsonDecoder;

import java.awt.event.MouseAdapter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APIFunctions {
    public static <T> T buildAPI(Class<T> clazz, String url){
        return Feign.builder()

                .decoder((response, type) -> {
                    byte[] jsonByte = Util.toByteArray(response.body().asInputStream());
                    String json = new String(jsonByte, StandardCharsets.UTF_8);
                    if(json.trim().startsWith("{")) json = "[" + json + "]";

                    List<Map<String, Object>> mainResponse = new Gson().fromJson(json, new TypeToken<List<Map<String, Object>>>(){}.getType());

                    @SuppressWarnings("unchecked") List<Map<String, Object>> jobsData = (List<Map<String, Object>>) mainResponse.get(0).get("data");
                    return jobsData.stream()
                            .map(jobMap -> new Gson().fromJson(new Gson().toJson(jobMap), JobPosition.class))
                            .collect(Collectors.toList());
                })
                .doNotCloseAfterDecode()
                .requestInterceptor(requestTemplate -> {
                    requestTemplate.header("x-rapidapi-key", "6fad771e2dmsh8c49247d3ddcf33p1052cejsn150f58e7dc6a");
                    requestTemplate.header("x-rapidapi-host", "jsearch.p.rapidapi.com");
                })
                .target(clazz, url);
    }
}
