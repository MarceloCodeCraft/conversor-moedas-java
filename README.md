# Conversor de Moedas Java

Projeto de conversor de moedas via terminal, utilizando a API [ExchangeRate-API](https://www.exchangerate-api.com).

## Moedas disponíveis
- Dólar (USD)
- Real (BRL)
- Euro (EUR)
- Libra (GBP)

## Como rodar
1. Clone o projeto
2. Execute via Maven:
```
mvn compile exec:java -Dexec.mainClass="com.conversor.Main"
```

## API Key
Use a chave `2ec13966717156a1e2907772` no arquivo `ApiClient.java`