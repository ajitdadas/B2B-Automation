package com.cisco.b2b.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cisco.b2b.model.B2BResponse;
import com.cisco.b2b.model.ConfigResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, NoSuchFieldException, SecurityException {
		B2BResponse b2bResponse = getB2BResponse();
		ConfigResponse configResponse = getConfigResponse();
		Map<String, Object> mapDiff = new HashMap<>();
		List<CompareResult> compareResults = null;
		String serviceName = "CiscoOne";
		switch (serviceName) {
		case "ConfigRecommendation":
			compareResults = ConfigRecommendationResponseComparator.comapreResponse(configResponse, b2bResponse);
			break;
		case "CiscoOne":
			compareResults = CiscoOneResponseComparator.compareResponse(configResponse, b2bResponse);
			break;
		}
		if (!compareResults.isEmpty()) {
			System.out.println("Found Difference");
			for (CompareResult compareResult : compareResults) {
				mapDiff.put("Different Response Details", compareResults);
			}
		}
		System.out.println(mapDiff);

	}

	private static B2BResponse getB2BResponse() throws JsonParseException, JsonMappingException, IOException {
		B2BResponse b2BResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		b2BResponse = mapper.readValue(getFileFromResources("CiscoOne_B2B.json"), B2BResponse.class);
		return b2BResponse;
	}

	private static ConfigResponse getConfigResponse() throws JsonParseException, JsonMappingException, IOException {
		ConfigResponse configResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		configResponse = mapper.readValue(getFileFromResources("CiscoOne_Config.json"), ConfigResponse.class);
		return configResponse;
	}

	private static File getFileFromResources(String fileName) {
		ClassLoader classLoader = App.class.getClassLoader();
		URL resource = classLoader.getResource("assets/" + fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}

}