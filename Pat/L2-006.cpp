//#include<iostream>
//#include<vector>
//#include<algorithm>
//#include<queue>
//using namespace std;
//vector<int>	postOrder;
//vector<int> inOrder;
//vector<int> result;
//queue<int> que;
//struct node
//{
//	int leftChild = 0;
//	int rightChild = 0;
//}tree[100];
//int buildTree(int post_s, int post_e, int in_s, int in_e)
//{
//	if (post_s > post_e || post_s<0 || post_e<0 || in_s<0 || in_e<0) return 0;
//	if (post_s == post_e) return postOrder[post_e];
//	int root = postOrder[post_e];
//	int po = find(inOrder.begin(), inOrder.end(), root) - inOrder.begin();
//	tree[root].rightChild = buildTree(post_e - (in_e - po), post_e - 1, po + 1, in_e);
//	tree[root].leftChild = buildTree(post_s, post_s + (po - in_s - 1), in_s, po - 1);
//	return postOrder[post_e];
//
//}
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
//		postOrder.push_back(input);
//	}
//	for (int i = 0; i < num; i++)
//	{
//		cin >> input;
//		inOrder.push_back(input);
//	}
//	buildTree(0, num - 1, 0, num - 1);
//	levelTravel(postOrder[num - 1]);
//	for (int i = 0; i < result.size(); i++)
//	{
//		cout << result[i];
//		if (i != result.size() - 1) cout << " ";
//	}
//	return 0;
//}