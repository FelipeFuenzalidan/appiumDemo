package utils;

import gherkin.formatter.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CucumberFormatter implements gherkin.formatter.Formatter
{
    public static final Logger LOGGER = LoggerFactory.getLogger(CucumberFormatter.class);
    public static Feature feature;
    public static final HttpRequestUtil request = new HttpRequestUtil();
    public static final CucumberResults resultados = CucumberResults.getInstance();

    @Override
    public void syntaxError(String s, String s1, List<String> list, String s2, Integer integer) {
    }

    @Override
    public void uri(String s) {
    }

    @Override
    public void feature(Feature feature) {
        resultados.addFeature(feature);
    }

    @Override
    public void scenarioOutline(ScenarioOutline scenarioOutline) {
    }

    @Override
    public void examples(Examples examples) {
    }

    @Override
    public void startOfScenarioLifeCycle(Scenario scenario) {
    }

    @Override
    public void background(Background background) {
    }

    @Override
    public void scenario(Scenario scenario) {
        resultados.addScenario(scenario);
    }

    @Override
    public void step(Step step) {
    }

    @Override
    public void endOfScenarioLifeCycle(Scenario scenario) {
        LOGGER.info("Se están terminando de correr los casos de prueba de este escenario.");
    }

    @Override
    public void done() {

    }

    @Override
    public void close() {

    }

    @Override
    public void eof() {

    }
}