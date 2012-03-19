#include <iostream>
#include "client.h"
#include <string>
#include <sstream>
#include <limits>
#include <algorithm>
#include <vector>

#define TOTALSTUDENTS 20 //number of students to store

/*** Constructor Implementation ***/

client::client()
{
}

/*** Class Variables ***/

//holds all the student objects
student *allStudents[TOTALSTUDENTS];
int numberOfStudentsStored = 0;


/*** Functions Implementation ***/

void client::addCourseStudent()
{
	string idNumber;
	string firstName;
	string lastName;

	courseStudent cStudent;



	//prompt user for ID number1
	idNumber = addIDNumber();

	//prompt user for students firstname
	firstName = addName("first");

	//prompt user for students lastname
	lastName = addName("last");

	cStudent.setFirstName(firstName);
	cStudent.setLastName(lastName);
	cStudent.setIDnumber(idNumber);
	cStudent.setStudentType(courseWork);
	addUnits(cStudent);

	allStudents[numberOfStudentsStored] = &cStudent;
	numberOfStudentsStored++;
	printMenu();

}

void client::addResearchStudent()
{
	string idNumber;
	string firstName;
	string lastName;

	//create new researchStudent object
	researchStudent rStudent;

	//prompt user for ID number1
	idNumber = addIDNumber();

	//prompt user for students firstname
	firstName = addName("first");

	//prompt user for students lastname
	lastName = addName("last");

	rStudent.setFirstName(firstName);
	rStudent.setLastName(lastName);
	rStudent.setIDnumber(idNumber);
	rStudent.setStudentType(researchWork);
	addDegreeType(rStudent);
	addStudyStatus(rStudent);

	allStudents[numberOfStudentsStored] = &rStudent;
	numberOfStudentsStored++;
	printMenu();
}

void client::addDegreeType(researchStudent &studentObject)
{
	while (true)
	{
		int input;
		DegreeType possibleDegreeTypes[2] = {PhD, Master};

		cout << endl << "What sort of degree is the student undertaking?" << endl  << endl;

		cout << "Please select from the menu options"<< endl << endl <<
		"\t1. PhD" << endl <<
		"\t2. Master" << endl << endl;

		cout << "Enter choice: ";
		cin >> input;

		//heavily assuming user input is correct :P
		//obviously without validation this will error when user inputs a char
		studentObject.setDegreeType(possibleDegreeTypes[input-1]);
		break;
	}
}


void client::addStudyStatus(researchStudent &studentObject)
{
	while (true)
	{
		int input;
		StudyStatus possibleDegreeTypes[4] = {NewlyEnrolled, TopicConfirmed, CandidatureConfirmed, DegreeCompletion};

		cout << endl << "What is the students study status?" << endl << endl;

		cout << "Please select from the menu options"<< endl << endl <<
		"\t1. Newly Enrolled" << endl <<
		"\t2. Topic Confirmed" << endl <<
		"\t3. Candidature Confirmed" << endl <<
		"\t4. Degree Completion" << endl << endl;

		cout << "Enter choice: ";
		cin >> input;

		//heavily assuming user input is correct :P
		//obviously without validation this will error when user inputs a char
		studentObject.setstudyStatus(possibleDegreeTypes[input-1]);
		break;
	}
}



void client::addUnits(courseStudent &studentObject)
{
	while (true)

	{
		string unitsTaken;
		int unitsTakenInt;
		cout << "How many units has the student taken? ";
		cin >> unitsTaken;
		std::istringstream ss(unitsTaken);
		ss >> unitsTakenInt;

		std::vector<courseStudent::unitdetails> test;


		for(int x=0; x < unitsTakenInt; x++)
		{
			string code;
			string grade;
			int gradeInt;
			cout << endl << "Please enter the units code: ";
			cin >> code;
			cout << endl << "Please enter the grade received for this unit (1-7): ";
			cin >> grade;
			std::istringstream ss(grade);
			ss >> gradeInt;
			courseStudent::unitdetails units;
			units.unitCode = code;
			units.unitGrade = gradeInt;
			studentObject.setUnitsTaken(unitsTakenInt);
			studentObject.setGrade(units);
		}
		break;


	}
}


string client::addIDNumber()
{
	string idNumber;
	while (true)
	{
		cout << "Please enter the students ID number: ";
		cin >> idNumber;
		cout << endl;

		return idNumber;
	}
}

string client::addName(string nameType)
{
	string name;
	while (true)
	{
		cout << "Please enter the students " + nameType + " name: ";
		cin >> name;
		cout << endl;
		return name;
	}
}

void client::displayCourseStudentInfo()
{
	for (int x=0; x<numberOfStudentsStored; x++)
	{
		if (allStudents[x]->getStudentType() == courseWork)
		{
			allStudents[0]->display(cout);
			cout << endl;
		}
	}
}

void client::displayResearchStudentInfo()
{
	for (int x=0; x<numberOfStudentsStored; x++)
	{
		if (allStudents[x]->getStudentType() == researchWork)
		{
			allStudents[x]->display(cout);
			cout << endl;
		}
	}
}

void client::displayAllStudents()
{
	//Wasn't sure if you wanted me to label whether a student was course of research. I assumed not, and I'm simply printing them
	for (int x=0; x<numberOfStudentsStored; x++)
	{
		allStudents[x]->display(cout);
		cout << endl;
	}
}



void client::printMenu()
{
	cout << endl;
	cout <<"Please select from the menu options"<< endl << endl <<

	"\t1. Add a course work student" << endl << endl <<
	"\t2. Add a research student" << endl << endl <<
	"\t3. Output course student assessment results" << endl << endl <<
	"\t4. Output research student assessment results" << endl << endl <<
	"\t5. Output student information and assessment results for all students" << endl << endl <<
	"\t6. Exit" << endl << endl;

	string choice;
	int xint;
	bool done = false;

	while (done == false)
	{
		cout << "Enter choice: ";
		cin >> choice;
		cout << endl; //to give a new line after input, when going to methods. Could put it in methods, but neater here.

		std::istringstream ss(choice);
		ss >> xint;
		switch(xint)
		{
		case 1:
			done = true;
			client::addCourseStudent();

		case 2:
			done = true;
			client::addResearchStudent();

		case 3:
			client::displayCourseStudentInfo();
			client::printMenu();

		case 4:
			client::displayResearchStudentInfo();
			client::printMenu();

		case 5:
			client::displayAllStudents();
			client::printMenu();

		case 6:
			done = true;
			break;

		default:
			cout << "Please input a number from 1 to 6. Please try again" << endl << endl;
			break;
		}
	}
}


int main()
{
	client Client;
	Client.printMenu();

}
