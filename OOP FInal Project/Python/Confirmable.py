#Code By: Yuri Alfrance Egipto
import tkinter as tk
from tkinter import ttk

class Confirmable:
    def display_confirmation(self):
        pass

class DocumentRequest(Confirmable):
    def __init__(self, name, student_number, college, document_requested,
                 degree_program, email, mobile_number):
        self.name = name
        self.student_number = student_number
        self.college = college
        self.document_requested = document_requested
        self.degree_program = degree_program
        self.email = email
        self.mobile_number = mobile_number

    def display_confirmation(self):
        confirmation_window = tk.Toplevel()
        confirmation_window.title("Confirmation")
        confirmation_window.geometry("400x250")

        title_label = tk.Label(confirmation_window, text="Thank You!", font=("Arial", 16, "bold"))
        title_label.pack()

        subtitle_label = tk.Label(confirmation_window, text="Your Document Request has been submitted.", font=("Arial", 14))
        subtitle_label.pack()

        info_frame = ttk.Frame(confirmation_window)
        info_frame.pack(pady=10)

        labels = ["Name:", "Student Number:", "College:", "Document Requested:",
                  "Degree Program:", "Email:", "Mobile Number:"]
        values = [self.name, self.student_number, self.college, self.document_requested,
                  self.degree_program, self.email, self.mobile_number]

        for label, value in zip(labels, values):
            label_widget = tk.Label(info_frame, text=f"{label} {value}", anchor="w")
            label_widget.pack(fill="x")

def submit_button_clicked():
    request = DocumentRequest(
        name_entry.get(),
        student_number_entry.get(),
        college_combobox.get(),
        document_combobox.get(),
        degree_program_entry.get(),
        email_entry.get(),
        mobile_number_entry.get()
    )
    request.display_confirmation()

# Create main window
main_window = tk.Tk()
main_window.title("Document Request App")
main_window.geometry("500x400")

# UI components
main_title_label = tk.Label(main_window, text="Pamantasan ng Lungsod ng Maynila", font=("Arial", 16, "bold"))
main_title_label.place(x=20, y=10, width=360)

sub_title_label = tk.Label(main_window, text="Document Request App", font=("Arial", 14))
sub_title_label.place(x=20, y=40, width=360)

labels = ["Name:", "Student Number:", "College:", "Document Requesting:",
          "Degree Program:", "Email:", "Mobile Number:"]
entries = [tk.Entry(main_window) for _ in range(7)]

name_entry, student_number_entry, degree_program_entry, email_entry, mobile_number_entry = entries[:5]

colleges = ["College of Engineering", "College of Nursing", "College of Education", "College of Science", "Business School"]
college_combobox = ttk.Combobox(main_window, values=colleges)
college_combobox.set(colleges[0])

documents = ["Certified True Copy of Diploma", "Certificate of Grades", "Certified True Copy of Transcript of Records",
             "Certification for NSTP Serial Number", "Certification of Enrollment/Attendance"]
document_combobox = ttk.Combobox(main_window, values=documents)
document_combobox.set(documents[0])

submit_button = tk.Button(main_window, text="Submit", command=submit_button_clicked)

# Place UI components
y_position = 80
for label, entry in zip(labels, entries):
    label_widget = tk.Label(main_window, text=label)
    label_widget.place(x=20, y=y_position, width=80)
    entry.place(x=150, y=y_position, width=200)
    y_position += 30

college_label = tk.Label(main_window, text="College:")
college_label.place(x=20, y=140, width=80)
college_combobox.place(x=150, y=140, width=200)

document_label = tk.Label(main_window, text="Document Requesting:")
document_label.place(x=20, y=170, width=150)
document_combobox.place(x=150, y=170, width=250)

submit_button.place(x=200, y=290, width=100)

main_window.mainloop()
