//#include<iostream>
//#include<algorithm>
//#include<vector>
//#include<queue>
//using namespace std;
//struct node
//{
//	int value = 0;
//	int leftChild = -1;
//	int rightChild = -1;
//	int mark = -1;
//	int levelTravelMark = -1;
//}tree[30];
//queue<int> qu;
//vector<int> vt;
//int globalCounter = 1;
//bool completeBinarySerachTree = true;
//void buildTree(int parentNode,int value,int index)
//{
//	if (tree[parentNode].value > value)
//	{
//		if (tree[parentNode].rightChild == -1)
//		{
//			tree[parentNode].rightChild = index;
//			tree[index].mark = tree[parentNode].mark * 2 + 1;
//			return;
//		}
//		else
//		{
//			buildTree(tree[parentNode].rightChild, value, index);
//		}
//	}
//	else
//	{
//		if (tree[parentNode].leftChild == -1)
//		{
//			tree[parentNode].leftChild = index;
//			tree[index].mark = tree[parentNode].mark * 2;
//			return;
//		}
//		else
//		{
//			buildTree(tree[parentNode].leftChild, value, index);
//		}
//	}
//}
//void levelTravel(int root)
//{
//	vt.push_back(tree[root].value);
//	if (tree[root].leftChild != -1) qu.push(tree[root].leftChild);
//	if (tree[root].rightChild != -1) qu.push(tree[root].rightChild);
//	while (!qu.empty())
//	{
//		if (tree[root].mark != globalCounter) completeBinarySerachTree = false;
//		globalCounter++;
//		int input = qu.front();
//		qu.pop();
//		return levelTravel(input);
//	}
//	if (tree[root].mark != globalCounter) completeBinarySerachTree = false;
//}
//int main()
//{
//	int num = 0;
//	cin >> num;
//	int input = 0;
//	cin >> input;
//	tree[0].value = input;
//	tree[0].mark = 1;
//	tree[0].levelTravelMark = 1;
//	for (int i = 1; i < num; i++)
//	{
//		cin >> input;
//		tree[i].value = input;
//		buildTree(0, input, i);
//	}
//	levelTravel(0);
//	for (int i = 0; i < vt.size(); i++)
//	{
//		cout << vt[i];
//		if (i != vt.size() - 1) cout << " ";
//	}
//	cout << endl;
//	cout << (completeBinarySerachTree ? "YES" : "NO");
//	return 0;
//}