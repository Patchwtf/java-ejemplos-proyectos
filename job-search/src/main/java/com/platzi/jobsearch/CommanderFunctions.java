package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {
    public static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier){
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentSupplier.get())
                .build();

        jCommander.setProgramName(cliName);

        return jCommander;
    }

    static Optional<List<Object>> parseArguments(JCommander jCommander, String[] args, Consumer<JCommander> onError){
        try {
            jCommander.parse(args);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException parameterException){
            onError.accept(jCommander);
        }
        return Optional.empty();
    }
}
