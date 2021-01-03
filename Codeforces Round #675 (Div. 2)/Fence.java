#include <bits/stdc++.h>
using namespace std;
#define all(a) a.begin(), a.end()
typedef long long ll;
int main(){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    int t;
    cin >> t;
    while(t--){
        ll a,b,c;
        cin >> a >> b >> c;
        cout << a+b+c-1 << endl;
    }

    return 0;
}