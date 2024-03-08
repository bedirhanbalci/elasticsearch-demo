package org.example.elasticsearchdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.example.elasticsearchdemo.repository")
@ComponentScan(basePackages = "org.example.elasticsearchdemo")
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.url}")
    private String url;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(url)
                .build();
    }
}
