
package io.github.bonigarcia;

import org.springframework.stereotype.Service;

@Service
public class PageService {

    public String getPage() {
        return "/index.html";
    }
}
