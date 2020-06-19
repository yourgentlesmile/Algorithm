#include<iostream>
#include<cmath>
using namespace std;
int main()
{
	double E = 1000.0;
	double sum = 0;
	double m = 0,discount=0;
	cin >> m>>discount;
	m /= 100;
	while (E>0.000000001)
	{
		sum += (2 * E / (m*9.8));
		E *= (1 - (discount / 100));

	}
	printf("%.3lf", sum);
	return 0;
}
