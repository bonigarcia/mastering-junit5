
package io.github.bonigarcia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class WebController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "/", method = GET)
    public String greeting() {
        return pageService.getPage();
    }

}
