# Niramaya-backend
# Start jar in terminal 
java -jar niramaya-0.0.1-SNAPSHOT.jar 

# 1. DocotorController:
## 1.1 get all doctors 
get mapping: /alldocs
return: a list of all doctors and HttpStatus.OK
## 1.2 get all appointments of a specific doctor
get: /{id}/appointments
return: list of apointments and HttpStatus.OK
## 1.3 find doctor by id 
get: /doctor/{id}
return : Doctor + HttpStatus.OK || HttpStatus.NOT_FOUND
## 1.4 Doctor Login
post: /login-doctor
json: {"email": "fvfd", "password":"xxx"}
return: Doctor || "Incorrect password", HttpStatus.FORBIDDEN || "User not found", HttpStatus.NOT_FOUND
## 1.5 Doctor Signup
post: /signup-doctor
json: {"email": "fvfd", "password":"xxx"}
return: Doctor, HttpStatus.OK ||  "User exists", HttpStatus.BAD_REQUEST

#2. PatientController:
## 2.1 find Patient by id 
get: /patient/{id}
return : Patient + HttpStatus.OK || HttpStatus.NOT_FOUND
## 2.2 Patient Login
post: /login-patient 
json: {"email": "fvfd", "password":"xxx"}
return: Patient || "Incorrect password", HttpStatus.FORBIDDEN || "User not found", HttpStatus.NOT_FOUND
## 2.3 Patient Signup
post: /signup-patient
json: {"email": "fvfd", "password":"xxx"}
return: Patient, HttpStatus.OK ||  "User exists", HttpStatus.BAD_REQUEST

#3. AppointmentController
## 3.1 make appointment 
post mapping: /make-appointment/{patientid}/{doctorid} 
json: {"time": "2021-10-23T20:18:31.049+00:00"}
return: HttpStatus.OK 




