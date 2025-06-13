# 💱 Java Currency Converter

This is a **console-based Currency Converter** application developed in **Java** as part of my internship at **CodeSoft**. The program fetches real-time exchange rates using an API and allows users to convert an amount from one currency to another.

## 🚀 Features

- Real-time currency conversion using an exchange rate API
- User selection of base and target currencies
- Input any amount and receive an accurate conversion result
- Clean and interactive console UI
- Error handling for invalid input and API issues

## 🛠️ Technologies Used

- **Java** (Core Java for logic and networking)
- **HTTP API Integration**
- **JSON Parsing** using `org.json` library

## 🧾 How It Works

1. The user enters:
   - Base currency code (e.g., `USD`)
   - Target currency code (e.g., `INR`)
   - Amount to be converted
2. The program calls the exchange rate API.
3. It calculates the equivalent amount.
4. The result is displayed to the user.

## 📦 Requirements

- Java 8 or higher
- `json-20230227.jar` (for JSON parsing)  
  Download: [https://repo1.maven.org/maven2/org/json/json/20230227/json-20230227.jar](https://repo1.maven.org/maven2/org/json/json/20230227/json-20230227.jar)

## 📂 Project Structure

CurrencyConverterJava/
│
├── CurrencyConverter.java
├── json-20230227.jar

markdown
Copy
Edit

## ▶️ How to Run

1. Open the project folder in **VS Code** or any IDE.
2. Compile the program:

   ```bash
   javac -cp .;json-20230227.jar CurrencyConverter.java
Run the program:

bash
Copy
Edit
java -cp .;json-20230227.jar CurrencyConverter
✅ Make sure the json-20230227.jar file is in the same directory or provide the correct path in classpath.

🧠 Learning Outcome
Gained practical knowledge of handling API responses

Strengthened Java fundamentals: classes, methods, I/O, exception handling

Implemented third-party JSON parsing library in Java

🙌 Acknowledgements
API used: https://api.exchangerate-api.com/

JSON library: org.json
