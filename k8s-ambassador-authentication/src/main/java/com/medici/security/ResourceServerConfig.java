package com.medici.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * 
 * @author a73s
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String HAS_AUTH_ADMIN = "hasAuthority ('ADMIN')";
	private static final String ENVIRONMENT = "/environment/**";
	private static final String PUBLISHES = "/publishes";
	private static final String OAUTH_AUTHORIZE = "/oauth/authorize**";
	private static final String OAUTH_TOKEN = "/oauth/token";
	private static final String RESOURCE_ID = "resource_server_rest_api";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.anonymous().disable().requestMatchers().antMatchers(ENVIRONMENT).and().authorizeRequests().antMatchers(ENVIRONMENT).access(HAS_AUTH_ADMIN).and().exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());

		http.authorizeRequests().antMatchers(OAUTH_TOKEN, OAUTH_AUTHORIZE, PUBLISHES).permitAll();

	}

}