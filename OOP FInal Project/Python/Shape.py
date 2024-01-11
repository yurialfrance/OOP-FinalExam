import tkinter as tk
from tkinter import Canvas

class Shape:
    def draw(self, canvas):
        canvas.create_oval(50, 50, 150, 150, fill="blue")

class Circle(Shape):
    def draw(self, canvas):
        super().draw(canvas)

class Rectangle(Shape):
    def draw(self, canvas):
        super().draw(canvas)
        canvas.create_rectangle(200, 50, 300, 150, fill="red")

class ShapePanel(Canvas):
    def __init__(self, master, shapes):
        super().__init__(master, width=400, height=200)
        self.shapes = shapes
        self.pack()

    def paint_shapes(self):
        for shape in self.shapes:
            shape.draw(self)

def create_and_show_gui():
    root = tk.Tk()
    root.title("Shapes GUI")

    shapes = [Circle(), Rectangle()]
    shape_panel = ShapePanel(root, shapes)
    shape_panel.paint_shapes()

    root.mainloop()

if __name__ == "__main__":
    create_and_show_gui()
