package junitmockito;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * When to Consider Test Ordering:
 * Dependency Between Tests: When one test method relies on the setup or state created by another test method.
 * Resource Management:
 * If our tests involve resource allocation (e.g., files, connections), and we need to manage their creation
 * and cleanup in a specific order.
 * Database Operations:
 * For database tests, where certain tests may insert data that others depend on.
 * Reference Link: https://www.softwaretestinghelp.com/juni-test-execution-order/
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // with @Order(number) for each test
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class FileProcessorOrderedTestsExecutionExampleTest {

    private static final String TEST_FILE_1 = "testFile1.txt";
    private static final String TEST_FILE_2 = "testFile2.txt";

    @Test
    @Order(1)
    void createTestFiles() {
        // Test setup: Create test files
        createFile(TEST_FILE_1);
        createFile(TEST_FILE_2);
        // Additional setup logic if needed
    }

    @Test
    @Order(2)
    void processFile1() {
        // Test logic to process file 1
        // Assertions and verifications
    }

    @Test
    @Order(3)
    void processFile2() {
        // Test logic to process file 2
        // Assertions and verifications
    }

    @Test
    @Order(4)
    void cleanupTestFiles() {
        // Test cleanup: Delete test files
        deleteFile(TEST_FILE_1);
        deleteFile(TEST_FILE_2);
        // Additional cleanup logic if needed
    }

    private void createFile(String fileName) {
        // Logic to create a test file
    }

    private void deleteFile(String fileName) {
        // Logic to delete a test file
    }
}
