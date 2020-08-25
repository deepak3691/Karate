import com.intuit.karate.KarateOptions;
import com.intuit.karate.Runner;
import com.intuit.karate.Results;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

// Place '@parallel=false' tag above Feature(s) or Scenario(s) to NOT run in parallel. Those will be executed sequentially.
// Use @KarateOptions to select/skip Feature(s)/Scenario(s) for/from execution. Prefix the Tag with '~', to skip that scenario.
// Eg. If '@tagName' is tagged to scenario(s), then use '~@tagName' in KarateOptions to skip it.

@KarateOptions(features = {},tags = {"~@scenario1"})
class TestParallel {

  /*  @BeforeAll
    public static void start() {

        String screen_folder=System.getProperty("user.dir")
                +File.separator + "target\\cucumber-html-reports";


        File file=new File(screen_folder);
        try{
            FileUtils.cleanDirectory(file);

        }
b        catch(Exception e){
            e.printStackTrace();
        }

    }

    @AfterAll
    public static void end() throws IOException {

        Path sourceDirectory = Paths.get("D:\\Eclipse_WS\\API_Testing_Karate-master\\API_Testing_Karate-master\\target\\cucumber-html-reports");
        Path targetDirectory = Paths.get("D:\\Eclipse_WS\\API_Testing_Karate-master\\API_Testing_Karate-master\\Reports");


        //copy source to target using Files Class
        Files.copy(sourceDirectory, targetDirectory);

    }
*/
    @Test
    void testParallel() {
        Results results = Runner.parallel(getClass(),5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
        generateReport(results.getReportDir());
    }

    // Cucumber report configurations
    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "Demo_ABSA");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }




}