Elbette! İşte projen için İngilizce versiyonunda sade, temiz ve profesyonel bir `README.md`:

---

## 🤖 Discord GPT Bot

A simple Discord bot that uses the OpenAI GPT API to respond to messages in a specific Discord channel.

---

### 📁 Project Structure

```
src
├── main
│   ├── kotlin
│   │   ├── bot
│   │   │   └── Init.kt               # Initializes the Discord bot
│   │   ├── commants
│   │   │   └── GptCommand.kt        # Handles GPT command
│   │   ├── config
│   │   │   └── GetEnv.kt            # Loads environment variables
│   │   ├── Main.kt                  # Application entry point
│   │   └── service
│   │       └── GptService.kt        # Makes requests to OpenAI API
│   └── resources
│       └── .env                     # Environment variables
└── test
    ├── kotlin
    └── resources
```

---

### ⚙️ Setup

> ⚠️ This project requires **Java 23 or higher**.
> It uses `jvmToolchain(23)` in Gradle, so Gradle will automatically download JDK 23 if it's not installed.

1. Clone the repository:

```bash
git clone https://github.com/your-username/discord-gpt-bot.git
cd discord-gpt-bot
```

2. Create a `.env` file under `src/main/resources/` with the following content:

```
DISCORD_TOKEN=your_discord_bot_token
MESSAGE_CHANNEL=channel_id_where_command_will_work
GPT_TOKEN=your_openai_api_key
GPT_MODEL=gpt-4
```

3. Run the bot:

```bash
./gradlew run
```

---

### 💬 Usage

The bot only responds in the channel whose ID is defined as `MESSAGE_CHANNEL` in the `.env` file.
When a GPT command is detected, it forwards the message to the OpenAI API and sends back the response.

---

### 🔐 Security Tip

Make sure you **do not commit** your `.env` file to version control.
Add this to your `.gitignore`:

```
*.env
```

---

### 📄 License

[MIT License](./LICENSE)

