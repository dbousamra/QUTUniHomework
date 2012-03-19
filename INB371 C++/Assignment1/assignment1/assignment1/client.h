#include "courseStudent.h"
#include "researchStudent.h"
using namespace std;

class client
{
public:

/******** Constructor ********/

client();
void printMenu();

private:

/******** Utility Functions ********/

void addCourseStudent();
void addResearchStudent();

void displayCourseStudentInfo();
void displayResearchStudentInfo();
void displayAllStudents();

string addIDNumber();
string addName(string nameType);
void addUnits(courseStudent &studentObject);
void addDegreeType(researchStudent &studentObject);
void addStudyStatus(researchStudent &studentObject);

};
