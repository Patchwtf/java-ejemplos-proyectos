package com.platzi.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {
    public static Map<String, Object> toMap (CLIArguments cliArguments){
        Map<String, Object> params = new HashMap<>();
        params.put("query", cliArguments.getKeyword());
        params.put("page", cliArguments.getPage());
        params.put("country", cliArguments.getCountry());

        return params;
    }
}