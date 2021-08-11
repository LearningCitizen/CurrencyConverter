# Currency Converter

Currency Converter is a project that allows you to get infos on currencies and do conversion.  
The backend is made with Java/Spring boot.  

## Installation and Running

You can clone the project on [github](https://github.com/LearningCitizen/CurrencyConverter) to get the sources.

```bash
git clone https://github.com/LearningCitizen/CurrencyConverter
cd currency-converter
mvn clean install
java -jar /target/currency-converter.jar
```

## APIs

### Currency Converter Backend
- getAllCurrencies : http://localhost:8080/api/v1/currencies
- getCurrencyByTrigram : http://localhost:8080/api/v1/currencies/currency
- convertCurrency : http://localhost:8080/api/v1/currencies/conversion

### Swagger
- swagger ui : http://localhost:8080/swagger-ui/index.html
- swagger api-docs : http://localhost:8080/v2/api-docs

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)