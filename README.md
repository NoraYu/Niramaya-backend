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
post: /doctor/{id}
return : Doctor + HttpStatus.OK || HttpStatus.NOT_FOUND
## 1.4 Doctor Login
post: /login-doctor
return: Doctor || "Incorrect password", HttpStatus.FORBIDDEN || "User not found", HttpStatus.NOT_FOUND
## 1.5 Doctor Signup
post: /signup-doctor
return: Doctor, HttpStatus.OK ||  "User exists", HttpStatus.BAD_REQUEST



