#define MOD 1000000007
/*-------------------------------Start Snippet------------------------------------------
AUTHOR: spexcher
Name: Gourab Modak
email: spexcher@gmail.com
Institution: Indian Institute of Technology Madras(BS UG Data Science 4 year) + Jalpaiguri Government Engineering College (B. Tech UG CSE 4 year)
Linktree: https://linktr.ee/spexcher
Github: https://github.com/spexcher/
linkedin : https://www.linkedin.com/in/gourabmodak/
codeforces : https://codeforces.com/profile/spexcher/
codechef : https://www.codechef.com/users/spexcher/
leetcode : https://leetcode.com/spexcher/
------------------------------------------------------------------------------------*/
#include <bits/stdc++.h>
using namespace std;
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
template <typename T>
using pbds = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;

using ll = long long;
using ld = long double;
using uint = unsigned int;
using ull = unsigned long long;
template <typename T>
using pair2 = pair<T, T>;
using pii = pair<int, int>;
using pli = pair<ll, int>;
using pll = pair<ll, ll>;
#define ll long long
#define ull unsigned long long
#define lld long double
#define mod MOD
#define eb emplace_back
#define pb push_back
#define ppb pop_back

// #define int long long
//  disable this in storage constrained problems
//  now int behaves as it should
//  but if you need long long then use ll
#define sqrt(x) sqrtl((x))
#define ceil(x) ceill((x))
#define floor(x) floorl((x))
#define ceildiv(a, b) ((a + b - 1) / b)
#define vi vector<int>
#define vll vector<ll>
#define vvb vector<vector<bool>>
#define vvc vector<vector<char>>
#define vb vector<bool>
#define vc vector<char>
#define vs vector<string>
#define vvi vector<vector<int>>
#define vvll vector<vector<ll>>
#define vvb vector<vector<bool>>
#define vvpii vector<vector<pii>>
#define vvpll vector<vector<pll>>
#define vpii vector<pii>
#define vpll vector<pll>
#define si set<int>
#define sll set<ll>
#define sc set<char>
#define mii map<int, int>
#define mll map<ll, ll>
#define mci map<char, int>
#define mcll map<char, ll>
#define pqi priority_queue<int>
#define pqll priority_queue<ll>

#define lb lower_bound
#define ub upper_bound
#define mp make_pair
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define sortall(x) sort(all(x))
#define ff first
#define ss second
#define spre(x) cout << fixed << setprecision(x)
#define PI 3.1415926535897932384626
#define py cout << "YES\n"
#define pm cout << "-1\n"
#define pn cout << "NO\n"
#define pm cout << "-1\n"
#define pl cout << "\n"
#define nl "\n"
#define sp " "
#define print(x) cout << x << "\n"
#define deb(x) cout << #x << "=" << x << endl
#define upper(s1) transform(s1.begin(), s1.end(), s1.begin(), ::toupper)
#define lower(s1) transform(s1.begin(), s1.end(), s1.begin(), ::tolower)
#define maxe(v) *max_element(v.begin(), v.end())
#define mine(v) *min_element(v.begin(), v.end())
#define unq(v) v.resize(distance(v.begin(), unique(all(v))))
#define sum(v) accumulate(all(v), 0)
#define sz(x) (ll) x.size()
#define deb2(x, y) cout << #x << "=" << x << "," << #y << "=" << y << endl
#define gc getchar_unlocked
#define fo(i, n) for (int i = 0; i < n; i++)
#define forr(i, n) for (int i = n - 1; i >= 0; i--)
#define Fo(i, k, n) for (int i = k; k < n ? i < n : i > n; k < n ? i += 1 : i -= 1)
#define setbits(n) __builtin_popcountll(n)
#define counttz(n) __builtin_ctzll(n)
#define countlz(n) __builtin_clzll(n)
clock_t startTime;
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());

void modadd(int &a, int b) { a = ((a % MOD) + (b % MOD)) % MOD; }
void modsub(int &a, int b) { a = ((a % MOD) - (b % MOD) + MOD) % MOD; }
void modmul(int &a, int b) { a = ((a % MOD) * (b % MOD)) % MOD; }

//-------------------- take ip/op like vector,pairs directly! -----------------------------
template <typename typC, typename typD>
istream &operator>>(istream &cin, pair<typC, typD> &a) { return cin >> a.first >> a.second; }
template <typename typC>
istream &operator>>(istream &cin, vector<typC> &a)
{
    for (auto &x : a)
        cin >> x;
    return cin;
}
template <typename typC, typename typD>
ostream &operator<<(ostream &cout, const pair<typC, typD> &a) { return cout << a.first << ' ' << a.second; }
template <typename typC, typename typD>
ostream &operator<<(ostream &cout, const vector<pair<typC, typD>> &a)
{
    for (auto &x : a)
        cout << x << '\n';
    return cout;
}
template <typename typC>
ostream &operator<<(ostream &cout, const vector<typC> &a)
{
    int n = a.size();
    if (!n)
        return cout;
    cout << a[0];
    for (int i = 1; i < n; i++)
        cout << ' ' << a[i];
    return cout;
}
//----------------------END Of the input module --------------------

double getCurrentTime()
{
    return (double)(clock() - startTime) / CLOCKS_PER_SEC;
}

ll fpow(ll x, ll y)
{
    ll res = 1;
    x = x % mod;
    if (x == 0)
        return 0;
    while (y > 0)
    {
        if (y & 1LL)
            res = (res * x) % mod;
        y = y >> 1LL;
        x = (x * x) % mod;
    }
    return res;
}
ll inv(ll a, ll p = mod) { return fpow(a, p - 2); }

class Matrix
{
private:
    vector<vector<int>> data;
    int rows;
    int cols;

public:
    Matrix(int r, int c, const vector<vector<int>> &values) : rows(r), cols(c), data(values) {}
    // Display function
    void display() const
    {
        for (int i = 0; i < rows; ++i)
        {
            for (int j = 0; j < cols; ++j)
            {
                cout << data[i][j] << " ";
            }
            cout << endl;
        }
    }

    // Friend functions for overloading ++ and --
    friend Matrix &operator++(Matrix &mat);     // Pre-increment
    friend Matrix operator++(Matrix &mat, int); // Post-increment
    friend Matrix &operator--(Matrix &mat);     // Pre-decrement
    friend Matrix operator--(Matrix &mat, int); // Post-decrement
};

// Pre-increment
Matrix &operator++(Matrix &mat)
{
    for (int i = 0; i < mat.rows; ++i)
    {
        for (int j = 0; j < mat.cols; ++j)
        {
            ++mat.data[i][j];
        }
    }
    return mat;
}

// Post-increment
Matrix operator++(Matrix &mat, int)
{
    Matrix temp(mat);
    ++mat;
    return temp;
}

// Pre-decrement
Matrix &operator--(Matrix &mat)
{
    for (int i = 0; i < mat.rows; ++i)
    {
        for (int j = 0; j < mat.cols; ++j)
        {
            --mat.data[i][j];
        }
    }
    return mat;
}

// Post-decrement
Matrix operator--(Matrix &mat, int)
{
    Matrix temp(mat);
    --mat;
    return temp;
}

int main()
{
    int nrows, ncols;
    cout << "Enter dimensions" << endl;
    cin >> nrows >> ncols;
    cout << "Enter matrix row-wise" << endl;
    vvi v(nrows, vi(ncols));
    cin >> v;

    Matrix m(nrows, ncols, v);
    cout << "Original Matrix:" << endl;
    m.display();

    cout << "After Pre-Increment:" << endl;
    ++m;
    m.display();

    cout << "After Post-Increment:" << endl;
    Matrix m2 = m++;
    m.display();
    cout << "Post-Incremented Matrix:" << endl;
    m2.display();

    cout << "After Pre-Decrement:" << endl;
    --m;
    m.display();

    cout << "After Post-Decrement:" << endl;
    Matrix m3 = m--;
    m.display();
    cout << "Post-Decremented Matrix:" << endl;
    m3.display();

    return 0;
}
