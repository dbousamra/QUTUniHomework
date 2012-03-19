#include <iostream>
#include "student.h"

using namespace std;

/*** Constructor Implementation ***/
student::student(string first, string last, string id)
{
}


/*** Accessors and Mutators ***/
string student::getFirstName()
{
	return firstName;
}

void student::setFirstName(string firstNameInput)
{
	firstName = firstNameInput;
}

string student::getLastName()
{
	return lastName;
}

void student::setLastName(string lastNameInput)
{
	lastName = lastNameInput;
}

void student::setIDnumber(string idNumberInput)
{
	idNumber = idNumberInput;
}

string student::getIDNumber()
{
	return idNumber;
}

void student::setStudentType(Category sType)
{
	studentType = sType;
}

Category student::getStudentType()
{
	return studentType;
}

/*** Functions Implementation ***/
void student::display(ostream & out) const
{
	out << "Name: " << firstName << " " << lastName << endl;
	out << "ID Number: " << idNumber << endl;
}

