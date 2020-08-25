package serviceName;

import com.intuit.karate.junit5.Karate;

// this will run all *.feature files that exist in sub-directories
class serviceNameTest {

    @Karate.Test
    Karate testFeature() {
        return Karate.run("operationName/operationName_v1_0.feature").relativeTo(getClass());
    }

    @Karate.Test
    Karate testTags() {
        return Karate.run().tags("@scenario1").relativeTo(getClass());
    }

    @Karate.Test
    Karate testFullPath() {
        return Karate.run("classpath:serviceName/operationName").relativeTo(getClass());
    }

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

}

