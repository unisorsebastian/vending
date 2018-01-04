package ro.app;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ro.app.model.Coin;
import ro.app.service.ChangeCoinService;

@RestController
public class MainController {
	@Autowired
	private ChangeCoinService changeCoinService;

    @RequestMapping(value = "/giveChange/{amount}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public String giveChange(@PathVariable(value = "amount") String amount) {
    	Collection<Coin> changeFor = changeCoinService.getChangeFor(Integer.valueOf(amount));
    	    	
        return "change stash: "+changeFor;
    }

    
    @RequestMapping(value = "/giveChangeGroupByCoin/{amount}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public String giveChangeGroupByCoin(@PathVariable(value = "amount") String amount) {
    	List<Coin> changeFor = (List<Coin>)changeCoinService.getChangeFor(Integer.valueOf(amount));
    	Map<Coin, Integer> groupCoins = changeCoinService.groupCoins(changeFor);
        return "change stash:\n"+groupCoins;
    }

}
