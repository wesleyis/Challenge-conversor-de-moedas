# 💱 Currency Converter

Um conversor de moedas desenvolvido em Java usando GSON para consumir a ExchangeRate-API e realizar conversões em tempo real.

![Java](https://img.shields.io/badge/Java-11+-orange)
![GSON](https://img.shields.io/badge/GSON-2.10.1-blue)
![Maven](https://img.shields.io/badge/Maven-3.6+-red)
![License](https://img.shields.io/badge/License-MIT-green)

## 🚀 Funcionalidades

- ✅ Conversão de 168+ moedas internacionais
- ✅ Taxas de câmbio atualizadas em tempo real
- ✅ Interface de linha de comando intuitiva
- ✅ Validação robusta de entrada do usuário
- ✅ Tratamento de erros e exceções
- ✅ Exibição formatada dos resultados

## 🛠️ Tecnologias Utilizadas

- **Java 11+**
- **GSON 2.10.1** - Serialização/deserialização JSON
- **HttpClient** - Requisições HTTP
- **ExchangeRate-API** - Fonte de dados das moedas
- **Maven** - Gerenciamento de dependências

## 📋 Pré-requisitos

- Java JDK 11 ou superior
- Maven 3.6+
- Conexão com internet para consultar as APIs

## 🔧 Instalação e Execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/currency-converter.git
   cd currency-converter
   ```

2. **Compile o projeto:**
   ```bash
   mvn compile
   ```

3. **Execute a aplicação:**
   ```bash
   mvn exec:java -Dexec.mainClass="CurrencyConverterApp"
   ```

## 📖 Como Usar

1. Execute o programa
2. Escolha a opção desejada no menu:
   - **1** - Converter moedas
   - **2** - Ver moedas suportadas
   - **3** - Sair

3. Para conversão:
   - Digite a moeda de origem (ex: USD, EUR, BRL)
   - Digite a moeda de destino
   - Informe o valor a ser convertido
   - Veja o resultado formatado!

## 💡 Exemplo de Uso

```
=== CONVERSOR DE MOEDAS ===
Bem-vindo ao conversor de moedas!

--- MENU ---
1. Converter moedas
2. Ver moedas suportadas
3. Sair
Escolha uma opção: 1

--- CONVERSÃO DE MOEDAS ---
Digite a moeda de origem (ex: USD, EUR, BRL): USD
Digite a moeda de destino (ex: USD, EUR, BRL): BRL
Digite o valor a ser convertido: 100

=== RESULTADO DA CONVERSÃO ===
Valor original: 100.00 USD
Taxa de câmbio: 1 USD = 5.234567 BRL
Valor convertido: 523.46 BRL
================================
```

## 🏗️ Estrutura do Projeto

```
currency-converter/
├── src/main/java/
│   ├── ExchangeRateResponse.java    # Modelo para resposta da API
│   ├── CurrencyService.java         # Serviço de consumo da API
│   └── CurrencyConverterApp.java    # Aplicação principal
├── pom.xml                          # Configuração Maven
├── README.md                        # Documentação
└── .gitignore                       # Arquivos ignorados pelo Git
```

## 💰 Moedas Suportadas

O conversor suporta mais de 168 moedas, incluindo:

- **USD** - Dólar Americano
- **EUR** - Euro
- **BRL** - Real Brasileiro
- **GBP** - Libra Esterlina
- **JPY** - Iene Japonês
- **CAD** - Dólar Canadense
- **AUD** - Dólar Australiano
- **CHF** - Franco Suíço
- **CNY** - Yuan Chinês
- **INR** - Rupia Indiana

E muitas outras!

## 🔄 API Utilizada

Este projeto utiliza a [ExchangeRate-API](https://exchangerate-api.com/) que oferece:
- 1.500 requisições gratuitas por mês
- Taxas atualizadas diariamente
- Suporte a 168+ moedas
- Alta disponibilidade e confiabilidade

## 🚀 Melhorias Futuras

- [ ] Interface gráfica (JavaFX/Swing)
- [ ] Cache local das taxas de câmbio
- [ ] Histórico de conversões
- [ ] Gráficos de variação das moedas
- [ ] Suporte offline com taxas salvas
- [ ] Configuração externa via properties

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📧 Contato

Seu Nome - [@seu_twitter](https://twitter.com/seu_twitter) - email@exemplo.com

Link do Projeto: [https://github.com/seu-usuario/currency-converter](https://github.com/seu-usuario/currency-converter)

---

⭐ Se este projeto te ajudou, considere dar uma estrela no repositório!