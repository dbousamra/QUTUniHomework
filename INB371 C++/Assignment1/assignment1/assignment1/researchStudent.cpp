#include "researchStudent.h"
#include <vector>


/******** Constructor ********/

researchStudent::researchStudent(string first, string last, string id)

	: student(first, last, id)
{
}



/******** Accessors / Mutators ********/

void researchStudent::setDegreeType(DegreeType type)
{
	researchStudent::degreeType = type;
}

string researchStudent::getDegreeType() const
{
	string possibleDegreeTypes[2] = {"PhD", "Master"};
	return possibleDegreeTypes[degreeType];
}

void researchStudent::setstudyStatus(StudyStatus status)
{
	researchStudent::studyStatus = status;
}

string researchStudent::getStudyStatus() const
{
	string possibleStatuses[4] = {"Newly Enrolled", "Topic Confirmed", "Candidature Confirmed", "Degree Completion"};
	return possibleStatuses[studyStatus];
}

/******** Utility Functions ********/

string researchStudent::calculateNextMilestone() const
{
	string possibleMilestones[4] = {"Proposal-submission", "Confirmation-report-submission", "Thesis-submission", "Thesis-completion"};
	return possibleMilestones[studyStatus];
};

//--- Definition of CourseStudents's display()
void researchStudent::display(ostream & out) const
{
	const string nextMilestone = calculateNextMilestone();
	const string studyStatus = getStudyStatus();
	const string degreeType = getDegreeType();
	student::display(out); //inherited members
	out << "\tDegree type: " << degreeType << endl;
	out << "\tMilestone achieved: " << getStudyStatus() << endl;
	out << "\tNext milestone: " << nextMilestone << endl;

}
