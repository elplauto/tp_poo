package fr.elplauto.tp5.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import fr.elplauto.tp5.model.EtalabAddressModel;
import fr.elplauto.tp5.model.OWMAnswerModel;

@Controller
public class MeteoController {

	@PostMapping("/meteo")
	public String getAddress(@RequestParam(name = "address") String address, Model model) {
		model.addAttribute("activePage", "address");

		if(address == null || address == "" ) {
			model.addAttribute("error", "Empty address");
			return "address";
		}		
		
		// Get coordinates from the address input with Etalab api
		String urlEtalab = "https://api-adresse.data.gouv.fr/search/?q=" + address;
		RestTemplate restTemplate = new RestTemplateBuilder().build();
		EtalabAddressModel answerEtalab = restTemplate.getForObject(urlEtalab, EtalabAddressModel.class);

		if (answerEtalab.getFeatures().size() > 0) { // i.e. Address found

			Double lon = answerEtalab.getLon();
			Double lat = answerEtalab.getLat();
			String label = answerEtalab.getAddress();

			// Get weather from coordinates
			String apiKey = "4481b81fee1f065ae887164031de533b";
			String urlOWM = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid="
					+ apiKey + "&units=metric";
			OWMAnswerModel answerOWM = restTemplate.getForObject(urlOWM, OWMAnswerModel.class);
			String actualTemp = answerOWM.getActualTemp();
			
			String forecast = answerOWM.getForecast();

			model.addAttribute("actualTemp", actualTemp);
			model.addAttribute("address", label);
			model.addAttribute("forecast", forecast);
		} else {
			model.addAttribute("error", "Address not found");
		}

		return "address";
	}
}
