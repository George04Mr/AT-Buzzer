from flask import Flask, request
import serial

app = Flask(__name__)

ser = serial.Serial('/dev/tty.usbmodem14101', 115200)  # change COM port!

@app.route("/play")
def play():
    song = request.args.get("song")
    if song:
        ser.write((song + "\n").encode())
        return "OK"
    return "No song"

app.run(host="0.0.0.0", port=5000)