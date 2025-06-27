package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    CLIArguments() {}

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            description = "Keyword to search a job, for example 'developer' or 'digital desing in Mexico'",
            validateWith = CLIKeywordValidator.class
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "The location search is in format 2 letters, example Mexico - 'MX'"
    )
    private String country;

    @Parameter(
            names = {"--page", "-p"},
            description = "The API response with 20 result per page. Use the page option to select a page"
    )
    private int page = 1;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Show help"
    )
    private boolean isHelp;

    public String getKeyword() {
        return keyword;
    }

    public String getCountry() {
        return country;
    }

    public int getPage() {
        return page;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", country='" + country + '\'' +
                ", page=" + page +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
