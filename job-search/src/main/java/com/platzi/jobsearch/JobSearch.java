package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunctions.parseArguments;
import static com.platzi.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);
        Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(CLIArguments.class::cast);

        Optional<CLIArguments> cliArgumentsOptional = streamOfCLI
                .filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs apiJobs = buildAPI(APIJobs.class, "https://jsearch.p.rapidapi.com");
        return Stream.of(params)
                .map(apiJobs::jobs)
                .flatMap(List::stream);
    }
}
