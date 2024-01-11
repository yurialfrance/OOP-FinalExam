import tkinter as tk
from tkinter import ttk

class Transportation:
    def __init__(self, name):
        self.name = name

    def move(self):
        raise NotImplementedError("Subclasses must implement the move method")

    def stop(self):
        return f"{self.name} has stopped"

class FuelConsumable:
    def consume_fuel(self):
        raise NotImplementedError("Subclasses must implement the consume_fuel method")

class Car(Transportation, FuelConsumable):
    def move(self):
        return f"{self.name} is moving on the road"

    def consume_fuel(self):
        return f"{self.name} is consuming fuel"

class Bicycle(Transportation):
    def move(self):
        return f"{self.name} is moving on the bike path"

def create_and_show_gui():
    def on_car_button_click():
        car = Car("Toyota")
        result_text.config(state=tk.NORMAL)
        result_text.insert(tk.END, car.move() + "\n")
        result_text.insert(tk.END, car.consume_fuel() + "\n")
        result_text.insert(tk.END, car.stop() + "\n")
        result_text.config(state=tk.DISABLED)

    def on_bicycle_button_click():
        bicycle = Bicycle("Mountain Bike")
        result_text.config(state=tk.NORMAL)
        result_text.insert(tk.END, bicycle.move() + "\n")
        result_text.insert(tk.END, bicycle.stop() + "\n")
        result_text.config(state=tk.DISABLED)

    root = tk.Tk()
    root.title("Transportation GUI")
    root.geometry("400x300")

    car_button = ttk.Button(root, text="Car", command=on_car_button_click)
    bicycle_button = ttk.Button(root, text="Bicycle", command=on_bicycle_button_click)

    result_text = tk.Text(root, height=10, width=30, state=tk.DISABLED)
    result_text.tag_configure("center", justify="center")

    panel = ttk.Frame(root)
    panel.grid(row=0, column=0, padx=10, pady=10)
    panel.columnconfigure(0, weight=1)
    panel.columnconfigure(1, weight=1)

    car_button.grid(row=0, column=0, padx=5, pady=5, sticky="ew")
    bicycle_button.grid(row=0, column=1, padx=5, pady=5, sticky="ew")

    result_text.grid(row=1, column=0, columnspan=2, padx=10, pady=10, sticky="nsew")

    car_button.columnconfigure(0, weight=1)
    bicycle_button.columnconfigure(1, weight=1)
    panel.rowconfigure(1, weight=1)

    root.mainloop()

if __name__ == "__main__":
    create_and_show_gui()
