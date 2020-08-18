## CS569 - Special Topics in Computer Science

#### Assignment 1
**Group members :
Yi Ren (002269013)&ensp;&ensp;    Wentao Lu (002276355)**
<br></br>  
#### II. Syntax errors

**[ b. ]**
<div align=center><img src="http://15.222.11.163/wp-content/uploads/2020/06/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200612224302.png" width="90%" height="90%"></div>  
</br>

**Answer**  
Error:(6, 8) java: class Helo is public, should be declared in a file named Helo.java    
<br></br>  

**[ c. ]**  
<div align=center><img src="http://15.222.11.163/wp-content/uploads/2020/06/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200612165759.png" width="50%" height="50%"></div>  
</br>

**Answer**  
The propram succeeded to compile because there's no syntax error. Only the string printed got changed.  


**[ d. ]**
<div align=center><img src="http://15.222.11.163/wp-content/uploads/2020/06/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200612224306.png" width="90%" height="90%"></div>  
</br>

**Answer**  
Error:(13, 42) java: unclosed string literal
<br></br>  

**[ e. ]**
<div align=center><img src="http://15.222.11.163/wp-content/uploads/2020/06/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200612224311.png" width="90%" height="90%"></div>  
</br>

**Answer**  
Error:(13, 41) java: ')' expected  
Error:(13, 42) java: unclosed string literal
<br></br>  

**[ f. ]**
<div align=center><img src="http://15.222.11.163/wp-content/uploads/2020/06/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200612224314.png" width="90%" height="90%"></div>  
</br>

**Answer**  
Error:(10, 45) java: ';' expected

<br></br>  


#### V. Two Meanings of Plus

**[ c. ]**   
The last three statements:    
<center>
8 plus 5 is 85  

8 plus 5 is 13   
13 equals 8 plus 5.  </center>
**Answer**  
1. There are no parentheses so the expression is evaluated left to right. For the first operator, one operand is a string, the other is an integer. So the '+' is the concatenation operator. For the second operator, the operand before has been converted to a string, in this way, the second '+' should also be the concatenation operator.  

2. With parentheses inside, the second '+' should be evaluated preferentially. So the second '+' is an ordinary addition, while the first '+' should be the concatenation operator.  

3. There are no parentheses so the expression is evaluated left to right. For the first '+', both operands are integers, and it should be an ordinary addition operator. For the Second '+', one of the operands is a string, so it is a concatenation operator.

**[ d. ]**
<div align=center><img src="http://15.222.11.163/wp-content/uploads/2020/06/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200612224335.png" width="90%" height="90%"></div>  
</br>

**Answer**  
Add spaces to strings which are adjacent to the integer, like this:

<div align=center><img src="http://15.222.11.163/wp-content/uploads/2020/06/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200612204814.png" width="50%" height="50%"></div>  
</br>
