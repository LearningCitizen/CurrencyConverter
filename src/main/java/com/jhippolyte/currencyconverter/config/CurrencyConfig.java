package com.jhippolyte.currencyconverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class CurrencyConfig {

    @Bean
    public Docket currencyApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jhippolyte.currencyconverter"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(currencyApiInfo())
                .tags(new Tag("Currency converter service","The Currency converter API provides useful webservices about currency conversion"));
    }

    private ApiInfo currencyApiInfo (){
        return new ApiInfoBuilder().title("Currency converter API")
                .description("Currency converter service\",\"The Currency converter API provides useful webservices about currency conversion")
                .contact(new Contact("John-son HIPPOLYTE", "https://jhippolyte.com/", "contact@jhippolyte.com"))
                .license("GNU General Public License")
                .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.en.html")
                .version("3.0")
                .build();
    }

}
