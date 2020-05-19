#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
int pre[110];
int matrix[110][110] = { 0 };
int find(int a)
{
	if (pre[a] == a) return a;
	else return find(pre[a]);
}
void unions(int a, int b)
{
	int leftFather = find(a);
	int rightFather = find(b);
	if(leftFather!=rightFather) pre[rightFather] = leftFather;
}
int main()
{
	for (int i = 0; i < 110; i++)
	{
		pre[i] = i;
	}
	int N = 0, M = 0, K = 0;
	cin >> N >> M >> K;
	for (int i = 0; i < M; i++)
	{
		int left = 0, right = 0, relation = 0;
		cin >> left >> right >> relation;
		matrix[left][right] = relation;
		matrix[right][left] = relation;
		if(relation==1)	unions(left, right);
	}
	int qleft = 0, qright = 0;
	
	for (int i = 0; i < K; i++)
	{
		cin >> qleft >> qright;
		if (find(qleft) != find(qright))
		{
			if (matrix[qleft][qright] == 0) cout << "OK";
			else if (matrix[qleft][qright] == -1) cout << "No way";
		}
		else
		{
			if (matrix[qleft][qright] == 1) cout << "No problem";
			else if (matrix[qleft][qright] == -1) cout << "OK but...";
		}
		if (i != K - 1) cout << endl;
	}
	return 0;
}
