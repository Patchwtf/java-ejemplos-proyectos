package com.platzi.jobsearch.api;

import com.platzi.jobsearch.JobPosition;
import feign.HeaderMap;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface APIJobs {
    @RequestLine("GET /search")
    List<JobPosition> jobs (@QueryMap Map<String, Object> queryMap);
}
