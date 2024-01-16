package junitmockito;

import lombok.val;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.mockito.IAuthenticator;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubExampleTest {

    // Stubbing method calls
    @Test
    public void stubMethodCalls() {
        val mockSet = mock(Set.class); // create a mock of Set class by calling mock() method
        //Now use the when() and thenReturn() method to define the behavior of size() method
        when(mockSet.size()).thenReturn(10);
        Assertions.assertEquals(10, mockSet.size());//To check that the stubbing is done correctly, call size()
    }


}
