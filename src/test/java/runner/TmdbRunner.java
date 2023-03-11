package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty",
        },
       features = "src/test/resources/tmdb.feature",
       glue = "tmdbAPI",
        tags = "@tmdbApi",
        dryRun = false


)

public class TmdbRunner {




}
