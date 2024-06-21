
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
int main()
{
	vector<double>v;
	vector<int>a;
	double thresh=10000,dist=9999;
	for(int i = 0 ;i<10;++i)
    {
        if(!cin>>a[i])break;
        v.push_back(a[i]);
        dist = min(dist,(v[a[i]-1] - v[a[i]]));
    	if(dist<thresh)
		{
		cout<<a[i]<<" "<<dist<<endl;
            thresh=min(thresh,dist);
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
