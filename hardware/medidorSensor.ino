#include <WiFi.h>
#include <HTTPClient.h>
#include <ArduinoJson.h>

// Tu red WiFi
const char* ssid = "Cebem_21";
const char* password = "Cebem2010";

// Endpoint del backend
const char* serverName = "https://medidorsensor-h9sy.onrender.com/saveMeasure";

// Variables simuladas para ejemplo
float temperature = 25.5;
float humidity = 60.0;
float solarRadiation = 1023.0;

// Dirección MAC
String macAddress;

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Conectando a WiFi...");
  }

  Serial.println("Conectado a WiFi");
  macAddress = WiFi.macAddress();
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    http.begin(serverName);
    http.addHeader("Content-Type", "application/json");

    // Crear JSON
    StaticJsonDocument<200> doc;
    doc["mac"] = macAddress;
    doc["temperature"] = temperature;
    doc["humidity"] = humidity;
    doc["solarRadiation"] = solarRadiation;

    String jsonString;
    serializeJson(doc, jsonString);

    int httpResponseCode = http.POST(jsonString);

    Serial.print("Código de respuesta: ");
    Serial.println(httpResponseCode);

    http.end();
  }

  delay(1000); // Esperar 1 segundo
}
