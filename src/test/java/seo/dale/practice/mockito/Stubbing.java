package seo.dale.practice.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Stubbing {

    @Mock
    private User user;

    @Test
    public void mustStubMethods() {
        doReturn("111").when(user).getId();
        assertThat(user.getId()).isEqualTo("111");

        when(user.getId()).thenReturn("222");
        assertThat(user.getId()).isEqualTo("222");
    }

    @Test
    public void mustStubMethodsReturningNothing() {
        doThrow(new RuntimeException("Failed to set the ID.")).when(user).setId(anyString());
        try {
            user.setId("111");
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Failed to set the ID.");
        }
    }

    interface User {

        void setId(String id);
        String getId();

    }

}
