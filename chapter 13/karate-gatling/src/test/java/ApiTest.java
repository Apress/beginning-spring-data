import com.intuit.karate.junit5.Karate;

class ApiTest {

    @Karate.Test
    Karate runAllTests() {
        return Karate.run().tags("~@ignore").relativeTo(getClass());
    }
}
