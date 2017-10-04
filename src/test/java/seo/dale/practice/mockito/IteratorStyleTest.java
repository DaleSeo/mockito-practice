package seo.dale.practice.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IteratorStyleTest {

    @Mock
    private Counter counter;

    @Test
    public void test() {
        when(counter.next())
                .thenReturn(1)
                .thenReturn(2)
                .thenReturn(3)
                .thenThrow(new RuntimeException("Can't count any more"));

        assertThat(counter.next()).isEqualTo(1);
        assertThat(counter.next()).isEqualTo(2);
        assertThat(counter.next()).isEqualTo(3);

        try {
            counter.next();
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Can't count any more");
        }

    }

    @Test
    public void test2() {
        doReturn(1)
            .doReturn(2)
            .doReturn(3)
            .when(counter)
            .next();

        assertThat(counter.next()).isEqualTo(1);
        assertThat(counter.next()).isEqualTo(2);
        assertThat(counter.next()).isEqualTo(3);
        assertThat(counter.next()).isEqualTo(3); // last stub
    }

    interface Counter {
        int next();
    }

}
