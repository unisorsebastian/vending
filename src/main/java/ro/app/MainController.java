package ro.app;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/giveChange/{amount}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public String giveChange(@PathVariable(value = "amount") String amount) {
        return "amount provided: "+amount;
    }


}
