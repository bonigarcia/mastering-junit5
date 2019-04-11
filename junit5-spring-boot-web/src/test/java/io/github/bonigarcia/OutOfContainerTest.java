
package io.github.bonigarcia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OutOfContainerTest {

    @InjectMocks
    private WebController webController;

    @Mock
    private PageService pageService;

    @Test
    void test() {
        when(pageService.getPage()).thenReturn("/my-page.html");
        assertEquals("/my-page.html", webController.greeting());
        verify(pageService, times(1)).getPage();
    }

}
