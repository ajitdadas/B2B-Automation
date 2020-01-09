package com.cisco.b2b.auotomation.common.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.ngc.constants.NGCConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenerateAccessToken {

	static Logger logger = LogManager.getLogger(GenerateAccessToken.class);

	private GenerateAccessToken() {
		// Private Constructor
	}

	public static String getAccessToken() throws IOException {

		String accessToken = null;
		HttpResponse response = null;
		final CloseableHttpClient client = HttpClients.createDefault();
		final HttpPost post = new HttpPost(NGCConstants.NGC_TOKENURL);
		try {
			response = client.execute(post);
			if (null != response) {
				final InputStream content = response.getEntity().getContent();
				final ObjectMapper mapper = new ObjectMapper();
				final JsonNode readTree = mapper.readTree(content);
				accessToken = readTree.get(CommonConstants.ACCESS_TOKEN).asText();
			} else {
				logger.error("Generate Access Token webservice response is null");
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		} finally {
			client.close();
		}
		return accessToken;
	}
}
