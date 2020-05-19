//#include<iostream>
//#include<vector>
//#include<algorithm>
//#include<queue>
//using namespace std;
//vector<int>	preOrder;
//vector<int> inOrder;
//vector<int> result;
//queue<int> que;
//struct node
//{
//	int leftChild = 0;
//	int rightChild = 0;
//}tree[100];
//
//int buildTree(int pre_s, int pre_e, int in_s, int in_e)
//{
//	if (pre_s > pre_e || pre_s<0 || pre_e<0 || in_s<0 || in_e<0) return 0;
//	if (pre_s == pre_e) return preOrder[pre_s];
//	int root = preOrder[pre_s];
//	int po = find(inOrder.begin(), inOrder.end(), root) - inOrder.begin();
//	tree[root].rightChild = buildTree(pre_s + 1, pre_s + (po - in_s), in_s, po - 1);
//	tree[root].leftChild = buildTree(pre_s + (po - in_s + 1), pre_e, po + 1, in_e);
//	return preOrder[pre_s];
//}
//
//void levelTravel(int root)
//{
//	result.push_back(root);
//	if (tree[root].leftChild != 0) que.push(tree[root].leftChild);
//	if (tree[root].rightChild != 0) que.push(tree[root].rightChild);
//	while (!que.empty())
//	{
//		int p = que.front();
//		que.pop();
//		levelTravel(p);
//	}
//}
//int main()
//{
//
//	int num = 0;
//	cin >> num;
//	int input = 0;
//	for (int i = 0; i < num; i++)
//	{
//		cin >> input;
//		inOrder.push_back(input);
//	}
//	for (int i = 0; i < num; i++)
//	{
//		cin >> input;
//		preOrder.push_back(input);
//	}
//	buildTree(0, num - 1, 0, num - 1);
//	levelTravel(preOrder[0]);
//	for (int i = 0; i < result.size(); i++)
//	{
//		cout << result[i];
//		if (i != result.size() - 1) cout << " ";
//	}
//	return 0;
//}