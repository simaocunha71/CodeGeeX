
fn main(){ 
 } 

use std::{slice::Iter, cmp::{max, self}, mem::replace, collections::{HashSet, HashMap}, ops::Index, ascii::AsciiExt};
use rand::Rng;
use regex::Regex;
use md5;
use std::any::{Any, TypeId};

fn has_close_elements(numbers:Vec<f32>, threshold: f32) -> bool{

/*
 Check if in given list of numbers, are any two numbers closer to each other than
    given threshold.
    
*/
#include<bits/stdc++.h>
using namespace std;
int main() {
	//freopen("infile.txt","r",stdin);
	ios_base::sync_with_stdio(0);
   ios_base::tie (0)
    ios_base::fill (0)
    ios_base::sync_with_stdio(0);
	int t;
	cin>>t;
    while(t--){
        cin>>a[0];
        cin>>b[0];
        for(int i=1;i<9;i++)
            cin>>c[i];
        sort (c, c+8);
        int d,e;
        cin>>d;
        if(!d){
            cout<<"no\n";
            continue;
        }else{
            cin>>e;
            //cout<<d<<" "<<e<<endl;
            bool ans=false;
            for(int i=0;i<8;i++){
                if (abs((c[i]-b[0])) < d && abs((c[i+1]-b[0])>e) ){//if b is close to c or a and there is an e which makes it closer, than we return false
                    ans = true;
                }else if (abs((d-(c[8] -b[0])) < d && abs((e+1-b[0])>e) ) {//if b is close to c or a and there is an e which makes it closer, then we return false.
                    ans = true;
                }else{
                    ans=false;//otherwise return false.
                }
            }
            //cout<<ans<<endl;
            if(ans){
                cout<<"yes\n";
            }else{
                cout<<"no\n";
            }
        }
    }
	return 0;
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_has_close_elements() {
        assert_eq!(has_close_elements(vec![11.0, 2.0, 3.9, 4.0, 5.0, 2.2], 0.3), true);
        assert_eq!(has_close_elements(vec![1.0, 2.0, 3.9, 4.0, 5.0, 2.2], 0.05), false);
        assert_eq!(has_close_elements(vec![1.0, 2.0, 5.9, 4.0, 5.0], 0.95), true);
        assert_eq!(has_close_elements(vec![1.0, 2.0, 5.9, 4.0, 5.0], 0.8), false);
        assert_eq!(has_close_elements(vec![1.0, 2.0, 3.0, 4.0, 5.0, 2.0], 0.1), true);
        assert_eq!(has_close_elements(vec![1.1, 2.2, 3.1, 4.1, 5.1], 1.0), true);
        assert_eq!(has_close_elements(vec![1.1, 2.2, 3.1, 4.1, 5.1], 0.5), false);
    }

}
