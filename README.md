# Niramaya-backend
 #1. DocotorController:
1.1 get all doctors 
get mapping: /alldocs
return: a list of all doctors and HttpStatus.OK
1.2 get all appointments of a specific doctor
get: /{id}/appointments
return: list of apointments and HttpStatus.OK
1.3 find doctor by id 
post: /doctor/{id}
return : Doctor + HttpStatus.OK || HttpStatus.NOT_FOUND
