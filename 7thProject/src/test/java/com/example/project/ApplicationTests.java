package com.example.project;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class ApplicationTests {

	Calculator underTest = new Calculator();
	@Test
	void itShouldAddNumbers(){
	//given
		int number1 = 20;
		int number2 = 30;
		//when
		int result = underTest.add(number1,number2);
		//then
		int expected = 50;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator{
		int add(int a, int b){
			return a + b;
		}
	}
}
