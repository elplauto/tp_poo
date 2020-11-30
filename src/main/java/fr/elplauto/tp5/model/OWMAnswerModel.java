package fr.elplauto.tp5.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class OWMAnswerModel {

	private ArrayList<Object> weather = new ArrayList<Object>();
	

	private LinkedHashMap<String, Object> main = new LinkedHashMap<String, Object>();

	public LinkedHashMap<String, Object> getMain() {
		return main;
	}

	public void setMain(LinkedHashMap<String, Object> main) {
		this.main = main;
	}
	
	public ArrayList<Object> getWeather() {
		return weather;
	}

	public void setWeather(ArrayList<Object> weather) {
		this.weather = weather;
	}

	public String getActualTemp() {
		return main.get("temp").toString();
	}
	
	public String getForecast() {
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) weather.get(0);
		String description = (String) map.get("description");
		return description;
	}
 
}
