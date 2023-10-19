package com.graphql;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlExampleApplication.class, args);
	}

	/*@Bean
	public GraphQLScalarType json() {
		return ExtendedScalars.Json;
	}*/
}
