# 💬 Talk With Gemini — Java Swing Desktop Client

A lightweight desktop chat application built with **Java Swing** and **Apache Maven** that connects directly to the **Google Gemini API** for real-time AI conversations through a clean graphical user interface.

---

## ✨ Features

- **Interactive Desktop UI:** Built using Java Swing for a responsive, native desktop chat experience.
- **Google Gemini Integration:** Sends user prompts to the Gemini API and displays formatted responses in real time.
- **Maven Project Structure:** Standard Maven (`pom.xml`) setup for clean dependency management and easy builds.
- **Conversation Flow:** Supports multi-turn prompt input and readable chat history output.

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 25 or higher)
- **GUI Framework:** Java Swing (`javax.swing`, `java.awt`)
- **Build Tool:** Apache Maven
- **AI Integration:** Google Gemini API (`generativelanguage.googleapis.com`)

---

## 📂 Project Structure

```text
talkWithGemini_UsingJAVA-SWING/
├── src/
│   └── main/
│       └── java/          # Application source code (Swing UI & Gemini API client)
│          └── com/
│              └── example/
│                  └── Test.java
│                  └── Talk.java
│                  └── GUI.java
│                  └── WindowTest.java
├── .gitignore
├── pom.xml                # Maven dependencies and build configuration
└── README.md
```
---

## 🚀 Getting Started

- **Language:** Java (JDK 25 or higher)
- Apache Maven 
- A valid Google Gemini API Key from Google AI studio

---

## 🚀 Installation and Setup 

- Clone the repository
  ```text
  git clone [https://github.com/trishab2005/talkWithGemini_UsingJAVA-SWING.git](https://github.com/trishab2005/talkWithGemini_UsingJAVA-SWING.git)
  cd talkWithGemini_UsingJAVA-SWING
  ```

- Configure your Gemini API Key
  ```text
  export GEMINI_API_KEY="your_api_key_here"
  ```
- Build the project with Maven
  ```text
  mvn clean install
  ```
- Run the application 
  ```text
  mvn exec:java -Dexec.mainClass="com.example.Main"
  ```
---

## 📸 Screenshots
<img width="1440" height="900" alt="Screenshot 2026-11-21 at 9 59 26 AM" src="https://github.com/user-attachments/assets/befd535f-9f1f-4a00-8987-5149b875cfdd" />
<img width="1440" height="900" alt="Screenshot 2026-11-21 at 10 07 07 AM" src="https://github.com/user-attachments/assets/e9d9b76b-7587-449f-b30a-69a52081bd4c" />
<img width="1440" height="900" alt="Screenshot 2026-11-21 at 10 07 15 AM" src="https://github.com/user-attachments/assets/baa0c0cc-306e-4835-983e-f62d1f3d3fb4" />
<img width="1440" height="900" alt="Screenshot 2026-11-21 at 10 07 55 AM" src="https://github.com/user-attachments/assets/cbc45961-dd54-4a8c-921c-fcb3a40cf79c" />

## 🔮 Future Improvements

- Streaming token-by-token responses in the Swing UI
- Markdown / code-block syntax highlighting in chat bubbles
- Model selector dropdown (e.g., gemini-2.5-flash, gemini-2.5-pro)
- Export chat history to .txt or .md

## 👤 Author

### Trisha Basak 
- GitHub: @trishab2005
