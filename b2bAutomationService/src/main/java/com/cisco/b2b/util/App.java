package com.cisco.b2b.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cisco.b2b.model.B2BResponse;
import com.cisco.b2b.model.ConfigResponse;
import com.cisco.b2b.model.ConfigurationLine;
import com.cisco.b2b.model.MajorLine;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		B2BResponse response = new B2BResponse();
		ConfigResponse conResponse = new ConfigResponse();
		response = getB2BResponse();
		conResponse = getConfigResponse();
		Map<String,Object> mapDiff = new HashMap<>();
		List<CompareResult> compareResults = null;
		for (ConfigurationLine configurationLine : response.getConfigurationLine()) {
			MajorLine majorLine = null;
			for (MajorLine line : conResponse.getMajorLine()) {
				if (configurationLine.getItemName().contentEquals(line.getItemName())) {
					majorLine = line;
					break;
				}
			}
			if (majorLine != null) {
			    compareResults = RecommendationResponseComparator.compareConfigMajorLineResponse(majorLine,configurationLine);
				if (!compareResults.isEmpty()) {
					System.out.println("Found Difference");
					for (CompareResult compareResult : compareResults) {
						mapDiff.put(compareResult.getItemName(), compareResults);
					}
				}
				
			}
			
		}
	    
		System.out.println(mapDiff);
		
	}

	private static B2BResponse getB2BResponse() throws JsonParseException, JsonMappingException, IOException {
		B2BResponse b2BResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		b2BResponse = mapper.readValue(getFileFromResources("HardwareUpgrade_B2B.json"), B2BResponse.class);
			
		return b2BResponse;
	}

	private static ConfigResponse getConfigResponse() throws JsonParseException, JsonMappingException, IOException {
		ConfigResponse configResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		configResponse = mapper.readValue(getFileFromResources("HardwareUpgrade_Config.json"), ConfigResponse.class);
		return configResponse;
	}
	
	private static File getFileFromResources(String fileName) {
		ClassLoader classLoader = App.class.getClassLoader();
		URL resource = classLoader.getResource("assets/"+fileName);
		if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

}
