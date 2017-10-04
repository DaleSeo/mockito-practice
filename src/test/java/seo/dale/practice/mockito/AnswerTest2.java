package seo.dale.practice.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnswerTest2 {

    @Mock
    private Calculator calculator;

    @Test
    public void testThenAnswer() {
        when(calculator.plus(anyInt(), anyInt()))
                .thenAnswer(invocation -> {
                    int x = invocation.getArgumentAt(0, Integer.class);
                    int y = invocation.getArgumentAt(1, Integer.class);
                    return x + y;
                });
        assertThat(calculator.plus(1, 2)).isEqualTo(3);
        assertThat(calculator.plus(3, 5)).isEqualTo(8);
    }

    @Test
    public void testDoAnswer() {
        doAnswer(invocation -> {
            int x = invocation.getArgumentAt(0, Integer.class);
            int y = invocation.getArgumentAt(1, Integer.class);
            return x + y;
        })
                .when(calculator)
                .plus(anyInt(), anyInt());

        assertThat(calculator.plus(1, 2)).isEqualTo(3);
        assertThat(calculator.plus(3, 5)).isEqualTo(8);
    }

    interface Calculator {
        long plus(int x, int y);
    }

}
