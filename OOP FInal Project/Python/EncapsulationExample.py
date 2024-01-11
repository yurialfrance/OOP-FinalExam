import tkinter as tk
from tkinter import font

class EncapsulationExample(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Encapsulation Example")
        self.geometry("400x200")
        self.protocol("WM_DELETE_WINDOW", self.on_close)

        self.myLabel = tk.Label(self, text="Hello, Encapsulation!")
        self.myLabel["font"] = font.Font(family="Arial", size=16)

        changeTextButton = tk.Button(self, text="Click this", command=self.changeLabelText)

        panel = tk.Frame(self)
        panel.grid(row=0, column=0, padx=10, pady=10)

        self.myLabel.grid(row=0, column=0, pady=(0, 10))
        changeTextButton.grid(row=1, column=0, pady=(0, 10))

    def changeLabelText(self):
        self.myLabel["text"] = "Hello Pipol"

    def on_close(self):
        self.destroy()

if __name__ == "__main__":
    app = EncapsulationExample()
    app.mainloop()
