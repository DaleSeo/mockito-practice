package seo.dale.practice.mockito;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void test() {
        List mockList = mock(List.class);

        when(mockList.get(anyInt())).thenReturn("int");
        when(mockList.add(anyFloat())).thenReturn(true);
        when(mockList.add(anyString())).thenReturn(true);

        assertThat(mockList.get(999)).isEqualTo("int");
        assertThat(mockList.add(3.3)).isTrue();
//        assertThat(mockList.add("string")).isTrue();

        verify(mockList).get(anyInt());
        verify(mockList).add(anyFloat());
//        verify(mockList).add(eq("string"));
    }

}
