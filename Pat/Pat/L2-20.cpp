#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
#include<set>
#define MAXNUMBER 100001
using namespace std;
struct kid
{
	double power = 0;     //����ֵ����������ǵõ��ߣ���Ϊ����ֵ
	bool genius = false;  //�Ƿ��ǵõ���
	vector<int> student;  //����ͽ�ܣ��������ͽ�ܱ�ţ�
}party[MAXNUMBER];	          //������������
double geniusPower = 0;   //�õ��ߵĹ����ܺ�
double discount = 0;	  //ÿ�δ���˥����ֵ
						  /**
						  *
						  * @param number
						  * ��ǰѧ�����
						  * @param teacherP
						  * ���ѧ������ʦ�Ĺ���ֵ
						  */
void dfs(int number, double teacherP)
{
	if (party[number].genius)//����ǵõ��ߣ�����ֵ�ӽ�geniusPower
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
		int innerLoop = 0;	//�����м���ѧ��
		cin >> innerLoop;
		if (innerLoop == 0)
		{
			party[i].genius = true;
			double p = 0;	    //��ȡ����ֵ
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
	if (N == 1)//�����һ����
	{
		if (party[0].genius) cout << printf("%d", floor(party[0].power * teacherPower));//��Ϊ�õ��� 
		else cout << "0";
		return 0;
	}
	for (int ss : party[0].student)//��ʼDFS
	{
		dfs(ss, party[0].power);
	}
	printf("%d", floor(geniusPower));
	return 0;
}
