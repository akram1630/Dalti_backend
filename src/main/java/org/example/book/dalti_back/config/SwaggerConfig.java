package org.example.book.dalti_back.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi ClientManagementApi() {
        return GroupedOpenApi.builder()
                .group("Client Management API")
                .pathsToMatch("/client/**") //show only endpoint who start with
                .addOperationCustomizer(appTokenHeaderParam())
                .build();
    }

    @Bean
    public GroupedOpenApi setupApi_AllControllers() {
        String packagesToscan[] = { "org.example.book.dalti_back" }; //scan controllers all
        return GroupedOpenApi.builder()
                .group("ALL APIs")
                .packagesToScan(packagesToscan)
                .addOperationCustomizer(appTokenHeaderParam())
                .build();
    }

    @Bean
    public OperationCustomizer appTokenHeaderParam() {
        return (Operation operation, HandlerMethod handlerMethod) -> {
            Parameter headerParameter = new Parameter().in(ParameterIn.HEADER.toString()).required(false).
                    schema(new StringSchema()._default("app_token_header_default_value")).name("app_token_header").description("App Token Header");
            operation.addParametersItem(headerParameter);
            return operation;
        };
    }

}
