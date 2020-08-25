package serviceName.operationName;

import com.intuit.karate.junit5.Karate;

//this will run all *.feature files that exist in sub-directories
class operationNameRunner {
    
    @Karate.Test
    Karate testFeature() {
        return Karate.run("operationName/operationName_v1_0.feature").relativeTo(getClass());
    }    

}
