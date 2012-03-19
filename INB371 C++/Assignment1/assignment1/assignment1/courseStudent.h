#include "student.h"
#include <vector>

#ifndef COURSE_STUDENT
#define COURSE_STUDENT

class courseStudent : public student
{
public:

struct unitdetails {
	string unitCode;
	int unitGrade;
};

/******** Constructor ********/

courseStudent(string first = "", string last = "", string id = "");

/******** Accessors / Mutators ********/

void setGrade(unitdetails units);

int getGrade(int index);

string getUnitCode(int index);

void setUnitsTaken(int unitsTakenInt);

int getUnitsTaken();

std::vector<unitdetails> getUnitDetails();

float calculateGPA() const;

/******** Utility Functions ********/

void courseStudent::display(ostream & out) const;


protected:

private:
int unitsTaken;
std::vector<unitdetails> units2;
};

#endif