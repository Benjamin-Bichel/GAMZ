
# GAMZ
> ## SYSC 4806 Project Graduade Management System

GAMZ is graduate admission management system web application. Students are able to submit applications with relevant information. Professors are able to list their fields of research. The applications can then be filtered and reviewed by and administrator before forwarding them to the Professors for recommendations. The administrator can then make a final decision on the applicatons.

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)
> Link to Heroku app --> https://gamz4806.herokuapp.com/


### Group Leftovers1 -  Members:

- Benjamin Bichel - 100998411
- Fatima Hashi - 101041794


### Milestone 3 - Final Prototype:
------------------------------
- Login as a "prof", "applicant" or "admin" via autheticated roles
- IMPORTANT: see Instructions below to get username/password combo
- Applicant is able to submit a profile(s) and view, edit or delete their submitted profile
- Professor is able to submit a profile(s) and view, edit or delete  their submitted profile
- Professor is able to add fields
- Professor is able to filter and view based on applicants
- Administrator is able to view all submitted profiles by the Professor and Applicant
- Administrator can add, edit or delete both Professor and Applicant profiles
- Administrator can filter via fields and view listing of applicants

Instructions
-----------------------------
1. Run App.java class under the package "Application" 
2. Open a new browser and type http://localhost:8080/
3. You will be redirected to a login page
4. Enter username as "admin" , "applicant" or "prof"
5. Enter password encoded passwords, "adminpass", "applicantpass", and "profpass" respectiveley
6. Select a role from to dropdown

At this point, you are logged into the system.

To logout at any time, select the "Return to Hompage" button, then hit the "Logout" button


## Diagrams


### DataBase Schema
-----------------------------
![](images/DataBase_Schema_4806.png)

### UML Class Diagram
-----------------------------
![](images/UML%20Class%20Diagram.png)

### ER Mapping EntityManager
-----------------------------
![](images/entityManagerFactory(EntityManagerFactoryBuilder).png)


