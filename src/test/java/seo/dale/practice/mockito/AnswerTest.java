package seo.dale.practice.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;

@RunWith(MockitoJUnitRunner.class)
public class AnswerTest {

    @Mock
    private Counter counter;

    @Test
    public void test() {
        AtomicInteger atomicInteger = new AtomicInteger();
        doAnswer(invocation -> atomicInteger.incrementAndGet())
                .when(counter)
                .next();

        IntStream
                .range(1, 10)
                .forEach(num -> assertThat(counter.next()).isEqualTo(num));
    }

    interface Counter {
        int next();
    }

}
