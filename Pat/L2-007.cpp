//#include<iostream>
//#include<algorithm>
//using namespace std;
//struct family
//{
//	int id = -5;
//	int num = 0;
//	double sumHouse = 0;
//	double area = 0;
//	bool Root = false;
//}familyCollection[10000];
//struct single
//{
//	int id = 0;
//	int father = -1;
//	int mother = -1;
//	double sumHouse = -1;
//	double area = -1;
//	int child[10];
//}singleCollection[1010];
//int pre[10000];
//int visit[10000] = { false };
//int find(int a)
//{
//	while (a!=pre[a])
//	{
//		a = pre[a];
//	}
//	return a;
//}
//void Unions(int a, int b)
//{
//	int a_Root = find(a);
//	int b_Root = find(b);
//	if (a_Root > b_Root)
//		pre[a_Root] = b_Root;
//	else if(a_Root<b_Root)
//	{
//		pre[b_Root] = a_Root;
//	}
//}
//int globalCounter = 0;
//int cmp(struct family a, struct family b)
//{
//	if (a.area == b.area)
//	{
//		return a.id < b.id;
//	}
//	else {
//		return a.area > b.area;
//	}
//}
//int main()
//{
//	for (int i = 0; i < 10000; i++)
//	{
//		pre[i] = i;
//	}
//	int howMany = 0;
//	cin >> howMany;
//	for (int i = 0; i < howMany; i++)
//	{
//		int childNum = 0;
//		cin >> singleCollection[i].id >> singleCollection[i].father >> singleCollection[i].mother >> childNum;
//		visit[singleCollection[i].id] = true;
//		if (singleCollection[i].father != -1)
//		{
//			visit[singleCollection[i].father] = true;
//			Unions(singleCollection[i].id, singleCollection[i].father);
//		}
//		if (singleCollection[i].mother != -1)
//		{
//			visit[singleCollection[i].mother] = true;
//			Unions(singleCollection[i].id, singleCollection[i].mother);
//		}
//		for (int j = 0; j < childNum; j++)
//		{
//			cin >> singleCollection[i].child[j];
//			visit[singleCollection[i].child[j]] = true;
//			Unions(singleCollection[i].id, singleCollection[i].child[j]);
//		}
//		cin >> singleCollection[i].sumHouse >> singleCollection[i].area;
//	}
//	for (int i = 0; i < howMany; i++)
//	{
//			int currRoot = find(singleCollection[i].id);
//			familyCollection[currRoot].id = currRoot;
//			familyCollection[currRoot].sumHouse += singleCollection[i].sumHouse;
//			familyCollection[currRoot].area += singleCollection[i].area;
//			familyCollection[currRoot].Root = true;
//	}
//	for (int i = 0; i < 10000; i++)
//	{
//		if (visit[i])
//		{
//			int root = find(i);
//			familyCollection[root].num++;
//		}
//		if (familyCollection[i].Root) globalCounter++;
//	}
//	for (int i = 0; i < 10000; i++)
//	{
//		if (familyCollection[i].Root)
//		{
//			familyCollection[i].sumHouse /= familyCollection[i].num;
//			familyCollection[i].area /= familyCollection[i].num;
//		}
//	}
//	sort(familyCollection, familyCollection + 10000, cmp);
//	cout << globalCounter << endl;
//	for (int i = 0; i < globalCounter; i++)
//	{
//		printf("%04d %d %.3lf %.3lf", familyCollection[i].id, familyCollection[i].num, familyCollection[i].sumHouse, familyCollection[i].area);
//		if (i != globalCounter - 1) cout << endl;
//	}
//	return 0;
//}