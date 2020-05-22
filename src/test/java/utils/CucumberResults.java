package utils;

import gherkin.formatter.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CucumberResults {

    static CucumberResults instance;
    public static final Logger LOGGER = LoggerFactory.getLogger(CucumberResults.class);
    public List<Feature> features = new ArrayList<Feature>();
    public List<Scenario> scenarios = new ArrayList<Scenario>();
    public List<Result> results = new ArrayList<Result>();

    public static CucumberResults getInstance() {
        if(instance == null){
            try {
                instance = new CucumberResults();
            }  catch (Exception e) {
                LOGGER.error("Problem with results") ;
                e.printStackTrace(System.out) ;
            }
        }
        return instance;
    }

    public void addFeature(Feature feature){
        features.add(feature);
        LOGGER.info("ID " + feature.getId());
        LOGGER.info("Description " + feature.getDescription());
        LOGGER.info("Keyword " + feature.getKeyword());
        LOGGER.info("Name " + feature.getName());
        for (Comment comment: feature.getComments()) {
            LOGGER.info("Comment " + comment.getValue());
        }
        for (Tag tag: feature.getTags()) {
            LOGGER.info("Tag " + tag.getName());
        }
    }

    public Feature getUltimoFeature(){
        return features.get(features.size() - 1);
    }

    public void addScenario(Scenario scenario){
        scenarios.add(scenario);
        LOGGER.info("ID " + scenario.getId());
        LOGGER.info("Description " + scenario.getDescription());
        LOGGER.info("Keyword " + scenario.getKeyword());
        LOGGER.info("Name " + scenario.getName());
        for (Comment comment: scenario.getComments()) {
            LOGGER.info("Comment " + comment.getValue());
        }
        for (Tag tag: scenario.getTags()) {
            LOGGER.info("Scenario Tag " + tag.getName());
        }
    }

    public Scenario getUltimoScenario(){
        return scenarios.get(scenarios.size() - 1);
    }

    public void addResult(Result result){
        results.add(result);
    }

    public Result getUltimoResult(){
        return results.get(results.size() - 1);
    }
}
