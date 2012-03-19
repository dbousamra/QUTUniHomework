#include "courseStudent.h"
#include <vector>
#include <numeric>

/******** Constructor ********/

courseStudent::courseStudent(string first, string last, string id)

	: student(first, last, id)
{
}


/*** Accessors and Mutators ***/
void courseStudent::setGrade(unitdetails units)
{
	courseStudent::units2.push_back(units);
}

int courseStudent::getGrade(int index)
{
	return courseStudent::units2.at(index).unitGrade;
}

string courseStudent::getUnitCode(int index)
{
	return courseStudent::units2.at(index).unitCode;
}


int courseStudent::getUnitsTaken()
{
	return courseStudent::unitsTaken;
}

void courseStudent::setUnitsTaken(int unitsTakenInt)
{
	courseStudent::unitsTaken = unitsTakenInt;
}


std::vector<courseStudent::unitdetails> courseStudent::getUnitDetails()
{
	return courseStudent::units2;
}

float courseStudent::calculateGPA() const
{
	float sumOfGrades = 0.0;
	for(long i=0; i < (long)units2.size(); i++)
	{
		sumOfGrades += units2.at(i).unitGrade;
	}

	return sumOfGrades/unitsTaken;
}


//--- Definition of CourseStudents's display()
void courseStudent::display(ostream & out) const
{
	const float GPA = calculateGPA();
	student::display(out); //inherited members
	out << "Number of units taken: " << unitsTaken << endl;

	for(long i=0; i < (long)units2.size(); i++)
	{
		out << "\tUnit Code: " << units2.at(i).unitCode << " Grade: " << units2.at(i).unitGrade << endl;
	}
	out << "\tGPA: " << GPA << endl;

}
