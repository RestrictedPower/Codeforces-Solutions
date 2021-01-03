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
        int n,m;
        cin >> n >> m;
        vector<vector<int>> a(n, vector<int>(m));
        for(int i = 0; i<n; i++) for(int j = 0; j<m; j++) cin >> a[i][j];
        ll ans = 0;
        for(int i = 0; i<n; i++) for(int j = 0; j<m; j++){
            vector<int> b(3);
            b[0] = a[i][j];
            b[1] = a[n-i-1][j];
            b[2] = a[i][m-j-1];
            sort(all(b));
            a[i][j] = a[n-i-1][j] = a[i][m-j-1] = b[1];
            ans += b[2]-b[0];
        }
        cout << ans << endl;
    }

    return 0;
}