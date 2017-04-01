#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
struct node
{
	int name=0;
	int packageNum = 0;
	int money=0;
}person[10010];
int compares(struct node a, struct node b)
{
	if (a.money == b.money)
	{
		if (a.packageNum == b.packageNum)
		{
			return a.name < b.name;
		}
		else
		{
			return a.packageNum > b.packageNum;
		}
	}
	else
	{
		return a.money > b.money;
	}
}
int main()
{
	int num = 0;
	cin >> num;
	for (int i = 1; i <= num; i++)
	{
		int loop = 0;
		person[i].name = i;
		cin >> loop;
		for (int j = 1; j <= loop; j++)
		{
			int name = 0;
			int money = 0;
			cin >> name >> money;
			person[i].money -= money;
			person[name].money += money;
			person[name].packageNum++;
		}
	}
	sort(person+1, person + num+1, compares);
	for (int i = 1; i <= num; i++)
	{
		printf("%d %.2lf", person[i].name, (double)person[i].money / 100.0);
		if (i != num) cout << endl;
	}
	return 0;
}