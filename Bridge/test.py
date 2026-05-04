from flask import Flask, request
import serial

app = Flask(__name__)

ser = serial.Serial('/dev/tty.usbmodem14101', 115200)

ser.write(b"beep\n")