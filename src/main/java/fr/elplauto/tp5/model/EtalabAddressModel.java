package fr.elplauto.tp5.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class EtalabAddressModel {

	ArrayList<Object> features = new ArrayList<Object>();

	private ArrayList<Double> getCoordinates() {
		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> firstResult = (LinkedHashMap<String, Object>) features.get(0);		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> geometry = (LinkedHashMap<String, Object>) firstResult.get("geometry");
		@SuppressWarnings("unchecked")
		ArrayList<Double> coordinates = (ArrayList<Double>) geometry.get("coordinates");
		return coordinates;
	}

	public ArrayList<Object> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<Object> features) {
		this.features = features;
	}
	
	public Double getLon() {
		return getCoordinates().get(0);
	}

	public Double getLat() {
		return getCoordinates().get(1);
	}
	
	public String getAddress() {
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> firstResult = (LinkedHashMap<String, Object>) this.features.get(0);		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) firstResult.get("properties");
		String label = (String) properties.get("label");
		return label;
	}

}