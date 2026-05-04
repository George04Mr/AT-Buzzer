from machine import Pin, PWM
import time
import sys

buzzer = PWM(Pin(15))

def play_tone(freq, duration):
    if freq == 0:
        buzzer.duty_u16(0)
    else:
        buzzer.freq(freq)
        buzzer.duty_u16(30000)
    time.sleep(duration)
    buzzer.duty_u16(0)

def play_song(name):
    if name == "beep":
        play_tone(1000, 0.3)

    elif name == "scale":
        for n in [262, 294, 330, 349, 392, 440, 494, 523]:
            play_tone(n, 0.2)

    elif name == "melody":
        notes = [330, 392, 440, 0]
        for n in notes:
            play_tone(n, 0.3)

    elif name == "ode":
        notes = [330,330,349,392,392,349,330,294]
        for n in notes:
            play_tone(n, 0.3)

    else:
        print("Unknown song:", name)

print("Ready for commands...")

while True:
    cmd = sys.stdin.readline().strip()
    if cmd:
        print("Received:", cmd)
        play_song(cmd)