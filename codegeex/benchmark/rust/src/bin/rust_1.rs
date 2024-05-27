
fn main(){ 
 } 

use std::{slice::Iter, cmp::{max, self}, mem::replace, collections::{HashSet, HashMap}, ops::Index, ascii::AsciiExt};
use rand::Rng;
use regex::Regex;
use md5;
use std::any::{Any, TypeId};

fn separate_paren_groups(paren_string: String) -> Vec<String>{

/*
 Input to this function is a string containing multiple groups of nested parentheses. Your goal is to
    separate those group into separate strings and return the list of those.
    Separate groups are balanced (each open brace is properly closed) and not nested within each other
    Ignore any spaces in the input string.
    
*/
const separateNestedParentheses = str => {
  const stack = []
  for (let i = 0; i < str.length; i += 1) {
    if (!str[i].match(/\(/)) break
    else if (str[i].match(/(\w+)\s*?\)/)) { // a word with parentheses after it, e.g., ("foo" (bar baz))
      stack.push([]) // add empty array to top of stack
      let w = str[i]//current character in string
      while (!str[stack[stack.length - 1].length].match(/\w+/)) { // as long as there is no word before the parentheses, continue pushing them onto the stack
        if (str[stack[stack.length - 1].length] === '(') { // if character in string matches open-paren, push that character onto the top of the stack
          stack.push([']')
          break
        } else {
          stack.pop()
        }
      }
      let r = str[i + 1].match(/\w+(?=\))/) // word immediately after parentheses (which ends in )/), e.g., ("foo" (bar baz))
      while (r && r[1] !== '') { // as long as there is a word after the parentheses, push that word onto the stack
        let s = str[i + 1].match(/\w+/) // extract current word from string
        while (!str[stack[stack.length - 1].length + 1].match(/(\w+)\s*?\)/)) { // as long as there is no word after the parentheses, continue pushing that onto the stack
          if (str[stack[stack.length - 1].length] === '(') { // match character in string to open-paren, push that character onto top of stack
            stack.push([']')
            break
          } else {
            stack.pop()
          }
        }
        r = str[i + 2].match(/\w+(?=\))/) // extract next word after parentheses (which ends in )/), e.g., ("foo" (bar baz))
      }
      if (!r) break // no more

#[cfg(test)]
mod tests {
    use super::*;

#[test]
    fn test_separate_paren_groups() {
        assert_eq!(
            separate_paren_groups(String::from("(()()) ((())) () ((())()())")),
            vec!["(()())", "((()))", "()", "((())()())"]
        );
        assert_eq!(
            separate_paren_groups(String::from("() (()) ((())) (((())))")),
            vec!["()", "(())", "((()))", "(((())))"]
        );
        assert_eq!(
            separate_paren_groups(String::from("(()(())((())))")),
            vec!["(()(())((())))"]
        );
        assert_eq!(
            separate_paren_groups(String::from("( ) (( )) (( )( ))")),
            vec!["()", "(())", "(()())"]
        );
    }

}
