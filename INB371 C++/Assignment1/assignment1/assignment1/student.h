#include <iostream>
#include <string>

using namespace std;

#ifndef STUDENT
#define STUDENT

//Enumeration type containing student categories.
//CourseWork students, and ResearchWork students.
enum Category
{
	courseWork,
	researchWork
};

class student
{
public:
/******** Constructor ********/

student(string first = "", string last = "", string id = "");

/******** Accessors and Mutators ********/

string getFirstName();

void setFirstName(string firstNameInput);


string getLastName();

void setLastName(string lastNameInput);


string getIDNumber();

void setIDnumber(string idNumberInput);


void setStudentType(Category studentType);

Category getStudentType();

/******** Function Members ********/

virtual void display(ostream & out) const;

private:
/********** Data Members **********/

string firstName, lastName, idNumber;
Category studentType;
};
// end of class declaration

#endif