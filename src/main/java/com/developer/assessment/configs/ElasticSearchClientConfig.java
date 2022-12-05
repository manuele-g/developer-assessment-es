package com.developer.assessment.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * The Class ElasticSearchClientConfig.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.developer.assessment.elasticsearch.repository")
@ComponentScan(basePackages = { "com.developer.assessment.elasticsearch.services" })
public class ElasticSearchClientConfig extends ElasticsearchConfiguration {

	/** The uri. */
	@Value("${spring.elasticsearch.uris}")
	private String uri;

	/**
	 * Client configuration.
	 *
	 * @return the client configuration
	 */
	@Override
	public ClientConfiguration clientConfiguration() {
		return ClientConfiguration.builder().connectedTo(uri).withConnectTimeout(30000).withSocketTimeout(30000)
				.build();
	}
}
