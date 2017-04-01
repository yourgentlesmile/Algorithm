#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
#include<set>
#define MAXNUMBER 100001
using namespace std;
struct kid
{
	double power = 0;     //功力值，如果此人是得道者，则为翻倍值
	bool genius = false;  //是否是得道者
	vector<int> student;  //他的徒弟（储存的是徒弟编号）
}party[MAXNUMBER];	          //门派人数数组
double geniusPower = 0;   //得道者的功力总和
double discount = 0;	  //每次传功衰减比值
						  /**
						  *
						  * @param number
						  * 当前学生编号
						  * @param teacherP
						  * 这个学生的老师的功力值
						  */
void dfs(int number, double teacherP)
{
	if (party[number].genius)//如果是得道者，则将数值加进geniusPower
	{
		geniusPower += (teacherP*party[number].power*discount);
		party[number].power = (teacherP*party[number].power*discount);
	}
	else party[number].power = teacherP*discount;
	for (int a : party[number].student)
	{
		dfs(a, party[number].power);
	}
}
int main()
{
	int N = 0;
	double teacherPower = 0;
	cin >> N >> teacherPower >> discount;
	discount = (100 - discount) / 100;
	party[0].power = teacherPower;
	for (int i = 0; i < N; i++)
	{
		int innerLoop = 0;	//此人有几个学生
		cin >> innerLoop;
		if (innerLoop == 0)
		{
			party[i].genius = true;
			double p = 0;	    //读取功力值
			cin >> p;
			party[i].power = p;
		}
		else
		{
			for (int j = 0; j < innerLoop; j++)
			{
				int input = 0;
				cin >> input;
				party[i].student.push_back(input);
			}
		}
	}
	if (N == 1)//如果是一个人
	{
		if (party[0].genius) cout << printf("%d", floor(party[0].power * teacherPower));//且为得道者 
		else cout << "0";
		return 0;
	}
	for (int ss : party[0].student)//开始DFS
	{
		dfs(ss, party[0].power);
	}
	printf("%d", floor(geniusPower));
	return 0;
}
