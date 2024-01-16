package junitmockito;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit5FeaturesLifecycleAnnotationsTest {

    static int counter = 0;
    @BeforeAll
    static void onceBeforeAllTests() {
        // Only once for usage by all test cases inside a class
        counter = 0;
        System.out.println("Once In @BeforeAll");
        // Setting up database connection pool
        /*databaseConnection = new DatabaseConnection();
        // Initialize WebClient once before any test method is executed
        webClient = WebClient.create();
        restTemplate = new RestTemplate();
        // Code to initialize an expensive resource (e.g., connection pool)
        resourceManager = new ResourceManager();*/
    }

    @AfterAll
    static void onceAfterAllTests() { System.out.println("Once In @AfterAll");
        // Code to clean up the database after all tests
        /*DatabaseManager.clearData();
        DatabaseManager.closeConnection();
        // Code to shut down the thread pool
        threadPool.shutdown();*/
    }

    @BeforeEach
    void beforeEachAndEveryTest() {
        counter += 1;
        System.out.println("Before Test" + counter);
        // Initialize or reset state before each test
        //statefulObject = new StatefulObject();
    }

    @AfterEach
    void afterEachAndEveryTestTearDown() {
        System.out.println("After Test" + counter);
        /*// Cleanup: Reset the database state after each test
        databaseService.resetDatabaseState();
        // Cleanup: Close file handles or delete the temporary file after each test
        testFile.delete();*/
    }

    @Test
    public void testOne() { System.out.println("Test1"); }

    @Test
    public void testTwo() { System.out.println("Test2"); }


}
