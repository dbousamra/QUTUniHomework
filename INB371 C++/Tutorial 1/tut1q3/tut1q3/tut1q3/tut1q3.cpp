#include <iostream>

int main()
{
	double number1 = 7.3;
	double number2;

	double *fPtr;
	fPtr = &number1;

	std::cout << *fPtr << std::endl;;
	number2 = *fPtr;
	std::cout << number2 << std::endl;
	std::cout << &number1 << std::endl;
	std::cout << &fPtr << std::endl;

}
