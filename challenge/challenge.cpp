#include <iostream>
using namespace std;
int main() {
  string s;
  string t;
  int n = s.length()-1;

  cin >> s >> t;

  for(int i = 0; i<(s.length() / 2); i++) {
    swap(s[i], s[n]);
    n = n-1;
  }

  cout << s;



  return 0;

}
