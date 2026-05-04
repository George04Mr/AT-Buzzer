# 🎵 Buzzer Control IoT System

A full-stack IoT project that lets you control a buzzer and play melodies from an Android app.

---

## 📌 Overview

This project implements a complete IoT pipeline:

```
Android App → HTTP (WiFi) → Flask Server (Laptop) → USB → Raspberry Pi Pico → Buzzer
```

The user selects a song in the mobile app, and the buzzer plays it in real time.

---

## ⚙️ Hardware Components

* Raspberry Pi Pico
* Passive Buzzer
* Breadboard
* Jumper wires
* USB cable

---

## 🧠 Architecture

1. 📱 User taps a button in the Android app
2. 🌐 App sends HTTP request (`/play?song=...`)
3. 💻 Flask server receives request
4. 🔌 Server sends command via USB serial
5. ⚡ Pico processes command
6. 🔊 Buzzer plays the selected melody

---

## 🔌 Wiring

### Passive Buzzer

| Pico Pin | Connection |
| -------- | ---------- |
| GP15     | Buzzer (+) |
| GND      | Buzzer (-) |

---

## 📁 Project Structure

```
.
├── pico/
│   └── main.py
├── bridge/
│   └── bridge.py
├── android-app/
│   └── (Android Studio project)
└── README.md
```

---

## ▶️ How to Run

### 1. 🔌 Setup Pico

* Install MicroPython on your Pico
* Upload `pico/main.py` using Thonny
* Ensure it listens for serial commands

---

### 2. 💻 Run Python Bridge

Install dependencies:

```bash
pip install flask pyserial
```

Run server:

```bash
python bridge/bridge.py
```

Update serial port if needed:

| OS      | Port Example            |
| ------- | ----------------------- |
| macOS   | `/dev/tty.usbmodemXXXX` |
| Linux   | `/dev/ttyACM0`          |
| Windows | `COM3`                  |

---

### 3. 📱 Run Android App

* Open `android-app/` in Android Studio
* Connect your phone
* Run the app

---

## ⚠️ Android Configuration

Allow HTTP (required for local server):

```xml
<application
    android:usesCleartextTraffic="true"
    ... >
```

---

## 🎶 Available Songs

| Name       | Command  |
| ---------- | -------- |
| Beep       | `beep`   |
| Scale      | `scale`  |
| Melody     | `melody` |
| Ode to Joy | `ode`    |

---

## 📱 Features

* 🎵 Play multiple songs from mobile app
* 📡 Real-time communication over WiFi
* 🔊 Hardware sound output via buzzer
* 🧩 Modular system (app + server + embedded)

---

## 🧠 Tech Stack

* **Embedded:** MicroPython
* **Backend:** Python + Flask
* **Mobile:** Kotlin + Jetpack Compose
* **Communication:** HTTP + Serial
