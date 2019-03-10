CREATE TABLE student(
student_id INT NOT NULL,
full_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
gpa DECIMAL(5,2) NOT NULL,
pass VARCHAR(255) NOT NULL,
student_role INT NOT NULL,
CONSTRAINT student_pk PRIMARY KEY(student_id)
);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(1, 'Bairon Vasquez','b@gmail.com', 3.4, '111', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(2, 'Yamil Burgos','y@gmail.com', 3.4, '222', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(3, 'Joseph Robinson','J@gmail.com', 3.9, '333', -1);

INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(61, 'Josephine Darakjy','josephine_darakjy@darakjy.org', 2.9, '48116', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(62, 'Lenna Paprocki','lpaprocki@hotmail.com', 3.3, '99501', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(63, 'Donette Foller','donette.foller@cox.net', 3.1, '45011', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(64, 'Roxane Campain','roxane@hotmail.com', 2.5, '99708', -1);

INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(65, 'Brock Bolognia','bbolognia@yahoo.com', 2.9, '10003', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(66, 'Shenika Seewald','shenika@gmail.com', 2.3, '91405', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(67, 'Chauncey Biddy','chauncey_motley@aol.com', 3.7, '32804', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(68, 'Jani Biddy','jbiddy@yahoo.com', 2.2, '98104', -1);

INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(21, 'Rino','R@gmail.com', 2.1, '123', -1);
INSERT INTO STUDENT(student_id, full_name, email, gpa, pass, student_role) VALUES(41, 'chandler beans','chandler@yahoo.com', 2.5, '434343', -1);

CREATE TABLE instructor(
instructor_id INT NOT NULL,
full_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
speciality VARCHAR(255) NOT NULL,
admin_role INT NOT NULL,
pass VARCHAR(255) NOT NULL,
CONSTRAINT instructor_pk PRIMARY KEY(instructor_id)
);

INSERT INTO INSTRUCTOR(instructor_id, full_name, email, speciality, admin_role, pass) VALUES(1, 'Luke','luke@gmail.com', 'Mathemathician', 0, '444');
INSERT INTO INSTRUCTOR(instructor_id, full_name, email, speciality, admin_role, pass) VALUES(2, 'lance','lance@gmail.com', 'scientis', 0, '555');
INSERT INTO INSTRUCTOR(instructor_id, full_name, email, speciality, admin_role, pass) VALUES(3, 'mark','mark@gmail.com', 'History', 1, '666');

INSERT INTO INSTRUCTOR(instructor_id, full_name, email, speciality, admin_role, pass) VALUES(21, 'Ruthann Keener','ruthann@hotmail.com', 'Physics', 0, '78028');
INSERT INTO INSTRUCTOR(instructor_id, full_name, email, speciality, admin_role, pass) VALUES(22, 'Kati Rulapaugh','kati.rulapaugh@hotmail.com', 'Analyst', 0, '67410');
INSERT INTO INSTRUCTOR(instructor_id, full_name, email, speciality, admin_role, pass) VALUES(23, 'Loren Asar','loren.asar@aol.com', 'English', 1, '18518');


CREATE TABLE course(
course_id INT NOT NULL,
course_name VARCHAR(255) NOT NULL UNIQUE,
minimum_gpa DECIMAL(5,2) NOT NULL,
CONSTRAINT course_pk PRIMARY KEY(course_id)
);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(1, 'Math', 3.1);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(2, 'Science', 3.2);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(3, 'English', 3.1);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(41, 'GYM', 2.8);

INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(61, 'Physics', 3.4);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(62, 'History', 3.0);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(63, 'Programming', 3.2);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(64, 'DevUps', 2.8);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(65, 'AVM', 2.5);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(66, 'Soc Analyst', 3.3);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(67, 'Web Development', 3.0);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(68, 'Robotics', 3.8);
INSERT INTO COURSE(course_id, course_name, minimum_gpa) VALUES(69, 'Foreign Language', 2.9);

CREATE TABLE teaching(
teaching_id INT AUTO_INCREMENT  NOT NULL,
course_id INT NOT NULL,
instructor_id INT NOT NULL,
CONSTRAINT course_fk FOREIGN KEY(course_id) REFERENCES course(course_id),
CONSTRAINT instructor_fk FOREIGN KEY(instructor_id) REFERENCES instructor(instructor_id),
CONSTRAINT teaching_pk PRIMARY KEY(teaching_id)
);

INSERT INTO TEACHING(course_id, instructor_id) VALUES(1,1);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(2,3);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(3,2);

INSERT INTO TEACHING(course_id, instructor_id) VALUES(41,21);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(66,22);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(65,23);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(64,1);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(63,23);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(62,2);
INSERT INTO TEACHING(course_id, instructor_id) VALUES(61,21);

CREATE TABLE attending(
attending_id INT AUTO_INCREMENT NOT NULL,
course_id INT NOT NULL,
student_id INT NOT NULL,
CONSTRAINT course_att_fk FOREIGN KEY(course_id) REFERENCES course(course_id),
CONSTRAINT student_att_fk FOREIGN KEY(student_id) REFERENCES student(student_id),
CONSTRAINT attending_pk PRIMARY KEY(attending_id)
);

INSERT INTO ATTENDING(course_id, student_id) VALUES(1,3);
INSERT INTO ATTENDING(course_id, student_id) VALUES(2,3);

INSERT INTO ATTENDING(course_id, student_id) VALUES(1,2);
INSERT INTO ATTENDING(course_id, student_id) VALUES(2,2);
INSERT INTO ATTENDING(course_id, student_id) VALUES(1,1);
INSERT INTO ATTENDING(course_id, student_id) VALUES(2,1);
INSERT INTO ATTENDING(course_id, student_id) VALUES(3,68);
INSERT INTO ATTENDING(course_id, student_id) VALUES(41,68);
INSERT INTO ATTENDING(course_id, student_id) VALUES(3,67);
INSERT INTO ATTENDING(course_id, student_id) VALUES(41,67);
INSERT INTO ATTENDING(course_id, student_id) VALUES(3,66);
INSERT INTO ATTENDING(course_id, student_id) VALUES(41,66);
INSERT INTO ATTENDING(course_id, student_id) VALUES(66,65);
INSERT INTO ATTENDING(course_id, student_id) VALUES(65,65);
INSERT INTO ATTENDING(course_id, student_id) VALUES(66,64);
INSERT INTO ATTENDING(course_id, student_id) VALUES(65,64);
INSERT INTO ATTENDING(course_id, student_id) VALUES(66,63);
INSERT INTO ATTENDING(course_id, student_id) VALUES(65,63);
INSERT INTO ATTENDING(course_id, student_id) VALUES(64,62);
INSERT INTO ATTENDING(course_id, student_id) VALUES(63,62);
INSERT INTO ATTENDING(course_id, student_id) VALUES(64,61);
INSERT INTO ATTENDING(course_id, student_id) VALUES(63,61);
INSERT INTO ATTENDING(course_id, student_id) VALUES(64,41);
INSERT INTO ATTENDING(course_id, student_id) VALUES(63,41);
INSERT INTO ATTENDING(course_id, student_id) VALUES(62,41);
INSERT INTO ATTENDING(course_id, student_id) VALUES(61,41);
INSERT INTO ATTENDING(course_id, student_id) VALUES(62,21);
INSERT INTO ATTENDING(course_id, student_id) VALUES(61,21);
INSERT INTO ATTENDING(course_id, student_id) VALUES(62,65);
INSERT INTO ATTENDING(course_id, student_id) VALUES(61,65);

COMMIT;
