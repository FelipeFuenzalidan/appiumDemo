package utils;

import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CucumberReporter implements gherkin.formatter.Reporter
{
    public static final Logger LOGGER = LoggerFactory.getLogger(CucumberReporter.class);
    public static final CucumberResults resultados = CucumberResults.getInstance();

    @Override
    public void before(Match match, Result result) {

    }

    @Override
    public void result(Result result) {
        resultados.addResult(result);
    }

    @Override
    public void after(Match match, Result result) {

    }

    @Override
    public void match(Match match) {

    }

    @Override
    public void embedding(String s, byte[] bytes) {

    }

    @Override
    public void write(String s) {

    }
}