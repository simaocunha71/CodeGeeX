
fn main(){ 
 } 

use std::{slice::Iter, cmp::{max, self}, mem::replace, collections::{HashSet, HashMap}, ops::Index, ascii::AsciiExt};
use rand::Rng;
use regex::Regex;
use md5;
use std::any::{Any, TypeId};

fn below_zero(operations:Vec<i32>) -> bool{

/*
 You're given a list of deposit and withdrawal operations on a bank account that starts with
    zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
    at that point function should return True. Otherwise it should return False.
    
*/
#include <iostream>
#include <iomanip>
using namespace std;
int main() {
    double balance = 0;
    int operations = 0;
    double total = 0;
    for (int i = 0; i < 15; ++i) {
        if (i != 2 && i % 2 == 1) continue;
        operations += 1; //deposit or withdraw
        total += 1;
        if ((i + 1) % 2 == 0) continue;
         balance = total;
    }
    cout << setprecision(5) << fixed << "Balance: "<< balance<<endl;
    return 0;
}

#[cfg(test)]
mod tests {
    use super::*;

#[test]
    fn test_below_zero() {
        assert_eq!(below_zero(vec![]), false);
        assert_eq!(below_zero(vec![1, 2, -3, 1, 2, -3]), false);
        assert_eq!(below_zero(vec![1, 2, -4, 5, 6]), true);
        assert_eq!(below_zero(vec![1, -1, 2, -2, 5, -5, 4, -4]), false);
        assert_eq!(below_zero(vec![1, -1, 2, -2, 5, -5, 4, -5]), true);
        assert_eq!(below_zero(vec![1, -2, 2, -2, 5, -5, 4, -4]), true);
    }

}
