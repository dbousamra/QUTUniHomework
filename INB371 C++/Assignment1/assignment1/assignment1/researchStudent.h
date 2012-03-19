#include "student.h"
#include <vector>

#ifndef RESEARCH_STUDENT
#define RESEARCH_STUDENT

//Enumeration type containing student categories.
//PhD students, and Master students.
enum DegreeType
{
	PhD = 0,
	Master = 1,
};

//Enumeration type containing student study status.
//Values are used as array indexes
enum StudyStatus
{
	NewlyEnrolled = 0,
	TopicConfirmed = 1,
	CandidatureConfirmed = 2,
	DegreeCompletion = 3,
};

class researchStudent : public student
{
public:


/******** Constructor ********/

researchStudent(string first = "", string last = "", string id = "");

/******** Accessors / Mutators ********/


void setDegreeType(DegreeType type);

string getDegreeType() const;

void setstudyStatus(StudyStatus status);

string getStudyStatus() const;



/******** Utility Functions ********/
void researchStudent::display(ostream & out) const;


string calculateNextMilestone() const;



protected:

private:
//std::vector<unitdetails> units2;
DegreeType degreeType;
StudyStatus studyStatus;
};

#endif