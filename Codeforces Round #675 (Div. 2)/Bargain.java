#include <bits/stdc++.h>
using namespace std;
#define all(a) a.begin(), a.end()
typedef long long ll;
ll mod = 1e9+7;
ll mul(ll a, ll b){
    return ((a%mod)*(b%mod))%mod;
}
ll add(ll a, ll b){
    return ((a%mod)+(b%mod)+mod)%mod;
}
ll c(ll n){
    return add(n*(n+1)/2, 0);
}
int main(){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);  
    string s;
    int n;
    cin >> s;
    n = s.length();
    vector<ll> mp(n+1);
    mp[1] = 1;
    for(int i = 2; i<n+1; i++) mp[i] = mul(mp[i-1],10);
    ll ans = 0, sum = 0;
    for(int i = 0; i<n; i++){
        ll v = s[i]-'0';
        ll front = mul(mul(c(i), mp[n-i]), v);
        ll after = mul(mul(n-i, mp[n-i]), sum);
        sum = add(sum,v);
        ans = add(add(front, after),ans);
    }
    cout << ans << endl;
    return 0;
}